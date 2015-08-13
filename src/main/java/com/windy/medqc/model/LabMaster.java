package com.windy.medqc.model;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.annotations.Type;

import com.windy.medqc.util.GBKString;

@Entity
@Table(name = "LAB_MASTER_V")
public class LabMaster implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1784305125555002252L;

	private String testID;
	private String patientID;
	private int visitID;
	private String subject;
	private String specimen;
	private Date requestTime;
	private String requestDoctor;
	private String resultStatus;
	private Date reportTime;
	private String reportDoctor;
	
	
	@Column(name = "patient_id")
	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	@Column(name = "visit_id")
	public int getVisitID() {
		return visitID;
	}

	public void setVisitID(int visitID) {
		this.visitID = visitID;
	}
	@Column(name = "subject")
	@Type(type = "com.windy.medqc.util.GBKString")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Column(name = "specimen")
	@Type(type = "com.windy.medqc.util.GBKString")
	public String getSpecimen() {
		return specimen;
	}

	public void setSpecimen(String specimen) {
		this.specimen = specimen;
	}
	@Column(name = "request_time")
	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	@Column(name = "request_doctor")
	@Type(type = "com.windy.medqc.util.GBKString")
	public String getRequestDoctor() {
		return requestDoctor;
	}

	public void setRequestDoctor(String requestDoctor) {
		this.requestDoctor = requestDoctor;
	}
	
	
	@Column(name = "report_time")
	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	@Column(name = "report_doctor")
	@Type(type = "com.windy.medqc.util.GBKString")
	public String getReportDoctor() {
		return reportDoctor;
	}

	public void setReportDoctor(String reportDoctor) {
		this.reportDoctor = reportDoctor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name = "TEST_ID")
	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}
	
	@Column(name = "result_status")
	@Type(type = "com.windy.medqc.util.GBKString")
	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}
}
