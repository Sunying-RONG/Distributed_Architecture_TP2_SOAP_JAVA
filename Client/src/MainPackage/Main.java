package MainPackage;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("http://localhost:8080/mathservice?wsdl");
		
		ClientPackage.MathServiceImplService MathServiceImpl = 
				new ClientPackage.MathServiceImplService(url);
		
		ClientPackage.IMathService proxy = 
				MathServiceImpl.getMathServiceImplPort();	
		System.out.print(proxy.add(1, 2));
	}

}
