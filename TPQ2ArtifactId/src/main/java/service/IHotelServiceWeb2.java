package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHotelServiceWeb2 {
	@WebMethod
	int add(int a, int b);
}