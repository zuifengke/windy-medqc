package com.windy.medqc.dao;

import java.util.List;

import com.windy.medqc.model.Patient;

public interface IPatientDao {
	public abstract Patient findById(java.lang.Integer id) throws Exception;
	public abstract List findAll();
	public List<Patient> getPatientsForPage(final int length,final int offset);
	public Integer getTotalCount();
}
