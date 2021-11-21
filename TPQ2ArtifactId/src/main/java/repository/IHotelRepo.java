package repository;

import java.util.ArrayList;

import exceptions.HotelAlreadyExistsException;
import exceptions.HotelNotFoundException;
import model.Hotel;

public interface IHotelRepo {
	/* METHODS */
	// exemple service web 1
	int divide(int a, int b) throws IllegalArgumentException;
	// exemple service web 2
	int add(int a, int b);
	
	int count();
	
	ArrayList<Hotel> getHotels();
	
	Hotel addHotel(int id, String name) throws HotelAlreadyExistsException;
	
	Hotel getHotel(int id) throws HotelNotFoundException;
	
	Hotel updateHotel(int id, String name) throws HotelNotFoundException;
	
	boolean deleteHotel(int id) throws HotelNotFoundException;
}
