package Q1;

import java.util.List;


public interface IHotelRepo {
	
	int count();
	
	List<Hotel> getHotelCollection();
	
	Hotel addHotel(int id, String name);
	
	Hotel getHotel(int id);
	
	Hotel updateHotel(int id, String name);
	
	boolean deleteHotel(int id);

}
