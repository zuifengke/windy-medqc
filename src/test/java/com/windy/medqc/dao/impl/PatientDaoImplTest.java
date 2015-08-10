package com.windy.medqc.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.windy.medqc.dao.IPatientDao;
import com.windy.medqc.model.LabMaster;
import com.windy.medqc.service.IPatientService;
import com.windy.medqc.util.CustomerContextHolder;
import com.windy.medqc.util.DataSourceMap;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@TransactionConfiguration(defaultRollback = false,transactionManager="txManager")
public class PatientDaoImplTest {
	@Autowired
	private IPatientDao patientDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAll() {
		 patientDao.findAll();
		
	}

}
