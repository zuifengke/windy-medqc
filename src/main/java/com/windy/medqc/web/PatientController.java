package com.windy.medqc.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import antlr.collections.List;

import com.windy.medqc.model.Patient;
import com.windy.medqc.service.IPatientService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private IPatientService patientService;
	
	public IPatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(IPatientService patientService) {
		this.patientService = patientService;
	}
	
	@RequestMapping(value = "/getpatientbyid", method = RequestMethod.GET)

	public String getPatientByID(@RequestParam("id") int id,Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", id);
		System.out.println(id);
		Patient patient= this.patientService.getPatientById(id);
		model.addAttribute("patient", patient );
	    model.addAttribute("id",id);
		return "patient";
	}
	@RequestMapping(value = "/getPatientList", method = RequestMethod.GET)
	@ResponseBody 
	public  Map<String, Object>  getPatientList(Model model) throws Exception {
		java.util.List<Patient> lstPatients=this.patientService.getPatientList();
		Map<String,Object> mapUsers=new HashMap<String, Object> ();
		model.addAttribute("lstPatients", lstPatients );
		mapUsers.put("lstPatients", lstPatients);
		return mapUsers;
	}
}
