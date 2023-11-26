package fr.webatrio.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String companyName;

	private String role;

	private Date startDate;

	private Date endDate;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
}
