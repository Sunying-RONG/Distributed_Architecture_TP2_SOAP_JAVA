package exceptions;

public class AlreadyExist extends Exception {
	public AlreadyExist() {
	
	}
	
	public AlreadyExist(String message) {
		super(message);
	}
}
