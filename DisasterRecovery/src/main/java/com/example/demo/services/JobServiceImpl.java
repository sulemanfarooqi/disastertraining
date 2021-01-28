package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.repo.JobInterface;

public class JobServiceImpl implements JobService{

	@Autowired
	JobInterface jobRepo;
	
	@Override
	public void addJob(int jobcode, String description, int hourlyrate, int maxhours) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

	
	
	
}
