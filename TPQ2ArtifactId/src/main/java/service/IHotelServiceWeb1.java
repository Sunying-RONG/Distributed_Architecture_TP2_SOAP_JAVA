package service;

import java.awt.Image;
import java.util.Calendar;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Agence;
import model.Employee;
import model.HotelPartenaireTarif;
import model.Propose;

@WebService
//@SOAPBinding(style=Style.RPC)
public interface IHotelServiceWeb1 {
	@WebMethod
	Agence agenceLogin(String identifiant, String mdp);
	
	@WebMethod
	String getAgenceIdentifiant(Agence agenceLogin);
	
	@WebMethod
	List<Propose> getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson);
	
	@WebMethod
	double prixChoisi(Propose propose, Agence agenceLogin, int days);
	
	@WebMethod
	String getHotelNom(Propose propose);
	
	@WebMethod
	Image downloadImage(String imageName);
	
	@WebMethod
	List<HotelPartenaireTarif> getAgencePartenaire(Agence agenceLogin);
	
//	@WebMethod
//	List<String> getTest(Calendar cal1, Calendar cal2);
}
