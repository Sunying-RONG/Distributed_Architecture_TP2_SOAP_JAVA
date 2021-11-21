package main;

import java.net.MalformedURLException;
import java.net.URL;

public class HotelServiceClientCLI {
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url1 = new URL("http://localhost:8080/serviceweb1?wsdl");
		URL url2 = new URL("http://localhost:8080/serviceweb2?wsdl");
		
		service1.HotelServiceWeb1ImplService hotelServiceWeb1Impl = 
				new service1.HotelServiceWeb1ImplService(url1);
		service1.IHotelServiceWeb1 proxy1 = 
				hotelServiceWeb1Impl.getHotelServiceWeb1ImplPort();	
		System.out.print(proxy1.divide(4,2));
		
		service2.HotelServiceWeb2ImplService hotelServiceWeb2Impl = 
				new service2.HotelServiceWeb2ImplService(url2);
		service2.IHotelServiceWeb2 proxy2 = 
				hotelServiceWeb2Impl.getHotelServiceWeb2ImplPort();	
		System.out.print(proxy2.add(4,2));
	}
}
