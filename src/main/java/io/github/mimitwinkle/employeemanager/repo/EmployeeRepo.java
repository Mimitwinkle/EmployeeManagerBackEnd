package io.github.mimitwinkle.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.mimitwinkle.employeemanager.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Optional<Employee> findEmployeeById(Long id);
}
