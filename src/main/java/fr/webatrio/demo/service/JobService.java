package fr.webatrio.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.webatrio.demo.dto.JobDto;
import fr.webatrio.demo.dto.JobRequestDto;
import fr.webatrio.demo.entity.Employee;
import fr.webatrio.demo.entity.Job;
import fr.webatrio.demo.exception.DomainException;
import fr.webatrio.demo.repository.JobRepository;

@Service
public class JobService extends AbstractEmployeeService {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private ModelMapper mapper;

	public JobDto create(Long employeeId, JobRequestDto jobRequestDto) throws DomainException {

		Employee employee = getEmployee(employeeId);

		Job job = mapper.map(jobRequestDto, Job.class);
		job.setEmployee(employee);

		jobRepository.save(job);

		return mapper.map(job, JobDto.class);
	}

	public JobDto update(Long id, JobRequestDto jobRequestDto) throws DomainException {

		Job job = findJobById(id);

		mapper.map(jobRequestDto, job);

		jobRepository.save(job);

		return mapper.map(job, JobDto.class);
	}

	public void delete(Long id) throws DomainException {
		Job job = findJobById(id);

		jobRepository.delete(job);
	}

	private Job findJobById(Long id) throws DomainException {
		return jobRepository.findById(id) //
				.orElseThrow(() -> new DomainException(String.format("Unable to find job with id %d", id),
						HttpStatus.NOT_FOUND));
	}
}
