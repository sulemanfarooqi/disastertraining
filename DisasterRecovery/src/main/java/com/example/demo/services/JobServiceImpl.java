package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.repo.JobInterface;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	JobInterface jobRepo;
	
	@Transactional
	@Override
	public void addJob(String jobcode, String description, int hourlyrate, int maxhours) {
		// TODO Auto-generated method stub
		
		JobCodeMngmnt jb = new JobCodeMngmnt();
		jb.setDescription(description);
		jb.setJobCode(jobcode);
		jb.setMaxHours(4);
		jb.setHourlyRate(10);
		jobRepo.save(jb);
	
	}

	
	
	
}
