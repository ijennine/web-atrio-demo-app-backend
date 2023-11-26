package fr.webatrio.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class JobRequestDto {

	private String companyName;

	private String role;

	private Date startDate;

	private Date endDate;
}
