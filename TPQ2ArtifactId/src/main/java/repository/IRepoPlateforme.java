package repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import exceptions.HotelAlreadyExistsException;
import exceptions.HotelNotFoundException;
import model.Agence;
import model.CarteCredit;
import model.Chambre;
import model.Client;
import model.HashMapWrapper;
import model.Hotel;

public interface IRepoPlateforme {
	/* METHODS */
	Agence agenceLogin(String identifiant, String mdp);
	
	String getAgenceIdentifiant(Agence agenceLogin);
	
	HashMapWrapper getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson);
	
	void reserve(Hotel hotelChoisi, String reservationId, ArrayList<Chambre> chambreChoisi, Calendar dateArrivee,
			Calendar dateDepart, Client client, double prix, Agence agence);
	
	double prixChoisi(Hotel hotelChoisi, ArrayList<Chambre> chambreChoisi, Agence agenceLogin, int days);
	
	String getHotelNom(Hotel hotel);

	CarteCredit createCarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee);

	Client createClient(String nom, String prenom, CarteCredit carteCredit);
}
