package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Hotel {
	// attribut
	private int hotelId;
	private String nom;
	private int categorie;
	private Adresse adresse;
	private ArrayList<Chambre> chambreCollection = new ArrayList<>();
	private ArrayList<Reservation> reservCollection = new ArrayList<>();
//	private ArrayList<Agence> agencePartenaire = new ArrayList<>();
	private HashMap<Agence, Double> agencePartenaireTarif = new HashMap<>();

	
	private ArrayList<ArrayList<Chambre>> groupPropose = new ArrayList<ArrayList<Chambre>>();
	
	public Hotel(int hotelId, String nom, int categorie, 
			Adresse adresse, ArrayList<Chambre> chambreCollection) {
		super();
		this.hotelId = hotelId;
		this.nom = nom;
		this.categorie = categorie;
		this.adresse = adresse;
		this.chambreCollection = chambreCollection;
	}
	
	public String getNom() {
		return nom;
	}

	public void addAgence(Agence agence) {
		HashMap<Hotel, Double> hpt = agence.getHotelPartenaireTarif();
		for (Hotel hotel : hpt.keySet()) {
			if (hotel == this) {
				this.agencePartenaireTarif.put(agence, hpt.get(hotel));
			}
		}
	}
	
	// propose all the combinations
	public ArrayList<ArrayList<Chambre>> chambresAllPropose(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		this.groupPropose.clear();
//		ArrayList<Chambre> chambresPropose = new ArrayList<>();
		ArrayList<Chambre> chambresDispo = this.chambresDispoDansPeriode(dateArrivee, dateDepart);
		int hotelCapacite = this.capaciteDeChambresDispo(chambresDispo);
		if (hotelCapacite == nombrePerson) {
			this.groupPropose.add(chambresDispo);
		} else if (hotelCapacite > nombrePerson) {
			this.sum_up(chambresDispo, nombrePerson);
		}
		return this.groupPropose;
	}
	
	private void sum_up(ArrayList<Chambre> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Chambre>());
    }
	
	private void sum_up_recursive(ArrayList<Chambre> numbers, int target, ArrayList<Chambre> partial) {
       int s = 0;
       for (Chambre x: partial) s += x.getChambreCapacite();
       if (s == target) {
    	   System.out.println("proposition ("+Arrays.toString(partial.toArray())+")="+target);
    	   this.groupPropose.add(partial);
       }
       if (s >= target) {
           return;
       }
       for(int i=0;i<numbers.size();i++) {
			ArrayList<Chambre> remaining = new ArrayList<Chambre>();
			int n = numbers.get(i).getChambreCapacite();//p
			for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
			ArrayList<Chambre> partial_rec = new ArrayList<Chambre>(partial);
			partial_rec.add(numbers.get(i));
			sum_up_recursive(remaining,target,partial_rec);
       }
    }
		
	public ArrayList<Chambre> chambresDispoDansPeriode(Calendar dateArrivee, Calendar dateDepart) {
		ArrayList<Chambre> chambresDispo = new ArrayList<>();
		chambresDispo.addAll(this.chambreCollection);
		for (Reservation reservation : reservCollection) {
			if (!(!reservation.getDateArrivee().before(dateDepart) || !reservation.getDateDepart().after(dateArrivee))) {
				for (Chambre cr : reservation.getChambreReserveCollection()) {
					if (chambresDispo.contains(cr)) {
						chambresDispo.remove(cr);
					}
				}
			}
		}
		return chambresDispo;
	}
	
//	public HashMap<Chambre, ArrayList<Calendar>> chambresDispoParJour(Calendar dateArrivee, Calendar dateDepart) {
//		
//	}
	
	public int capaciteDeChambresDispo(List<Chambre> chambresDispo) {
		int hotelCapacite = 0;
		for (Chambre c : chambresDispo) {
			hotelCapacite += c.getChambreCapacite();
		}
		return hotelCapacite;
	}
	
	public double prixChambresPropose(ArrayList<Chambre> chambresPropose, Agence agenceLogin) {
		double pourcentage = 1;
		double prix = 0;
		for (Chambre c : chambresPropose) {
			prix += c.getPrix();
		}
		for (Agence agence : this.agencePartenaireTarif.keySet()) {
			if (agence == agenceLogin) {
				pourcentage = this.agencePartenaireTarif.get(agence);
			}
		}
		return prix*pourcentage;
	}
	
	public void reserve(String reservationId, ArrayList<Chambre> chambreChoisi, 
			Calendar dateArrivee, Calendar dateDepart, Client client, double prix, Agence agence) {
		Reservation res = new Reservation(reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix, agence);
		this.reservCollection.add(res);
	}
}
