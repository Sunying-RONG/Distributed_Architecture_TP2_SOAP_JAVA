package repository;

import java.util.List;

import exceptions.AlreadyExist;
import exceptions.NotFound;
import model.Employee;

public interface EmployeeRepository {
	int count();
	
	List<Employee> getEmployees();
	
	Employee addEmployee(int id, String name) throws AlreadyExist;
	
	Employee getEmployee(int id) throws NotFound;
	
	Employee updateEmployee(int id, String name) throws NotFound;
	
	boolean deleteEmployee(int id) throws NotFound;
}
