package Q1;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	// attribut
	int hotelId;
	String nom;
	int categorie;
	Adresse adresse;
	List<Chambre> chambreCollection = new ArrayList<>();
	List<Reservation> reservCollection = new ArrayList<>();
	
	// constructeur
	public Hotel(int hotelId, String nom, int categorie, 
			Adresse adresse, List<Chambre> chambreCollection) {
		super();
		this.hotelId = hotelId;
		this.nom = nom;
		this.categorie = categorie;
		this.adresse = adresse;
		this.chambreCollection = chambreCollection;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", nom=" + nom + ", categorie=" + categorie + ", adresse=" + adresse
				+ ", chambreCollection=" + chambreCollection + ", reservCollection=" + reservCollection + "]";
	}
	



}
