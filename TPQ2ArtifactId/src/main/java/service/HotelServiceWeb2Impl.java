package service;

import javax.jws.WebService;

import repository.IHotelRepo;
import repository.HotelRepoImpl;

@WebService(endpointInterface="service.IHotelServiceWeb2")
public class HotelServiceWeb2Impl implements IHotelServiceWeb2 {
	/* ATTRIBUTES */
	private IHotelRepo hotelRepoImpl = new HotelRepoImpl();

	/* METHODS */
	@Override
	public int add(int a, int b) {
		return hotelRepoImpl.add(a, b);
	}
	
}
