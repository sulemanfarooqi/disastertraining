package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.entities.Role;
import com.example.demo.entities.TimeSheet;
import com.example.demo.repo.JobInterface;
import com.example.demo.repo.RoleInterface;
import com.example.demo.repo.TimesheetInterface;


@SpringBootTest
class DisasterRecoveryApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	RoleInterface role;
//	
//	@Autowired
//	JobInterface jobRepo;
	
	@Autowired
	TimesheetInterface tsRepo;
//	
//	public void testRoleRepo() {
//		Role  userRole = new Role();
//		userRole.setName("Jish");
//		userRole.setAdmin(false);
//		role.save(userRole);
//	}
//	
	
//	public void testJobRepo() {
//		JobCodeMngmnt jobcode = new JobCodeMngmnt();
//		jobcode.setJobCode("Plumber");
//		jobcode.setDescription("Fix the plumbing");
//		jobcode.setHourlyRate(65);
//		jobcode.setMaxHours(4);
//		jobRepo.save(jobcode);
//	}
	
	public void testTsRepo() {
		TimeSheet ts = new TimeSheet();
		ts.setContractorName("Josh");
		ts.setApprovalStatus("open");
		ts.setDate("1/23/2021");
//		ts.setLaborHoursWorked(4);
		ts.setSiteCode(111);
//		ts.setHoursUsed(4);
	    tsRepo.save(ts);
	}
	
}
