package Q1;

public class Lit {
	private String type;
	private int capacite;
	
	public Lit(String type, int capacite) {
		super();
		this.type = type;
		this.capacite = capacite;
	}

	@Override
	public String toString() {
		return "Lit [type=" + type + ", capacite=" + capacite + "]";
	}
	
	
}
