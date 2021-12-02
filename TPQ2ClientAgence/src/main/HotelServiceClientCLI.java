package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import service1.Agence;
import service1.Hotel;
import service1.IHotelServiceWeb1;
import service2.CarteCredit;
import service2.Chambre;
import service2.Client;
import service2.IHotelServiceWeb2;
import service2.Lit;

public class HotelServiceClientCLI {
	public static final String QUIT = "0";
	public static StringToCalendar inputStringToCalendar;
	public static StringToDouble inputStringToDouble;
	public static StringToInt inputStringToInt;
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url1 = new URL("http://localhost:8080/serviceweb1?wsdl");
		URL url2 = new URL("http://localhost:8080/serviceweb2?wsdl");
		
		service1.HotelServiceWeb1ImplService hotelServiceWeb1Impl = new service1.HotelServiceWeb1ImplService(url1);
		service1.IHotelServiceWeb1 proxy1 = hotelServiceWeb1Impl.getHotelServiceWeb1ImplPort();
		
		service2.HotelServiceWeb2ImplService hotelServiceWeb2Impl = new service2.HotelServiceWeb2ImplService(url2);
		service2.IHotelServiceWeb2 proxy2 = hotelServiceWeb2Impl.getHotelServiceWeb2ImplPort();
		
		HotelServiceClientCLI main = new HotelServiceClientCLI();
		BufferedReader inputReader;
		String userInput = "";
		
		inputReader = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			do {
				main.menu();
				userInput = inputReader.readLine();
				main.processUserInput(inputReader, userInput, proxy1, proxy2);
				Thread.sleep(1000);
			} while(!userInput.equals(QUIT));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Agence Login :");
		System.out.println(builder);
	}
	
	private void processUserInput(BufferedReader reader, String userInput, IHotelServiceWeb1 proxy1, IHotelServiceWeb2 proxy2) {
		try {
			switch(userInput) {
				default:
					System.err.println("Désolé, mauvaise saisie. Veuillez réessayer.");
					return;
				case QUIT:
					System.out.println("Au revoir ...");
					return;
				case "1":
					Agence agenceLogin = this.login(reader, proxy1);
					while (agenceLogin != null) {
						System.err.println("Identifiant ou mot de passe n'est pas correct, veuillez réessayer !");
						agenceLogin = this.login(reader, proxy1);
					}
					System.out.println(proxy1.getAgenceIdentifiant(agenceLogin)+" login avec succès !");

					System.out.println("Date arrivée (dd/MM/yyyy): ");
					inputStringToCalendar = new StringToCalendar(reader);
					Calendar dateArrivee = (Calendar) inputStringToCalendar.process();
					System.out.println();
					
					System.out.println("Date départ (dd/MM/yyyy): ");
					inputStringToCalendar = new StringToCalendar(reader);
					Calendar dateDepart = (Calendar) inputStringToCalendar.process();
					while (!dateDepart.after(dateArrivee)) {
						System.err.println("Date départ doit être après date arrivée !");
						System.out.println();
						System.out.println("Date départ (dd/MM/yyyy): ");
						inputStringToCalendar = new StringToCalendar(reader);
						dateDepart = (Calendar) inputStringToCalendar.process();
					}
					System.out.println();
							
					System.out.println("Nombre de personnes à héberger: ");
					inputStringToInt = new StringToInt(reader);
					int nombrePerson = (int) inputStringToInt.process();
					System.out.println();
					
					HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> allCombinations = 
							proxy1.getAllCombinations(agenceLogin, dateArrivee, dateDepart, nombrePerson).getAllCombinations();
					
					if (allCombinations.size() == 0) {
						System.err.println("Désolé, pas d'hôtel correspond. Veuillez réessayer.");
						break;
					} else {
						System.out.println("Voici tous les propositions : ");
						int days = daysBetween(dateArrivee, dateDepart);
						this.displayAllCombinations(allCombinations, dateArrivee, dateDepart, agenceLogin, days, proxy1);	
					
						// IHotelServiceWeb2 reserver
						System.out.println("Saisir l‘identifiant de l'offre pour réserver : ");
						String identifiantOffre = reader.readLine();
						System.out.println();
						HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> offreChoisi = getPropose(allCombinations, identifiantOffre);
						while (offreChoisi.size() == 0) {
							System.err.println("Désolé, pas d'hôtel correspond. Veuillez réessayer.");
							System.out.println("Saisir l‘identifiant de l'offre pour réserver : ");
							identifiantOffre = reader.readLine();
							System.out.println();
							offreChoisi = getPropose(allCombinations, identifiantOffre);
						}
						String identifiantChoisi = offreChoisi.keySet().iterator().next();
						HashMap<Hotel, ArrayList<Chambre>> hcgroup = offreChoisi.get(identifiantChoisi);
						Hotel hotelChoisi = hcgroup.keySet().iterator().next();
						ArrayList<Chambre> chambreChoisi = hcgroup.get(hotelChoisi);
//						double prixChoisi = hotelChoisi.prixChambresPropose(chambreChoisi, agenceLogin)*days;
						double prixChoisi = proxy1.prixChoisi(hotelChoisi, chambreChoisi, agenceLogin, days);
						
						System.out.println("Offre "+identifiantChoisi+" est choisi.");
						// Agence login
						service2.Agence agenceLoginRes = this.loginRes(reader, proxy2);
						while (agenceLoginRes != null || !agenceLoginRes.equals(agenceLogin)) {
							System.err.println("Identifiant ou mot de passe n'est pas correct, veuillez réessayer !");
							agenceLoginRes = this.loginRes(reader, proxy2);
						}
						System.out.println(proxy1.getAgenceIdentifiant(agenceLogin)+" login avec succès !");
						// Client
						System.out.println("Nom de client principal : ");
						String nom = reader.readLine();
						System.out.println();
						
						System.out.println("Prenom de client principal : ");
						String prenom = reader.readLine();
						System.out.println();
						
							// carte credit
						System.out.println("Numéro de carte crédit (16 chiffres) : ");
						String carteNumero = reader.readLine();
						System.out.println();
						
						System.out.println("Mois expiré (2 chiffres) : ");
						inputStringToInt = new StringToInt(reader);
						int expireMois = (int) inputStringToInt.process();
						System.out.println();
						
						System.out.println("Année expirée (4 chiffres) : ");
						inputStringToInt = new StringToInt(reader);
						int expireAnnee = (int) inputStringToInt.process();
						System.out.println();
						
						System.out.println("CVC code (3 chiffres) : ");
						String cvcCode = reader.readLine();
						System.out.println();
						
						CarteCredit carteCredit = proxy2.createCarteCredit(carteNumero, cvcCode, expireMois, expireAnnee);
						Client client = proxy2.createClient(nom, prenom, carteCredit);
//						Client client = new Client(nom, prenom, carteCredit);
						
						try {
							proxy2.reserve(hotelChoisi, identifiantChoisi, chambreChoisi, 
									dateArrivee, dateDepart, client, prixChoisi, agenceLoginRes);
							System.out.println("Réservé avec succès. Votre numéro de réservation est "+identifiantChoisi);
						} catch (Exception e) {
							System.err.println("Désolé, il y a un problème avec la réservation. Veuillez réessayer.");
							break;
						}
					}
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void displayAllCombinations(HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> allCombinations, 
			Calendar dateArrivee, Calendar dateDepart, Agence agenceLogin, int days, IHotelServiceWeb1 proxy1) {
		for (String offre : allCombinations.keySet()) {
			HashMap<Hotel, ArrayList<Chambre>> propose = allCombinations.get(offre);
			Hotel hotel = propose.keySet().iterator().next();
			ArrayList<Chambre> chambres = propose.get(hotel);
			String descLit = "";
			int nombreLits = 0;
			for (Chambre c : chambres) {
				for (Lit lit : c.getLitCollection()) {
					descLit = descLit + lit.toString() + "\n";
					nombreLits++;
				}
			}
			System.out.println(
					"Identifiant de l'offre : " + offre +
					"Nom de l'hôtel : " + proxy1.getHotelNom(hotel) + "\n" +
					"Nombre de lits proposés : " + nombreLits + "\n" + descLit +
					"Date de disponibilité : de " + dateArrivee + " à " + dateDepart + 
					"Prix total à payer : " + proxy1.prixChoisi(hotel, chambres, agenceLogin, days) + " (Pour " + days + " nuits)" + "\n"
			);
		}
	}
		
	private static int daysBetween(Calendar dateArrivee, Calendar dateDepart) {
		Date d1 = dateArrivee.getTime();
		Date d2 = dateDepart.getTime();
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	private Agence login(BufferedReader reader, IHotelServiceWeb1 proxy1) {
		String identifiant = null;
		String mdp = null;
		try {
			System.out.println("Veuillez login pour rechercher !");
			System.out.println("Saisir identifiant de l'agence :");
			
			identifiant = reader.readLine();
			System.out.println();
			
			System.out.println("Saisir mot de passe de l'agence :");
			mdp = reader.readLine();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return proxy1.agenceLogin(identifiant, mdp);
	}
	
	private service2.Agence loginRes(BufferedReader reader, IHotelServiceWeb2 proxy2) {
		String identifiant = null;
		String mdp = null;
		try {
			System.out.println("Veuillez login pour reserver !");
			System.out.println("Saisir identifiant de l'agence (le même identifiant d'agence qui a récupéré les offres) :");
			identifiant = reader.readLine();
			System.out.println();
			
			System.out.println("Saisir mot de passe de l'agence :");
			mdp = reader.readLine();
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return proxy2.agenceLoginRes(identifiant, mdp);
	}
	
	private static HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> getPropose(
			HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> allCombinations, String identifiantOffre) {
		HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> offreChoisi = new HashMap<String, HashMap<Hotel, ArrayList<Chambre>>>();
		for (String offre : allCombinations.keySet()) {
			if (offre.equals(identifiantOffre)) {
				offreChoisi.put(offre, allCombinations.get(offre));
			}
		}
		return offreChoisi;
	}
	
}
