package ServerPackage;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="ServerPackage.IMathService")
public class MathServiceImpl implements IMathService {
	@WebMethod
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}
	
	@WebMethod
	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@WebMethod
	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@WebMethod
	@Override
	public int divide(int a, int b) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (b == 0) {
			throw new IllegalArgumentException("Error: Cannot divide by zero");
		} else {
			return a / b;
		}
	}

}
