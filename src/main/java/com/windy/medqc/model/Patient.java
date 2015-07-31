package com.windy.medqc.model;

import java.io.UnsupportedEncodingException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.windy.medqc.util.GBKString;

@Entity
@Table(name = "VIE_PATIENT")
public class Patient implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1784305125555002252L;
	private static final String GBKString = null;
	private Integer medicalID;
	private String patientID;
	private String visitID;
	private String patientName;
	private String inpNo;
	private String deptCode;
	
	@Id
	@Column(name = "Medical_ID")
	public Integer getMedicalID() {
		return medicalID;
	}
	public void setMedicalID(Integer medicalID) {
		this.medicalID = medicalID;
	}
	
	@Column(name = "Patient_ID")
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	/**
	 * @return the visitID
	 */
	@Column(name = "Visit_ID")
	public String getVisitID() {
		return visitID;
	}
	/**
	 * @param visitID the visitID to set
	 */
	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}
	/**
	 * @return the patientName
	 */
	@Type( type = "com.windy.medqc.util.GBKString")
	@Column(name = "patient_name")
	public String getPatientName() {
		
		return patientName;
	}
	/**
	 * @param patientName the patientName to set
	 * @throws UnsupportedEncodingException 
	 */
	public void setPatientName(String patientName) throws UnsupportedEncodingException {
	
		this.patientName = patientName;
	}
	/**
	 * @return the inpNo
	 */
	@Column(name = "inp_no")
	public String getInpNo() {
		return inpNo;
	}
	/**
	 * @param inpNo the inpNo to set
	 */
	public void setInpNo(String inpNo) {
		this.inpNo = inpNo;
	}
	/**
	 * @return the deptCode
	 */
	@Column(name = "dept_code")
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * @param deptCode the deptCode to set
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
}
