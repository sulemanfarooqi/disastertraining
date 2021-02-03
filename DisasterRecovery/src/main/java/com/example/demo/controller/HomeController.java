package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entities.Dropdown;
import com.example.demo.entities.JobCodeMngmnt;
import com.example.demo.entities.MachineCodeMangmnt;
import com.example.demo.entities.TimeSheet;
import com.example.demo.entities.TsLaborCharge;
import com.example.demo.entities.TsMachineCharge;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.JobInterface;
import com.example.demo.repo.MachineInterface;
import com.example.demo.repo.TimesheetInterface;
import com.example.demo.services.TimesheetServiceImpl;



@Controller
@SessionAttributes("dropdown")
public class HomeController {

	
	@Autowired
	JobInterface jobrepo;
	
	@Autowired
	MachineInterface mrepo;
	
	@Autowired
	TimesheetInterface tsrepo;
	
	
	
	@Autowired
	TimesheetServiceImpl tsServ;
	
   @ModelAttribute
	public Dropdown dropdown() {
	   
		return new Dropdown();
	}
	
	@RequestMapping("/")
	public String welcome() {
		System.out.println("in index");
		return "index";
	}
	
	@RequestMapping("/add_timesheet")
	public String addTimesheet(@ModelAttribute Dropdown dropdown, Model model) {
		
		
	    List<JobCodeMngmnt> list = jobrepo.findAll();
		//model.addAttribute("jclist",list);
		
		List<MachineCodeMangmnt> mlist = mrepo.findAll();
		//model.addAttribute("mclist", mlist);
		dropdown.setJclist(list);
		dropdown.setMclist(mlist);
		
		System.out.println("in time sheet");
		
		TimeSheet ts = new TimeSheet();
		ts.getTslcs().add(new TsLaborCharge());//to get the row first time
		ts.getTsmcs().add(new TsMachineCharge());//to get row first time

		model.addAttribute("timesheet",ts);
		return "selectJobCode" ;
	}
	
	
	@RequestMapping(value="/add_timesheet", method=RequestMethod.POST,params={"save"} )
	public String saveTimeSheet(@ModelAttribute("timesheet") TimeSheet ts, BindingResult bindingrequest) {
		
		System.out.println("in save ts");
//		
//		if( bindingrequest.hasErrors()){
//			List<ObjectError> errors = bindingrequest.getAllErrors();
//			for(ObjectError o: errors) {
//				System.out.println(o);
//			}
//			return "selectJobCode";
//		}else {
//			
//			tsServ.save(ts);
//		}
		
		//summation amount and hrs
		List<TsLaborCharge>  tsl= ts.getTslcs();
		double totalamount = 0;
		int totalhours =0;
		for(TsLaborCharge tslc: tsl) {
			
			totalamount += tslc.getAmount();
			totalhours += tslc.getLaborHoursWorked();	
		}
		
		ts.setTotalAmount(totalamount);
		ts.setTotalHoursWorked(totalhours);
		ts.setApprovalStatus("Open");
		tsServ.save(ts);
			return "redirect:list_timesheet";
	}
	
	@RequestMapping("/list_timesheet")
	public String listTimeSheet(Model model) {
		
		System.out.println("in list");
		List<TimeSheet> tslist = tsrepo.findAll();
		model.addAttribute("displaytslist", tslist);
		return "listTimeSheet";
	}
	
	@RequestMapping(value="/add_timesheet", method=RequestMethod.POST, params={"addRow"})
	public String addNewRows(@ModelAttribute("timesheet") TimeSheet ts,
			@ModelAttribute Dropdown dropdown) {
		
		System.out.println("in addRow");	
		ts.getTslcs().add(new TsLaborCharge());
		
//		List<JobCodeMngmnt> list = jobrepo.findAll();
//		model.addAttribute("jclist",list);
//		
//		List<MachineCodeMangmnt> mlist = mrepo.findAll();
//		model.addAttribute("mclist", mlist);
		
		return "selectJobCode" ;
		
		
	}
	
	
	@RequestMapping(value="/add_timesheet", method=RequestMethod.POST, params={"addmachineRow"})
	public String addNewMRows(@ModelAttribute("timesheet") TimeSheet ts, @ModelAttribute Dropdown dropdown) {
		
		System.out.println("in machine  addRow");	
		ts.getTsmcs().add(new TsMachineCharge());
//		
//		List<JobCodeMngmnt> list = jobrepo.findAll();
//		model.addAttribute("jclist",list);
//		
//		List<MachineCodeMangmnt> mlist = mrepo.findAll();
//		model.addAttribute("mclist", mlist);
		
		return "selectJobCode" ;
		
	}
	
	
	@RequestMapping("/listtimesheetadmin")
	public String displayApprovalAdmin(Model model){
		
		System.out.println("in admin list");
		List<TimeSheet> tslist = tsrepo.findAll();
		model.addAttribute("displaytslist", tslist);
		
		TimeSheet ts1 = new TimeSheet();
		model.addAttribute("searchts",ts1);
		
		return "listTimeSheetAdmin";
		
		
		
	}
	
	@RequestMapping(value="/listtimesheetadmin",method=RequestMethod.POST, params={"approve"})
	public String updateApprove( Model model, HttpServletRequest req) {
		
		
		Integer tsId = Integer.valueOf(req.getParameter("approve"));
		System.out.println("button triggered "+ tsId);
		
		TimeSheet ts = tsrepo.findById(tsId).get();
		ts.setApprovalStatus("Finalized");
		tsrepo.save(ts);
		
		List<TimeSheet> tslist = tsrepo.findAll();
		model.addAttribute("displaytslist", tslist);
		
		
		//TimeSheet ts1 ;
		
		return "listTimeSheetAdmin";
	}
	
	
//	
//	@PutMapping("updateSpeaker/{id}")
//	public void updateSpeaker(@PathVariable(value="id") int id, @RequestBody Speaker speak) throws ResourceNotFoundException{
//		Speaker speaker = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Speaker not found for this id :: " + id)
//				);
//		 service.updateTalk(speak, id);
//	}
//	
	
	
	
}
