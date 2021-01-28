package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.entities.Role;
import com.example.demo.repo.JobInterface;
import com.example.demo.repo.RoleInterface;


@SpringBootTest
class DisasterRecoveryApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	RoleInterface role;
	
	@Autowired
	JobInterface jobRepo;
	

	
	public void testRoleRepo() {
		Role  userRole = new Role();
		userRole.setName("Jish");
		userRole.setAdmin(false);
		role.save(userRole);
	}
	
	
	public void testJobRepo() {
		JobCodeMngmnt jobcode = new JobCodeMngmnt();
		jobcode.setJobCode("Plumber");
		jobcode.setDescription("Fix the plumbing");
		jobcode.setHourlyRate(65);
		jobcode.setMaxHours(4);
		jobRepo.save(jobcode);
	}
}
