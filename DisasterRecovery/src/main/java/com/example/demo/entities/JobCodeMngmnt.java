package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="JobCode")
public class JobCodeMngmnt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String jobCode;
	private String description;
	private int hourlyRate;
	private int maxHours;
//	
//	@OneToOne(mappedBy = "timesheet")
//	private JobCodeMngmnt jobCodeMngmnt;

	
	
	public JobCodeMngmnt() {}
	
	
	public JobCodeMngmnt(String jobCode, String description, int hourlyRate, int maxHours) {
		super();
		this.jobCode = jobCode;
		this.description = description;
		this.hourlyRate = hourlyRate;
		this.maxHours = maxHours;
		
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getMaxHours() {
		return maxHours;
	}

	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}
//
//	public JobCodeMngmnt getJobCodeMngmnt() {
//		return jobCodeMngmnt;
//	}
//
//	public void setJobCodeMngmnt(JobCodeMngmnt jobCodeMngmnt) {
//		this.jobCodeMngmnt = jobCodeMngmnt;
//	}
//	
	
	
	

	
	
}
