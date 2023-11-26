package fr.webatrio.demo.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.webatrio.demo.dto.JobDto;
import fr.webatrio.demo.dto.JobRequestDto;
import fr.webatrio.demo.exception.DomainException;
import fr.webatrio.demo.service.JobService;

@RestController
@RequestMapping("/api/employees/{employeeId}/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	@PostMapping
	@ResponseStatus(CREATED)
	public JobDto create(@PathVariable Long employeeId, @RequestBody JobRequestDto jobRequestDto)
			throws DomainException {

		return jobService.create(employeeId, jobRequestDto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public JobDto update(@PathVariable Long id, @RequestBody JobRequestDto jobRequestDto) throws DomainException {

		return jobService.update(id, jobRequestDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable Long id) throws DomainException {

		jobService.delete(id);
	}
}
