package fr.webatrio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import fr.webatrio.demo.entity.Employee;
import fr.webatrio.demo.exception.DomainException;
import fr.webatrio.demo.repository.EmployeeRepository;

public abstract class AbstractEmployeeService {

	@Autowired
	protected EmployeeRepository employeeRepository;

	protected Employee getEmployee(Long id) throws DomainException {

		return employeeRepository.findById(id) //
				.orElseThrow(() -> new DomainException(String.format("Unable to find employee with id %d", id),
						HttpStatus.NOT_FOUND));
	}
}
