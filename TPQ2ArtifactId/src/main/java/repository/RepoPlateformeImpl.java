package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import exceptions.HotelAlreadyExistsException;
import exceptions.HotelNotFoundException;
import model.Adresse;
import model.AdresseType;
import model.Agence;
import model.CarteCredit;
import model.Chambre;
import model.Client;
import model.Employee;
import model.GPS;
import model.Propose;
import model.Hotel;
import model.HotelPartenaireTarif;
import model.Lit;

public class RepoPlateformeImpl implements IRepoPlateforme {
	/* ATTRIBUTES */
	private List<Hotel> hotelCollection = new ArrayList<>();
	private List<Agence> agenceCollection = new ArrayList<>();
//	private Agence agenceLogin;
	private List<Employee> employees;

	
	/* CONSTRUCTORS */
	public RepoPlateformeImpl() {
		employees = new ArrayList<>();
		employees.addAll(Arrays.asList(
				new Employee(1, "Joe"),
				new Employee(2, "Jane"),
				new Employee(3, "Steve"),
				new Employee(4, "Alice"),
				new Employee(5, "Bob"),
				new Employee(6, "Alicia"),
				new Employee(7, "Tricia"),
				new Employee(8, "Paul"),
				new Employee(9, "Kevin"),
				new Employee(10, "Julia")
		));
		// Hotel(1, "Campanile Montpellier Est Le Millénaire")
		GPS gps1 = new GPS(43.60921999607663, 3.9145600068916337);
		Adresse adresse1 = new Adresse("France", "Montpellier", 1083, "34000", "Henri Becquerel", AdresseType.rue, gps1);
		List<Lit> litCollection1_1 = new ArrayList<>();
		litCollection1_1.addAll(Arrays.asList(
			new Lit("lit jumeaux", 1),
			new Lit("lit jumeaux", 1)
		));
		List<Lit> litCollection1_2 = new ArrayList<>();
		litCollection1_2.addAll(Arrays.asList(
			new Lit("lit double", 2)
		));
		List<Lit> litCollection1_3 = new ArrayList<>();
		litCollection1_3.addAll(Arrays.asList(
			new Lit("lit simple", 1),
			new Lit("lit double", 2)
		));
		List<Chambre> chambreCollection1 = new ArrayList<>(); 
		chambreCollection1.addAll(Arrays.asList(
			new Chambre("campanile1", 79, 17, litCollection1_1),
			new Chambre("campanile2", 83, 17, litCollection1_2),
			new Chambre("campanile3", 83, 17, litCollection1_3)
		));
		
		// Hotel(2, "Hotel Regina Louvre")
		GPS gps2 = new GPS(48.86380999296151, 2.3324799734784563);
		Adresse adresse2 = new Adresse("France", "Paris", 2, "75001", "des Pyramides", AdresseType.place, gps2);
		List<Lit> litCollection2_1 = new ArrayList<>();
		litCollection2_1.addAll(Arrays.asList(
			new Lit("grand lit double", 2)
		));
		List<Lit> litCollection2_2 = new ArrayList<>();
		litCollection2_2.addAll(Arrays.asList(
			new Lit("tres grand lit double", 2),
			new Lit("canape-lit", 1)
		));
		List<Lit> litCollection2_3 = new ArrayList<>();
		litCollection2_3.addAll(Arrays.asList(
			new Lit("tres grand lit double", 2),
			new Lit("canape-lit", 1)
		));
		List<Lit> litCollection2_4 = new ArrayList<>();
		litCollection2_4.addAll(Arrays.asList(
			new Lit("lit simple", 1),
			new Lit("lit superpose", 1),
			new Lit("lit superpose", 1)
		));
		List<Chambre> chambreCollection2 = new ArrayList<>(); 
		chambreCollection2.addAll(Arrays.asList(
			new Chambre("regina1", 422, 25, litCollection2_1),
			new Chambre("regina2", 768, 60, litCollection2_2),
			new Chambre("regina3", 877, 50, litCollection2_3),
			new Chambre("regina4", 750, 50, litCollection2_4)
		));
		
		Hotel hotel1 = new Hotel(1, "Campanile Montpellier Est Le Millénaire", 3, adresse1, chambreCollection1);
		Hotel hotel2 = new Hotel(2, "Hotel Regina Louvre", 5, adresse2, chambreCollection2);
		hotelCollection.add(hotel1);
		hotelCollection.add(hotel2);

		Agence agenceA = new Agence("agenceA", "agenceAmdp");
		agenceA.addHotelPartenaireTarif(hotel1, 0.9);
		agenceA.addHotelPartenaireTarif(hotel2, 0.8);
		
		Agence agenceB = new Agence("agenceB", "agenceBmdp");
		agenceB.addHotelPartenaireTarif(hotel2, 0.7);
		
		this.agenceCollection.add(agenceA);
		this.agenceCollection.add(agenceB);
	}
	
	@Override
	public Agence agenceLogin(String identifiant, String mdp) {
		for (Agence agence : this.agenceCollection) {
			if (agence.getIdentifiant().equals(identifiant) && agence.getMdp().equals(mdp)) {
				return agence;
			}
		}
		return null;
	}
	
	@Override
	public String getAgenceIdentifiant(Agence agenceLogin) {
		return agenceLogin.getIdentifiant();
	}
	
	@Override
	public Propose[] getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		return agenceLogin.allProposes(dateArrivee, dateDepart, nombrePerson);
	} 
	
	@Override
	public int getNombrePropse(Agence agenceLogin, Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		return agenceLogin.getNombrePropse(dateArrivee, dateDepart, nombrePerson);
	}
	
	@Override
	public void reserve(HotelPartenaireTarif hotelPartenaireTarif, String reservationId, Chambre[] chambreChoisi, 
			Calendar dateArrivee, Calendar dateDepart, Client client, double prix, Agence agence) {
		hotelPartenaireTarif.getHotel().reserve(hotelPartenaireTarif, reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix, agence);
	}

	@Override
	public double prixChoisi(Propose propose, Agence agenceLogin, int days) {
		return agenceLogin.prixChoisi(propose)*days;
	}
	
	@Override
	public String getHotelNom(Propose propose) {
		return propose.getHotelPartenaireTarif().getHotel().getNom();
	}
	
	@Override
	public CarteCredit createCarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee) {
		CarteCredit carteCredit = new CarteCredit(carteNumero, cvcCode, expireMois, expireAnnee);
		return carteCredit;
	}
	
	@Override
	public Client createClient(String nom, String prenom, CarteCredit carteCredit) {
		Client client = new Client(nom, prenom, carteCredit);
		return client;
	}
	
	@Override
	public HotelPartenaireTarif[] getAgencePartenaire(Agence agenceLogin) {
		List<HotelPartenaireTarif> listP = agenceLogin.getHotelPartenaireTarif();
		HotelPartenaireTarif[] p = listP.toArray(new HotelPartenaireTarif[0]);
		return p;
	}

	@Override
	public List<Employee> getEmployees() {
		return employees;
	}
}
