package com.windy.medqc.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.windy.medqc.dao.ILabMasterDao;
import com.windy.medqc.dao.IPatientDao;
import com.windy.medqc.model.LabMaster;
import com.windy.medqc.model.Patient;
import com.windy.medqc.service.ILabMasterService;
import com.windy.medqc.service.IPatientService;
import com.windy.medqc.util.ExportExcel;

@Service("labMasterService")
public class LabMasterServiceImpl implements ILabMasterService{
	/*@Autowired
	private IPatientDao patientDao;
	*/
	@Autowired
	private ILabMasterDao labMasterDao;

	@Override
	public Patient getLabMasterById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getLabMasterList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabMaster> getLabMastersForPage(int pageSize, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabMaster> findAllByPatient(String szPatientID, int visitId) {
		// TODO Auto-generated method stub
		List<LabMaster> labMasters=labMasterDao.findAllByPatient(szPatientID, visitId);
		return labMasters;
	}
	
	
	
}
