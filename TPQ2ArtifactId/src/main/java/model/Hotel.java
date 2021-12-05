package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Hotel {
	// attribut
	private int hotelId;
	private String nom;
	private int categorie;
	private Adresse adresse;
	private List<Chambre> chambreCollection = new ArrayList<>();
	private List<Reservation> reservCollection = new ArrayList<>();
//	private ArrayList<Agence> agencePartenaire = new ArrayList<>();
	
	private List<List<Chambre>> groupPropose = new ArrayList<List<Chambre>>();
	
	public Hotel() {
		super();
	}

	public Hotel(int hotelId, String nom, int categorie, 
			Adresse adresse, List<Chambre> chambreCollection) {
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

//	public void addAgence(Agence agence) {
//		HashMap<Hotel, Double> hpt = agence.getHotelPartenaireTarif();
//		for (Hotel hotel : hpt.keySet()) {
//			if (hotel == this) {
//				this.agencePartenaireTarif.put(agence, hpt.get(hotel));
//			}
//		}
//	}
	
	// propose all the combinations
	public List<List<Chambre>> chambresAllPropose(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		this.groupPropose.clear();
//		ArrayList<Chambre> chambresPropose = new ArrayList<>();
		List<Chambre> chambresDispo = this.chambresDispoDansPeriode(dateArrivee, dateDepart);
		int hotelCapacite = this.capaciteDeChambresDispo(chambresDispo);
//		if (hotelCapacite == nombrePerson) {
//			this.groupPropose.add(chambresDispo);
//		} else 
		if (hotelCapacite >= nombrePerson) {
			this.sum_up(chambresDispo, nombrePerson);
			if (this.groupPropose.size() == 0) {
				this.sum_up(chambresDispo, nombrePerson+1);
			}
		}
		return this.groupPropose;
	}
	
	private void sum_up(List<Chambre> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Chambre>());
    }
	
	private void sum_up_recursive(List<Chambre> numbers, int target, List<Chambre> partial) {
       int s = 0;
       for (Chambre x: partial) {
    	   s += x.getChambreCapacite();
       }
       if (s == target) {
//    	   System.out.println("proposition ("+Arrays.toString(partial.toArray())+")="+target);
    	   this.groupPropose.add(partial);
       }
       if (s >= target) {
           return;
       }
       for(int i=0;i<numbers.size();i++) {
			List<Chambre> remaining = new ArrayList<Chambre>();
			int n = numbers.get(i).getChambreCapacite();//p
			for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
			List<Chambre> partial_rec = new ArrayList<Chambre>(partial);
			partial_rec.add(numbers.get(i));
			sum_up_recursive(remaining,target,partial_rec);
       }
    }
		
	public List<Chambre> chambresDispoDansPeriode(Calendar dateArrivee, Calendar dateDepart) {
		List<Chambre> chambresDispo = new ArrayList<>();
		chambresDispo.addAll(this.chambreCollection);
		for (Reservation reservation : this.reservCollection) {
			if (!(!reservation.getDateArrivee().before(dateDepart) || !reservation.getDateDepart().after(dateArrivee))) {
				for (Chambre cr : reservation.getChambreReserveCollection()) {
					if (chambresDispo.contains(cr)) {
						chambresDispo.remove(cr);
					}
				}
			}
		}
//		System.err.println("nombre de chambres dispo: "+chambresDispo.size());
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
	
//	public double prixChambresPropose(ArrayList<Chambre> chambresPropose, Agence agenceLogin) {
//		double pourcentage = 1;
//		double prix = 0;
//		for (Chambre c : chambresPropose) {
//			prix += c.getPrix();
//		}
//		for (Agence agence : this.agencePartenaireTarif.keySet()) {
//			if (agence == agenceLogin) {
//				pourcentage = this.agencePartenaireTarif.get(agence);
//			}
//		}
//		return prix*pourcentage;
//	}
	
	public void reserve(HotelPartenaireTarif hotelPartenaireTarif, String reservationId, Chambre[] chambreChoisi, 
			Calendar dateArrivee, Calendar dateDepart, Client client, double prix, Agence agence) {
		Reservation res = new Reservation(hotelPartenaireTarif, reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix, agence);
		this.reservCollection.add(res);
		agence.addReservation(res);
	}
}
