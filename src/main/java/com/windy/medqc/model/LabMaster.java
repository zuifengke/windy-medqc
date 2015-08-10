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
@Table(name = "LAB_MASTER_V")
public class LabMaster implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1784305125555002252L;

	private String testID;
	
	@Id
	@Column(name = "TEST_ID")
	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}
}
