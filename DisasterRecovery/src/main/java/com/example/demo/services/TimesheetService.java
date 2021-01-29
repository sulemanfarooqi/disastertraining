package com.example.demo.services;

public interface TimesheetService {

	public void addTimeSheet(int sitecode, String contractorName, String date,  int laborHoursWorked
		,int hoursUsed,String approvalStatus);
	
}
