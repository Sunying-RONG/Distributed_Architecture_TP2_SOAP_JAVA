package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Agence {
	private String identifiant;
	private String mdp;
	private List<HotelPartenaireTarif> partenaire = new ArrayList<>();
	private List<Reservation> listReservation = new ArrayList<>();
	
	public Agence() {
		super();
	}
	
	// identifiant et mot de passe d'une agence est le meme pour acceder tous ces hotels partenaires
	public Agence(String identifiant, String mdp) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
	}

	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
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

	public List<HotelPartenaireTarif> getHotelPartenaireTarif() {
		return partenaire;
	}

	public void setHotelPartenaireTarif(List<HotelPartenaireTarif> partenaire) {
		this.partenaire = partenaire;
	}

	// pourcentage d'agence est varie pour chaque hotel
	public void addHotelPartenaireTarif(Hotel hotel, double pourcentage) {
		HotelPartenaireTarif newPartenaire = new HotelPartenaireTarif(hotel, pourcentage);
		this.partenaire.add(newPartenaire);
//		hotel.addAgence(this);
	}
	
//	public HashMap<Hotel, ArrayList<ArrayList<Chambre>>> hotelChambrePropose(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
//		HashMap<Hotel, ArrayList<ArrayList<Chambre>>> allPropse = new HashMap<Hotel, ArrayList<ArrayList<Chambre>>>();
//		for (Hotel hotel : this.hotelPartenaireTarif.keySet()) {
//			ArrayList<ArrayList<Chambre>> groupPropose = hotel.chambresAllPropose(dateArrivee, dateDepart, nombrePerson);
//			if (groupPropose.size() > 0) {
//				allPropse.put(hotel, groupPropose);
//			}
//		}
//		return allPropse;
//	}
	
	// according to hotel's dispo date and nombrePerson
	public Propose[] allProposes(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		List<Propose> allProposes = new ArrayList<>();
		int i = 0;
		for (HotelPartenaireTarif hotelPartenaireTarif : this.partenaire) {
			List<List<Chambre>> groupPropose = hotelPartenaireTarif.getHotel().chambresAllPropose(dateArrivee, dateDepart, nombrePerson);
			for (List<Chambre> unGroupPropose : groupPropose) {
				i++;
				Propose unPropose = new Propose("offre"+i, hotelPartenaireTarif, unGroupPropose);
				allProposes.add(unPropose);
			}
		}
//		System.err.println("nombre de proposes: "+allProposes.size());
		Propose[] allProposesArray = allProposes.toArray(new Propose[0]);
		return allProposesArray;
	}
	
	public int getNombrePropse(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		return this.allProposes(dateArrivee, dateDepart, nombrePerson).length;
	}

	
	// prix total par nuit, de toutes les chambres, calcule avec commission
	public double prixChoisi(Propose propose) {
		double prix = 0;
		List<Chambre> listChambre = propose.getListChambre();
		for (Chambre c : listChambre) {
			prix += c.getPrix();
		}
		prix = prix * propose.getHotelPartenaireTarif().getPourcentage();
		return prix;
	}

//	public OffreMap allCombinations(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
//		HashMap<String, HotelChambresMap> allCombinations = new HashMap<String, HotelChambresMap>();
//		HashMap<Hotel, ArrayList<ArrayList<Chambre>>> allPropose = this.hotelChambrePropose(dateArrivee, dateDepart, nombrePerson);
//		int i = 0;
//		for (Hotel hotel : allPropose.keySet()) {
//			for (ArrayList<Chambre> propose : allPropose.get(hotel)) {
//				i++;
//				HotelChambresMap chaquePropose = new HotelChambresMap();
//				HashMap<Hotel, ArrayList<Chambre>> hotelChambresPropo = new HashMap<Hotel, ArrayList<Chambre>>();
//				hotelChambresPropo.put(hotel, propose);
//				chaquePropose.setHotelChambresPropo(hotelChambresPropo);
//				allCombinations.put("offre"+i, chaquePropose);
//			}
//		}
//		OffreMap offreMap = new OffreMap(allCombinations);
//		return offreMap;
//	}

	public void addReservation(Reservation res) {
		this.listReservation.add(res);
	}
	
}
