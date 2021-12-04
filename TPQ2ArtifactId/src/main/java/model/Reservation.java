package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reservation {
	private Hotel hotel;
	private String reservationId;
	private ArrayList<Chambre> chambreReserveCollection = new ArrayList<>();
	private Calendar dateArrivee;
	private Calendar dateDepart;
	private Client client;
	private double prix;
	private Agence agence;
	
	public Reservation(Hotel hotel, String reservationId, ArrayList<Chambre> chambresReserve, Calendar dateArrivee, Calendar dateDepart,
			Client client, double prix, Agence agence) {
		super();
		this.hotel = hotel;
		this.reservationId = reservationId;
		this.chambreReserveCollection = chambresReserve;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.client = client;
		this.prix = prix;
		this.agence = agence;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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

	public List<Chambre> getChambreReserveCollection() {
		return chambreReserveCollection;
	}

	public void setChambreReserveCollection(ArrayList<Chambre> chambreReserveCollection) {
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
