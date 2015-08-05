package com.windy.medqc.service;

import java.util.List;
import java.util.Map;

import com.windy.medqc.model.Patient;

public interface IPatientService {
	Patient getPatientById(int id) throws Exception;
	List<Patient> getPatientList() throws Exception;
	boolean exportToExcel(List<Patient> lstTimeRecords, String fileName);
}
