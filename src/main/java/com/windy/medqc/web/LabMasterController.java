package com.windy.medqc.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.windy.medqc.model.LabMaster;
import com.windy.medqc.model.Patient;
import com.windy.medqc.service.ILabMasterService;
import com.windy.medqc.service.IPatientService;
import com.windy.medqc.util.CustomerContextHolder;
import com.windy.medqc.util.DataGridModel;
import com.windy.medqc.util.DataSourceMap;
import com.windy.medqc.vo.Pagination;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/labmaster")
public class LabMasterController {
	
	private static final Logger logger = LoggerFactory.getLogger(LabMasterController.class);

	
	private ILabMasterService labMasterService;
	
	public ILabMasterService getLabMasterService() {
		return labMasterService;
	}
	
	@Autowired
	public void setLabMasterService(ILabMasterService labMasterService) {
		this.labMasterService = labMasterService;
	}
	
	private Pagination pagination;
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getLabMasterList(@RequestParam(value="patientID" ,required=false) String patientId,@RequestParam(value="visitID",required=false) Integer visitID,Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", patientId);
		CustomerContextHolder.setCustomerType(DataSourceMap.meddocString);
		List<LabMaster> labMasters= this.labMasterService.findAllByPatient(patientId, visitID);
		model.addAttribute("labMasters", labMasters );
		return "labmaster/list";
	}
	
}
