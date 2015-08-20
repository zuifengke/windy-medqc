package com.windy.medqc.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.windy.medqc.dao.IPatientDao;
import com.windy.medqc.model.Patient;
import com.windy.medqc.service.IPatientService;
import com.windy.medqc.util.ExportExcel;

@Service("patientService")
public class patientServiceImpl implements IPatientService{
	/*@Autowired
	private IPatientDao patientDao;
	*/
	@Autowired
	private IPatientDao patientDao;
	
	

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

	@Override
	public boolean exportToExcel(List<Patient> lstPatients,String fileName) {
		// TODO Auto-generated method stub
		ExportExcel<Patient> ex = new ExportExcel<Patient>();
		String[] headers = {  "姓名", "病人ID号", "就诊次"};
		String[] fields = { "patientName","patientID", "visitID" };
		List<String> fieldsExport = java.util.Arrays.asList(fields);
		try {
			OutputStream out = new FileOutputStream(fileName);
			ex.exportExcel("测试POI导出EXCEL文档",headers, lstPatients, out,"",fieldsExport);
			out.close();
			System.out.println("excel导出成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Patient> getPatientsForPage(final int pageSize,final int offset) {
		// TODO Auto-generated method stub
		
		return this.patientDao.getPatientsForPage(pageSize,offset);
	}
	public Integer getTotalCount()
	{
		return this.patientDao.getTotalCount();
	}
	
}
