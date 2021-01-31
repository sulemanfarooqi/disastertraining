package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.entities.TimeSheet;
import com.example.demo.entities.TsLaborCharge;
import com.example.demo.repo.TimesheetInterface;
import com.example.demo.services.TimesheetServiceImpl;

@SpringBootTest
public class MockTesting {
	
	@Mock
	TimesheetInterface tsrepo;
	
	@InjectMocks
	@Autowired
	TimesheetServiceImpl tsServ;
	
	
	
	@Test
	public void testTs() {
//		TimeSheet ts = new TimeSheet();
//		ts.setSiteCode(111);
//		ts.setContractorName("Josh");
//		ts.setDate("01/25/2021");
//		ts.setLaborHoursWorked(2);
//		ts.setHoursUsed(2);
//		ts.setApprovalStatus("open");
//		tsrepo.save(ts);
		
		tsServ.addTimeSheet(111, "Josh", "01/25/2021", 2, 2, "open");
      
	}
	
	@Test
	public void testTsLc() {
		TsLaborCharge ts = new TsLaborCharge();
		JobCodeMngmnt jc = new JobCodeMngmnt();
		ts.setLaborHoursWorked(5);
		ts.setAmount(jc.getHourlyRate() * 5);
		
	}

}
