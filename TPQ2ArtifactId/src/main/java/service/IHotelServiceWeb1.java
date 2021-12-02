package service;

import java.util.ArrayList;
import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;

import model.Agence;
import model.Chambre;
import model.HashMapWrapper;
import model.Hotel;

@WebService
public interface IHotelServiceWeb1 {
	@WebMethod
	Agence agenceLogin(String identifiant, String mdp);
	
	@WebMethod
	String getAgenceIdentifiant(Agence agenceLogin);
	
	@WebMethod
	HashMapWrapper getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson);
	
	@WebMethod
	double prixChoisi(Hotel hotelChoisi, ArrayList<Chambre> chambreChoisi, Agence agenceLogin, int days);
	
	@WebMethod
	String getHotelNom(Hotel hotel);

}
