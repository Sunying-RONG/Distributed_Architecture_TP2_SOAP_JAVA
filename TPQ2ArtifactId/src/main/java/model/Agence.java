package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Agence {
	private String identifiant;
	private String mdp;
	private HashMap<Hotel, Double> hotelPartenaireTarif = new HashMap<>();
//	private double pourcentage;
//	private ArrayList<Hotel> hotelPartenaire = new ArrayList<>();
	
	// identifiant et mot de passe d'agence est le meme pour acceder tous les hotels
	public Agence(String identifiant, String mdp) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public HashMap<Hotel, Double> getHotelPartenaireTarif() {
		return hotelPartenaireTarif;
	}

	public void setHotelPartenaireTarif(HashMap<Hotel, Double> hotelPartenaireTarif) {
		this.hotelPartenaireTarif = hotelPartenaireTarif;
	}

	// pourcentage d'agence est varie pour chaque hotel
	public void addHotelPartenaireTarif(Hotel hotel, double pourcentage) {
		this.hotelPartenaireTarif.put(hotel, pourcentage);
		hotel.addAgence(this);
	}
	
	public HashMap<Hotel, ArrayList<ArrayList<Chambre>>> hotelChambrePropose(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		HashMap<Hotel, ArrayList<ArrayList<Chambre>>> allPropse = new HashMap<Hotel, ArrayList<ArrayList<Chambre>>>();
		for (Hotel hotel : this.hotelPartenaireTarif.keySet()) {
			ArrayList<ArrayList<Chambre>> groupPropose = hotel.chambresAllPropose(dateArrivee, dateDepart, nombrePerson);
			if (groupPropose.size() > 0) {
				allPropse.put(hotel, groupPropose);
			}
		}
		return allPropse;
	}
		
	public HashMapWrapper allCombinations(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> allCombinations = new HashMap<String, HashMap<Hotel, ArrayList<Chambre>>>();
		HashMap<Hotel, ArrayList<ArrayList<Chambre>>> allPropose = hotelChambrePropose(dateArrivee, dateDepart, nombrePerson);
		int i = 0;
		for (Hotel hotel : allPropose.keySet()) {
			for (ArrayList<Chambre> propose : allPropose.get(hotel)) {
				i++;
				HashMap<Hotel, ArrayList<Chambre>> chaquePropose = new HashMap<Hotel, ArrayList<Chambre>>();
				chaquePropose.put(hotel, propose);
				allCombinations.put("offre"+i, chaquePropose);
			}
		}
		HashMapWrapper hashMapWapper = new HashMapWrapper(allCombinations);
		return hashMapWapper;
	}
	

	
}
