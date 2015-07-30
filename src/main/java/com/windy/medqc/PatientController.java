package com.windy.medqc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "patient";
	}
	
}
