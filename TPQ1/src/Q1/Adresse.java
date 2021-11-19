package Q1;

public class Adresse {
	String pays;
	String ville;
	int numero;
	String codePostale;
	String nom;
	AdresseType type;
	GPS gps;
	
	public Adresse(String pays, String ville, int numero, String codePostale, String nom, 
			AdresseType type, GPS gps) {
		super();
		this.pays = pays;
		this.ville = ville;
		this.numero = numero;
		this.codePostale = codePostale;
		this.nom = nom;
		this.type = type;
		this.gps = gps;
	}

	@Override
	public String toString() {
		return "Adresse [pays=" + pays + ", ville=" + ville + ", numero=" + numero + ", codePostale=" + codePostale
				+ ", nom=" + nom + ", type=" + type + ", gps=" + gps + "]";
	}

}
