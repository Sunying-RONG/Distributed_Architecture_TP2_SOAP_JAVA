package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.jws.WebService;

import exceptions.AlreadyExist;
import exceptions.NotFound;
import model.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

@WebService(endpointInterface="service.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	/* ATTRIBUTES */
	private EmployeeRepository repository = new EmployeeRepositoryImpl();

	/* METHODS */
	@Override
	public int count() {
		return repository.count();
	}

	@Override
	public List<Employee> getEmployees() {
		return repository.getEmployees();
	}

	@Override
	public Employee addEmployee(int id, String name) throws AlreadyExist {
		return repository.addEmployee(id, name);
	}

	@Override
	public Employee getEmployee(int id) throws NotFound {
		return repository.getEmployee(id);
	}

	@Override
	public Employee updateEmployee(int id, String name) throws NotFound {
		return repository.updateEmployee(id, name);
	}

	@Override
	public boolean deleteEmployee(int id) throws NotFound {
		return repository.deleteEmployee(id);
	}

}
