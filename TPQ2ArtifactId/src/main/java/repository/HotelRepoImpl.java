package repository;

import java.util.ArrayList;
import java.util.Arrays;


import exceptions.HotelAlreadyExistsException;
import exceptions.HotelNotFoundException;
import model.Adresse;
import model.AdresseType;
import model.Agence;
import model.Chambre;
import model.GPS;
import model.Hotel;
import model.Lit;

public class HotelRepoImpl implements IHotelRepo {
	/* ATTRIBUTES */
	private ArrayList<Hotel> hotelCollection = new ArrayList<>();
	
	/* CONSTRUCTORS */
	public HotelRepoImpl() {
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

		Agence agenceA = new Agence("agenceA", "agenceAmdp", 0.9);
		hotel1.addAgence(agenceA);
		
		Agence agenceB = new Agence("agenceB", "agenceBmdp", 0.8);
		hotel1.addAgence(agenceB);
		
		Agence agenceA2 = new Agence("agenceA", "agenceAmdp", 0.7);
		hotel2.addAgence(agenceA2);
	}
	
	@Override
	public int divide(int a, int b) throws IllegalArgumentException {
		if (b == 0) {
			throw new IllegalArgumentException("Error: Cannot divide by zero"); 
		}
		return a / b;
	}
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Hotel> getHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel addHotel(int id, String name) throws HotelAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getHotel(int id) throws HotelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel updateHotel(int id, String name) throws HotelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHotel(int id) throws HotelNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
