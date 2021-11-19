package Q1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reservation {
	int reservationId;
	List<Chambre> chambreReserveCollection = new ArrayList<>();
	Calendar dateArrive;
	Calendar dateDepart;
	Client client;
	
	public Reservation(int reservationId, ArrayList<Chambre> chambresReserve, Calendar dateArrive, Calendar dateDepart,
			Client client) {
		super();
		this.reservationId = reservationId;
		this.chambreReserveCollection = chambresReserve;
		this.dateArrive = dateArrive;
		this.dateDepart = dateDepart;
		this.client = client;
	}
	

}
