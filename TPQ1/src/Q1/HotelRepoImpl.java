package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelRepoImpl implements IHotelRepo {
	/* ATTRIBUTES */
	private List<Hotel> hotelCollection = new ArrayList<>();
	
	/* CONSTRUCTORS */
	public HotelRepoImpl() {
//		Adresse(String pays, String ville, int numero, String codePostale, String nom, AdresseType type, GPS gps)
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
			new Chambre(1, "Chambre lits jumeaux superieure", 79, 17, litCollection1_1),
			new Chambre(2, "Chambre double superieure", 83, 17, litCollection1_2),
			new Chambre(3, "Chambre nouvelle generation", 83, 17, litCollection1_3)
		));
//		Chambre(int chambreId, String chambreType, double prix, double taille, List<Lit> litCollection)	
		
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
			new Lit("grand lit double", 2),
			new Lit("lit simple", 1),
			new Lit("lit simple", 1)
		));
		List<Chambre> chambreCollection2 = new ArrayList<>(); 
		chambreCollection2.addAll(Arrays.asList(
			new Chambre(1, "Chambre double deluxe", 422, 25, litCollection2_1),
			new Chambre(2, "Suite prestige", 768, 60, litCollection2_2),
			new Chambre(3, "Suite tour eiffel", 877, 50, litCollection2_3),
			new Chambre(4, "Chambre familiale", 818, 50, litCollection2_4)
		));
		
		hotelCollection.addAll(Arrays.asList(
			new Hotel(1, "Campanile Montpellier Est Le Millénaire", 3, adresse1, chambreCollection1),
			new Hotel(2, "Hotel Regina Louvre", 5, adresse2, chambreCollection2)
		));
	}
//	public Hotel(int hotelId, String nom, int categorie, Adresse adresse, ArrayList<Chambre> chambres) 
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Hotel> getHotelCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel addHotel(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getHotel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel updateHotel(int id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHotel(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String toString() {
		return "HotelRepoImpl [hotelCollection=" + hotelCollection + "]";
	}
	
		
}
