package Q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class CLI {
	public static final String QUIT = "0";
	public static StringToCalendar inputStringToCalendar;
	public static StringToDouble inputStringToDouble;
	public static StringToInt inputStringToInt;

	public static void main(String[] args) {
		IHotelRepo hotelCollection = new HotelRepoImpl();
		
		CLI main = new CLI();
		BufferedReader inputReader;
		String userInput = "";
		
		inputReader = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			do {
				main.menu();
				userInput = inputReader.readLine();
				main.processUserInput(inputReader, userInput, hotelCollection);
				Thread.sleep(1000);
			} while(!userInput.equals(QUIT));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Afficher tous les hotels.");
		builder.append("\n2. Afficher disponibilité de tous les hotels.");
		builder.append("\n3. Faire une réservation.");
		System.out.println(builder);
	}
	
	private void processUserInput(BufferedReader reader, 
			String userInput, IHotelRepo hotelCollection) {
		try {
			switch(userInput) {
				case "1":
					hotelCollection.getHotelCollection()
					.forEach(e -> displayHotel(e));
					break;
				case "3":
					System.out.println("Ville: ");
					String ville = reader.readLine();
					System.out.println();
					
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
					
					System.out.println("Prix minimum / nuit: ");
					inputStringToDouble = new StringToDouble(reader);
					double min = (double) inputStringToDouble.process();
					System.out.println();
					
					System.out.println("Prix maximum / nuit : ");
					inputStringToDouble = new StringToDouble(reader);
					double max = (double) inputStringToDouble.process();
					while (max <= min) {
						System.err.println("Prix maximum doit être plus de prix minimum !");
						System.out.println();
						System.out.println("Prix maximum : ");
						inputStringToDouble = new StringToDouble(reader);
						max = (double) inputStringToDouble.process();
					}
					System.out.println();
					
					System.out.println("Catégorie d'hotel (1,2,3,4,5): ");
					inputStringToInt = new StringToInt(reader);
					int categorie = (int) inputStringToInt.process();
					System.out.println();
				
					System.out.println("Nombre de personnes à héberger: ");
					inputStringToInt = new StringToInt(reader);
					int nombrePerson = (int) inputStringToInt.process();
					System.out.println();
					
					HashMap<Hotel, ArrayList<Chambre>> hotelChambrePropose = 
							hotelCollection.hotelChambrePropose(ville, dateArrivee, dateDepart, min, max, categorie, nombrePerson);

					int days = daysBetween(dateArrivee, dateDepart);
					
					if (hotelChambrePropose.size() == 0) {
						System.err.println("Désolé, pas d'hôtel correspond. Veuillez réessayer.");
						break;
					} else {
						System.out.println("Voici tous les propositions : ");
						displayPropose(hotelChambrePropose, days);
						
						// reserver
						System.out.println("Saisir le nom d'hôtel pour réserver : ");
						String nomHotel = reader.readLine();
						System.out.println();
						HashMap<Hotel, ArrayList<Chambre>> hotelChambreChoisi = getPropose(nomHotel, hotelChambrePropose);
						while (hotelChambreChoisi.size() == 0) {
							System.out.println("Faux saisie, réessayer. Saisir le nom d'hôtel pour réserver : ");
							nomHotel = reader.readLine();
							System.out.println();
							hotelChambreChoisi = getPropose(nomHotel, hotelChambrePropose);
						}
						
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
						
						CarteCredit carteCredit = new CarteCredit(carteNumero, cvcCode, expireMois, expireAnnee);
						Client client = new Client(nom, prenom, carteCredit);
						
						Hotel hotelChoisi = hotelChambreChoisi.keySet().stream().findFirst().get();
						ArrayList<Chambre> chambreChoisi = hotelChambreChoisi.get(hotelChoisi);
						double prix = hotelChoisi.prixChambresPropose(chambreChoisi)*days;

						int reservationId = hotelChoisi.getReservCollection().size()+1;
						try {
							hotelChoisi.reserve(reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix);
							System.out.println("Réservé avec succès. Votre numéro de réservation est "+reservationId);
						} catch (Exception e) {
							System.err.println("Désolé, il y a un problème avec la réservation. Veuillez réessayer.");
						}
					}
					break;
				case QUIT:
					System.out.println("Au revoir ...");
					return;
				default:
					System.err.println("Désolé, mauvaise saisie. Veuillez réessayer.");
					return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void displayHotel(Hotel hotel) {
		System.out.println("ID: "+hotel.getHotelId()+ 
				", Hotel Name: "+hotel.getNom());
	}
	
	private static void displayPropose(HashMap<Hotel, ArrayList<Chambre>> hotelChambrePropose, int days) {
		for (Hotel hotel : hotelChambrePropose.keySet()) {
			String descLit = "";
			int nombreLits = 0;
			for (Chambre c : hotelChambrePropose.get(hotel)) {
				System.err.println(c.toString());
				for (Lit lit : c.getLitCollection()) {
					descLit = descLit + lit.toString() + "\n";
					nombreLits++;
				}
			}
			System.out.println(
					"Nom de l'hôtel : " + hotel.getNom() + "\n" +
					"Catégorie : " + hotel.getCategorie() + " étoiles" + "\n" +
					"Adresse de l’hôtel : " + hotel.getAdresse().toString() + "\n" +
					"Prix total à payer : " + hotel.prixChambresPropose(hotelChambrePropose.get(hotel))*days + " (Pour " + days + " nuits)" + "\n" +
					"nombre de lits proposés : " + nombreLits + "\n" + 
					descLit
			);
		}
	}
	
	private static int daysBetween(Calendar dateArrivee, Calendar dateDepart) {
		Date d1 = dateArrivee.getTime();
		Date d2 = dateDepart.getTime();
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	private static HashMap<Hotel, ArrayList<Chambre>> getPropose(String nomHotel, HashMap<Hotel, ArrayList<Chambre>> hotelChambrePropose) {
		HashMap<Hotel, ArrayList<Chambre>> hotelChambreChoisi = new HashMap<Hotel, ArrayList<Chambre>>();
		for (Hotel hotel : hotelChambrePropose.keySet()) {
			if (hotel.getNom().equals(nomHotel)) {
				hotelChambreChoisi.put(hotel, hotelChambrePropose.get(hotel));
			}
		}
		return hotelChambreChoisi;
	}
}
