package com.windy.medqc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.windy.medqc.dao.IPatientDao;
import com.windy.medqc.model.Patient;
import com.windy.medqc.service.IPatientService;

@Service("patientService")
public class patientServiceImpl implements IPatientService{
	@Autowired
	private IPatientDao patientDao;
	
	public IPatientDao getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@Override
	public Patient getPatientById(int id) throws Exception {
		// TODO Auto-generated method stub
		return patientDao.findById(id);
	}

	@Override
	public List<Patient> getPatientList() throws Exception {
		// TODO Auto-generated method stub
		return patientDao.findAll();
	}
	

}
