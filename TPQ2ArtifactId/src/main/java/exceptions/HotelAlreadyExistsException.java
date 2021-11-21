package exceptions;

public class HotelAlreadyExistsException extends Exception {
	public HotelAlreadyExistsException() {
		
	}
	
	public HotelAlreadyExistsException(String message) {
		super(message);
	}
}
