package model;

public class Client {
	private String nom;
	private String prenom;
	private CarteCredit carteCredit;
	
	public Client(String nom, String prenom, CarteCredit carteCredit) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.carteCredit = carteCredit;
	}
	
}
