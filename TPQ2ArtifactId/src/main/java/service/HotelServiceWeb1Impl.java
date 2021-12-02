package service;

import java.util.ArrayList;
import java.util.Calendar;

import javax.jws.WebService;

import model.Agence;
import model.HashMapWrapper;
import model.Hotel;
import repository.IRepoPlateforme;
import repository.RepoPlateformeImpl;
import model.Chambre;

@WebService(endpointInterface="service.IHotelServiceWeb1")
public class HotelServiceWeb1Impl implements IHotelServiceWeb1 {
	/* ATTRIBUTES */
	private IRepoPlateforme repoPlateformeImpl = new RepoPlateformeImpl();

	/* METHODS */
	
	@Override
	public Agence agenceLogin(String identifiant, String mdp) {
		return repoPlateformeImpl.agenceLogin(identifiant, mdp);
	}
	
	@Override
	public String getAgenceIdentifiant(Agence agenceLogin) {
		return repoPlateformeImpl.getAgenceIdentifiant(agenceLogin);
	}
	
	@Override
	public HashMapWrapper getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		return repoPlateformeImpl.getAllCombinations(agenceLogin, dateArrivee, dateDepart, nombrePerson);
	}
	
	@Override
	public double prixChoisi(Hotel hotelChoisi, ArrayList<Chambre> chambreChoisi, Agence agenceLogin, int days) {
		return repoPlateformeImpl.prixChoisi(hotelChoisi, chambreChoisi, agenceLogin, days);
	}
	
	@Override
	public String getHotelNom(Hotel hotel) {
		return repoPlateformeImpl.getHotelNom(hotel);
	}

}
