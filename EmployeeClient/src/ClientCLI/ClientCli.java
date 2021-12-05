package ClientCLI;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import ClientWSDL.Employee;

public class ClientCli {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("http://localhost:8080/employeeservice?wsdl");
		
		ClientWSDL.EmployeeServiceImplService EmployeeServiceImpl = 
				new ClientWSDL.EmployeeServiceImplService(url);
		
		ClientWSDL.EmployeeService proxy = 
				EmployeeServiceImpl.getEmployeeServiceImplPort();	
		System.out.print(proxy.count());
		
		List<Employee> employeeList = proxy.getEmployees();
		for (Employee e : employeeList) {
			System.out.print(e.getName());
		}
	}

}