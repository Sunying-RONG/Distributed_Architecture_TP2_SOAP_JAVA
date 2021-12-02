package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import exceptions.AlreadyExist;
import exceptions.NotFound;
import model.Employee;

@WebService
public interface EmployeeService {
	
	/* METHODS */
	@WebMethod
	int count();
	
	@WebMethod
	List<Employee> getEmployees();
	
	@WebMethod
	Employee addEmployee(int id, String name) throws AlreadyExist;
	
	@WebMethod
	Employee getEmployee(int id) throws NotFound;
	
	@WebMethod
	Employee updateEmployee(int id, String name) throws NotFound;
	
	@WebMethod
	boolean deleteEmployee(int id) throws NotFound;
}

