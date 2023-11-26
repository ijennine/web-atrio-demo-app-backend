package fr.webatrio.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.webatrio.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT employee FROM Employee employee ORDER BY employee.lastName, employee.firstName")
	List<Employee> findAllOrderedByLastNameAndFirstName();
}
