package model;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapWrapper {
	private HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> allCombinations = new HashMap<>();

	public HashMapWrapper(HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> allCombinations) {
		super();
		this.allCombinations = allCombinations;
	}

	public HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> getAllCombinations() {
		return allCombinations;
	}

	public void setAllCombinations(HashMap<String, HashMap<Hotel, ArrayList<Chambre>>> allCombinations) {
		this.allCombinations = allCombinations;
	}
	
}
