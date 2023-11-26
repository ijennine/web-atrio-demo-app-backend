package fr.webatrio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.webatrio.demo.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
