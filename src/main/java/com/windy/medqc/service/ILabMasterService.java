package com.windy.medqc.service;

import java.util.List;
import java.util.Map;

import com.windy.medqc.model.LabMaster;
import com.windy.medqc.model.Patient;

public interface ILabMasterService {
	Patient getLabMasterById(int id) throws Exception;
	List<Patient> getLabMasterList() throws Exception;
	
	public List<LabMaster> getLabMastersForPage(final int pageSize,final int offset);
	public Integer getTotalCount();
	public List<LabMaster> findAllByPatient(String szPatientID,int visitId);
}
