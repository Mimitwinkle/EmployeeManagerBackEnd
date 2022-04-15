package io.github.mimitwinkle.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.mimitwinkle.employeemanager.domain.Employee;
import io.github.mimitwinkle.employeemanager.exception.UserNotFoundException;
import io.github.mimitwinkle.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	// Create new employee
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	// Find all employees
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}
	
	// Find employee by id
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
	}
	
	// Update employee data
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	// Delete employee by ID
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
	
}
