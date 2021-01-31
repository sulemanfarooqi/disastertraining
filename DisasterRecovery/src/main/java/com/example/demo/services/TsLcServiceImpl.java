package com.example.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.entities.TsLaborCharge;
import com.example.demo.repo.TsLcInterface;

public class TsLcServiceImpl implements TsLcService {

	@Autowired
	TsLcInterface lcrepo;
	
	@Transactional
	@Override
	public void addLabor(String jbcode,int laborHoursWorked,double amount) {
		// TODO Auto-generated method stub
		
		TsLaborCharge tslc = new TsLaborCharge();
		tslc.setAmount(amount);
		tslc.setLaborHoursWorked(laborHoursWorked);
		tslc.setJbcode(jbcode);
		
	}

}
