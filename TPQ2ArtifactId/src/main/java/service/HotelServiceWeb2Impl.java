package service;

import java.util.Calendar;

import javax.jws.WebService;

import model.CarteCredit;
import model.Agence;
import model.Chambre;
import model.Client;
import model.HotelPartenaireTarif;
import repository.IRepoPlateforme;
import repository.RepoPlateformeImpl;

@WebService(endpointInterface="service.IHotelServiceWeb2")
public class HotelServiceWeb2Impl implements IHotelServiceWeb2 {
	/* ATTRIBUTES */
	private IRepoPlateforme repoPlateformeImpl = new RepoPlateformeImpl();

	/* METHODS */
	@Override
	public Agence agenceLoginRes(String identifiant, String mdp) {
		return repoPlateformeImpl.agenceLogin(identifiant, mdp);
	}
	
	@Override
	public void reserve(HotelPartenaireTarif hotelPartenaireTarif, String reservationId, Chambre[] chambreChoisi, 
			Calendar dateArrivee, Calendar dateDepart, Client client, double prix, Agence agence) {
		repoPlateformeImpl.reserve(hotelPartenaireTarif, reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix, agence);
	}
	
	@Override
	public CarteCredit createCarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee) {
		return repoPlateformeImpl.createCarteCredit(carteNumero, cvcCode, expireMois, expireAnnee);
	}
	
	@Override
	public Client createClient(String nom, String prenom, CarteCredit carteCredit) {
		return repoPlateformeImpl.createClient(nom, prenom, carteCredit);
	}
}
