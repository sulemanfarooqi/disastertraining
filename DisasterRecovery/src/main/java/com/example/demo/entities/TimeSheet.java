package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Timesheet")
public class TimeSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int siteCode;
	private String contractorName;
	private String date;
	private int laborHoursWorked;
	private int totalHoursWorked;
	private int hoursUsed;
	private int totalhoursUsed;
	private String approvalStatus;
	//jobCode
	//machinecode
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "timesheet_jobcode", referencedColumnName="jobCode")
	private JobCodeMngmnt jbcode;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "timesheet_machinecode", referencedColumnName="machineCode")
	private MachineCodeMangmnt machinecode;

	public TimeSheet() {}

	public TimeSheet(int id, int siteCode, String contractorName, String date, int laborHoursWorked,
			int totalHoursWorked, int hoursUsed, int totalhoursUsed, String approvalStatus, JobCodeMngmnt jbcode,
			MachineCodeMangmnt machinecode) {
		super();
		this.id = id;
		this.siteCode = siteCode;
		this.contractorName = contractorName;
		this.date = date;
		this.laborHoursWorked = laborHoursWorked;
		this.totalHoursWorked = totalHoursWorked;
		this.hoursUsed = hoursUsed;
		this.totalhoursUsed = totalhoursUsed;
		this.approvalStatus = approvalStatus;
		this.jbcode = jbcode;
		this.machinecode = machinecode;
	}






	public int getSiteCode() {
		return siteCode;
	}



	public void setSiteCode(int siteCode) {
		this.siteCode = siteCode;
	}



	public String getContractorName() {
		return contractorName;
	}



	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getLaborHoursWorked() {
		return laborHoursWorked;
	}



	public void setLaborHoursWorked(int laborHoursWorked) {
		this.laborHoursWorked = laborHoursWorked;
	}



	public int getTotalHoursWorked() {
		return totalHoursWorked;
	}



	public void setTotalHoursWorked(int totalHoursWorked) {
		this.totalHoursWorked = totalHoursWorked;
	}



	public int getHoursUsed() {
		return hoursUsed;
	}



	public void setHoursUsed(int hoursUsed) {
		this.hoursUsed = hoursUsed;
	}



	public int getTotalhoursUsed() {
		return totalhoursUsed;
	}



	public void setTotalhoursUsed(int totalhoursUsed) {
		this.totalhoursUsed = totalhoursUsed;
	}



	public JobCodeMngmnt getJbcode() {
		return jbcode;
	}

	public void setJbcode(JobCodeMngmnt jbcode) {
		this.jbcode = jbcode;
	}

	public MachineCodeMangmnt getMachinecode() {
		return machinecode;
	}

	public void setMachinecode(MachineCodeMangmnt machinecode) {
		this.machinecode = machinecode;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getApprovalStatus() {
		return approvalStatus;
	}


	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	
	
	
}
