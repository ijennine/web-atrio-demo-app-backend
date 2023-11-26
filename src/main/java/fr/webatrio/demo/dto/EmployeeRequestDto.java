package fr.webatrio.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeRequestDto {

	private String firstName;

	private String lastName;

	private LocalDate birthDate;
}
