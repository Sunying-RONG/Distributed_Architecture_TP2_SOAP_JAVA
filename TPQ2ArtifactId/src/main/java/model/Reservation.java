package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reservation {
	private HotelPartenaireTarif hotelPartenaireTarif;
	private String reservationId;
	private Chambre[] chambreReserveCollection;
	private Calendar dateArrivee;
	private Calendar dateDepart;
	private Client client;
	private double prix;
	private Agence agence;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(HotelPartenaireTarif hotelPartenaireTarif, String reservationId, Chambre[] chambreChoisi, Calendar dateArrivee, Calendar dateDepart,
			Client client, double prix, Agence agence) {
		super();
		this.hotelPartenaireTarif = hotelPartenaireTarif;
		this.reservationId = reservationId;
		this.chambreReserveCollection = chambreChoisi;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.client = client;
		this.prix = prix;
		this.agence = agence;
	}

	public HotelPartenaireTarif getHotel() {
		return hotelPartenaireTarif;
	}

	public void setHotelPartenaireTarif(HotelPartenaireTarif hotelPartenaireTarif) {
		this.hotelPartenaireTarif = hotelPartenaireTarif;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public Chambre[] getChambreReserveCollection() {
		return chambreReserveCollection;
	}

	public void setChambreReserveCollection(Chambre[] chambreReserveCollection) {
		this.chambreReserveCollection = chambreReserveCollection;
	}

	public Calendar getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Calendar dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Calendar getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Calendar dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

}
