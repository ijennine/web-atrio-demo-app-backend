package fr.webatrio.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String lastName;

	@Convert(converter = LocalDateConverter.class)
	private LocalDate birthDate;

	@OneToMany(mappedBy = "employee", orphanRemoval = true)
	private List<Job> jobs;
}
