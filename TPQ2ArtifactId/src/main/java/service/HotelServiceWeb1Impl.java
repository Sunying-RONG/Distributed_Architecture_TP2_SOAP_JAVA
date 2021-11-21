package service;

import javax.jws.WebService;

import repository.IHotelRepo;
import repository.HotelRepoImpl;

@WebService(endpointInterface="service.IHotelServiceWeb1")
public class HotelServiceWeb1Impl implements IHotelServiceWeb1 {
	/* ATTRIBUTES */
	private IHotelRepo hotelRepoImpl = new HotelRepoImpl();

	/* METHODS */
	@Override
	public int divide(int a, int b) throws IllegalArgumentException {
		return hotelRepoImpl.divide(a, b);
	}

}
