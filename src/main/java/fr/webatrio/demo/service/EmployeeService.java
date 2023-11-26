package fr.webatrio.demo.service;

import static java.time.temporal.ChronoUnit.YEARS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.webatrio.demo.dto.EmployeeDto;
import fr.webatrio.demo.dto.EmployeeRequestDto;
import fr.webatrio.demo.entity.Employee;
import fr.webatrio.demo.exception.DomainException;

@Service
public class EmployeeService extends AbstractEmployeeService {

	@Autowired
	private ModelMapper mapper;

	public List<EmployeeDto> readAll() {

		return employeeRepository.findAllOrderedByLastNameAndFirstName() //
				.stream() //
				.map(employee -> mapper.map(employee, EmployeeDto.class)) //
				.toList();
	}

	public EmployeeDto read(Long id) throws DomainException {
		Employee employee = getEmployee(id);

		return mapper.map(employee, EmployeeDto.class);
	}

	public EmployeeDto create(EmployeeRequestDto employeeRequestDto) throws DomainException {

		if (employeeRequestDto.getBirthDate().until(LocalDate.now(), YEARS) > 150L) {
			throw new DomainException("Employee can't be older than 150 years", BAD_REQUEST);
		}

		Employee employee = mapper.map(employeeRequestDto, Employee.class);

		employeeRepository.save(employee); // annotate parameter with null ?

		return mapper.map(employee, EmployeeDto.class);
	}

	public EmployeeDto update(EmployeeRequestDto employeeRequestDto, Long id) throws DomainException {

		Employee employee = getEmployee(id);

		mapper.map(employeeRequestDto, employee);
		employeeRepository.save(employee);

		return mapper.map(employee, EmployeeDto.class);
	}

	public void delete(Long id) throws DomainException {

		Employee employee = getEmployee(id);

		employeeRepository.delete(employee);
	}
}
