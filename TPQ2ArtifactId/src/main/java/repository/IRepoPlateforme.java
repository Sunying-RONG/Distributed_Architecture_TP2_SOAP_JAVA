package repository;

import java.util.Calendar;

import exceptions.HotelAlreadyExistsException;
import exceptions.HotelNotFoundException;
import model.Agence;
import model.CarteCredit;
import model.Chambre;
import model.Client;
import model.Propose;
import model.HotelPartenaireTarif;

public interface IRepoPlateforme {
	/* METHODS */
	Agence agenceLogin(String identifiant, String mdp);
	
	String getAgenceIdentifiant(Agence agenceLogin);
	
	Propose[] getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson);
	
	int getNombrePropse(Agence agenceLogin, Calendar dateArrivee, Calendar dateDepart, int nombrePerson);
	
	void reserve(HotelPartenaireTarif hotelPartenaireTarif, String reservationId, Chambre[] chambreChoisi, Calendar dateArrivee,
			Calendar dateDepart, Client client, double prix, Agence agence);
	
	double prixChoisi(Propose propose, Agence agenceLogin, int days);
	
	String getHotelNom(Propose propose);

	CarteCredit createCarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee);

	Client createClient(String nom, String prenom, CarteCredit carteCredit);
}
