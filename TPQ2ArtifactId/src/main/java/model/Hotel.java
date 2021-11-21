package model;

import java.util.ArrayList;

public class Hotel {
	// attribut
	private int hotelId;
	private String nom;
	private int categorie;
	private Adresse adresse;
	private ArrayList<Chambre> chambreCollection = new ArrayList<>();
	private ArrayList<Reservation> reservCollection = new ArrayList<>();
	private ArrayList<Agence> agencePartenaire = new ArrayList<>();
	
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
	
	public void addAgence(Agence agence) {
		this.agencePartenaire.add(agence);
	}
}
