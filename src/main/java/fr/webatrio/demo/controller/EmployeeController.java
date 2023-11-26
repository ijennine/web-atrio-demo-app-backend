package fr.webatrio.demo.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.webatrio.demo.dto.EmployeeDto;
import fr.webatrio.demo.dto.EmployeeRequestDto;
import fr.webatrio.demo.exception.DomainException;
import fr.webatrio.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	@ResponseStatus(OK)
	public List<EmployeeDto> getAll() {

		return employeeService.readAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public EmployeeDto getById(@PathVariable Long id) throws DomainException {

		return employeeService.read(id);
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public EmployeeDto create(@RequestBody EmployeeRequestDto employeeRequestDto) throws DomainException {

		return employeeService.create(employeeRequestDto);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(OK)
	public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeRequestDto employeeRequestDto)
			throws DomainException {

		return employeeService.update(employeeRequestDto, id);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable Long id) throws DomainException {

		employeeService.delete(id);
	}
}
