package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.JobCodeMngmnt;

public interface JobInterface extends JpaRepository<JobCodeMngmnt, Integer> {

}

