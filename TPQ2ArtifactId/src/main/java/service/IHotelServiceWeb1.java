package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHotelServiceWeb1 {
	@WebMethod
	int divide(int a, int b) throws IllegalArgumentException;
}
