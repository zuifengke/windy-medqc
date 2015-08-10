package com.windy.medqc.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.windy.medqc.model.Patient;
import com.windy.medqc.service.IPatientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@TransactionConfiguration(defaultRollback = false,transactionManager="txManager")
public class patientServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests  {
	@Autowired
	private IPatientService patientService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPatientList() throws Exception {
		List<Patient> lstPatients= patientService.getPatientList();
	}
	
}
