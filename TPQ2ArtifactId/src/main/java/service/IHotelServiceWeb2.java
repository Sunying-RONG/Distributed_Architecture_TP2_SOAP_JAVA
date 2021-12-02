package service;

import java.util.ArrayList;
import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;

import model.Agence;
import model.CarteCredit;
import model.Chambre;
import model.Client;
import model.Hotel;

@WebService
public interface IHotelServiceWeb2 {
	@WebMethod
	Agence agenceLoginRes(String identifiant, String mdp);
	
	@WebMethod
	void reserve(Hotel hotelChoisi, String reservationId, ArrayList<Chambre> chambreChoisi, 
			Calendar dateArrivee, Calendar dateDepart, Client client, double prix, Agence agence);
	
	@WebMethod
	CarteCredit createCarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee);
	
	@WebMethod
	Client createClient(String nom, String prenom, CarteCredit carteCredit);
	

	
}