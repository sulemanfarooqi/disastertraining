package com.example.demo.services;

import com.example.demo.entities.TimeSheet;

public interface TimesheetService {

	public void addTimeSheet(int sitecode, String contractorName, String date,  int laborHoursWorked
		,int hoursUsed,String approvalStatus);
	
	public void save(TimeSheet ts);
}
