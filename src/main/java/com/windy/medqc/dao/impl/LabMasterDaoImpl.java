package com.windy.medqc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.windy.medqc.dao.ILabMasterDao;
import com.windy.medqc.dao.IPatientDao;
import com.windy.medqc.model.Patient;

@Repository("labMasterDao")
public class LabMasterDaoImpl  extends HibernateDaoSupport    implements ILabMasterDao {
	private static final Logger log = LoggerFactory.getLogger(LabMasterDaoImpl.class);
	
	@Resource  
    public void setMySessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    }  
	protected void initDao() {
	}
	
	public List findAll() {
		log.debug("finding all Menu instances");
		try {
			String queryString = "from LabMaster labMaster";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	@Override
	public Patient findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Patient> getPatientsForPage(int length, int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
