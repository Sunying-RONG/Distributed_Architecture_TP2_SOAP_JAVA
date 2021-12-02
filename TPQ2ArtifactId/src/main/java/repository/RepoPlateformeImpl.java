package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

import exceptions.HotelAlreadyExistsException;
import exceptions.HotelNotFoundException;
import model.Adresse;
import model.AdresseType;
import model.Agence;
import model.CarteCredit;
import model.Chambre;
import model.Client;
import model.GPS;
import model.HashMapWrapper;
import model.Hotel;
import model.Lit;

public class RepoPlateformeImpl implements IRepoPlateforme {
	/* ATTRIBUTES */
	private ArrayList<Hotel> hotelCollection = new ArrayList<>();
	private ArrayList<Agence> agenceCollection = new ArrayList<>();
//	private Agence agenceLogin;
	
	/* CONSTRUCTORS */
	public RepoPlateformeImpl() {
		// Hotel(1, "Campanile Montpellier Est Le Millénaire")
		GPS gps1 = new GPS(43.60921999607663, 3.9145600068916337);
		Adresse adresse1 = new Adresse("France", "Montpellier", 1083, "34000", "Henri Becquerel", AdresseType.rue, gps1);
		ArrayList<Lit> litCollection1_1 = new ArrayList<>();
		litCollection1_1.addAll(Arrays.asList(
			new Lit("lit jumeaux", 1),
			new Lit("lit jumeaux", 1)
		));
		ArrayList<Lit> litCollection1_2 = new ArrayList<>();
		litCollection1_2.addAll(Arrays.asList(
			new Lit("lit double", 2)
		));
		ArrayList<Lit> litCollection1_3 = new ArrayList<>();
		litCollection1_3.addAll(Arrays.asList(
			new Lit("lit simple", 1),
			new Lit("lit double", 2)
		));
		ArrayList<Chambre> chambreCollection1 = new ArrayList<>(); 
		chambreCollection1.addAll(Arrays.asList(
			new Chambre(1, 79, 17, litCollection1_1),
			new Chambre(2, 83, 17, litCollection1_2),
			new Chambre(3, 83, 17, litCollection1_3)
		));
		
		// Hotel(2, "Hotel Regina Louvre")
		GPS gps2 = new GPS(48.86380999296151, 2.3324799734784563);
		Adresse adresse2 = new Adresse("France", "Paris", 2, "75001", "des Pyramides", AdresseType.place, gps2);
		ArrayList<Lit> litCollection2_1 = new ArrayList<>();
		litCollection2_1.addAll(Arrays.asList(
			new Lit("grand lit double", 2)
		));
		ArrayList<Lit> litCollection2_2 = new ArrayList<>();
		litCollection2_2.addAll(Arrays.asList(
			new Lit("tres grand lit double", 2),
			new Lit("canape-lit", 1)
		));
		ArrayList<Lit> litCollection2_3 = new ArrayList<>();
		litCollection2_3.addAll(Arrays.asList(
			new Lit("tres grand lit double", 2),
			new Lit("canape-lit", 1)
		));
		ArrayList<Lit> litCollection2_4 = new ArrayList<>();
		litCollection2_4.addAll(Arrays.asList(
			new Lit("grand lit double", 2),
			new Lit("lit simple", 1),
			new Lit("lit simple", 1)
		));
		ArrayList<Chambre> chambreCollection2 = new ArrayList<>(); 
		chambreCollection2.addAll(Arrays.asList(
			new Chambre(1, 422, 25, litCollection2_1),
			new Chambre(2, 768, 60, litCollection2_2),
			new Chambre(3, 877, 50, litCollection2_3),
			new Chambre(4, 818, 50, litCollection2_4)
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
	public HashMapWrapper getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		return agenceLogin.allCombinations(dateArrivee, dateDepart, nombrePerson);
	} 
	
	@Override
	public void reserve(Hotel hotelChoisi, String reservationId, ArrayList<Chambre> chambreChoisi, 
			Calendar dateArrivee, Calendar dateDepart, Client client, double prix, Agence agence) {
		hotelChoisi.reserve(reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix, agence);
	}

	@Override
	public double prixChoisi(Hotel hotelChoisi, ArrayList<Chambre> chambreChoisi, Agence agenceLogin, int days) {
		return hotelChoisi.prixChambresPropose(chambreChoisi, agenceLogin)*days;
	}
	
	@Override
	public String getHotelNom(Hotel hotel) {
		return hotel.getNom();
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

}
