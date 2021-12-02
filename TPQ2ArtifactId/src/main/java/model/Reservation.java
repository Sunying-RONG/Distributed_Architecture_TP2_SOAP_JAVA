package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reservation {
	private String reservationId;
	private ArrayList<Chambre> chambreReserveCollection = new ArrayList<>();
	private Calendar dateArrivee;
	private Calendar dateDepart;
	private Client client;
	private double prix;
	private Agence agence;
	
	public Reservation(String reservationId, ArrayList<Chambre> chambresReserve, Calendar dateArrivee, Calendar dateDepart,
			Client client, double prix, Agence agence) {
		super();
		this.reservationId = reservationId;
		this.chambreReserveCollection = chambresReserve;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.client = client;
		this.prix = prix;
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
