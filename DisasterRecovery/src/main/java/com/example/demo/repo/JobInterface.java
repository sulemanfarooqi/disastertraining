package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.JobCodeMngmnt;


public interface JobInterface extends JpaRepository<JobCodeMngmnt, Integer> {

	//List<Hotel> findByNameAndLocation(String name, String location);
	
	JobCodeMngmnt findByJobCode(String jobcode);
}

