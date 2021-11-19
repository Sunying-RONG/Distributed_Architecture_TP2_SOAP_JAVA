package Q1;

import java.util.ArrayList;
import java.util.List;

public class Chambre {
	private int chambreId;
	private String chambreType;
	private double prix; // euro
	private double taille; // m2
	private List<Lit> litCollection = new ArrayList<>();
	
	public Chambre(int chambreId, String chambreType, double prix, double taille, 
			List<Lit> litCollection) {
		super();
		this.chambreId = chambreId;
		this.chambreType = chambreType;
		this.prix = prix;
		this.taille = taille;
		this.litCollection = litCollection;
	}

	@Override
	public String toString() {
		return "Chambre [chambreId=" + chambreId + ", chambreType=" + chambreType + ", prix=" + prix + ", taille="
				+ taille + ", litCollection=" + litCollection + "]";
	}

}
