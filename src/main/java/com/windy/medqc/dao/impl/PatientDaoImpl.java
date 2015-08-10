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

import com.windy.medqc.dao.IPatientDao;
import com.windy.medqc.model.Patient;

@Repository("patientDao")
public class PatientDaoImpl  extends HibernateDaoSupport  implements IPatientDao {
	private static final Logger log = LoggerFactory.getLogger(PatientDaoImpl.class);
	
	@Resource  
    public void setMySessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    }  
	protected void initDao() {
	}
	@Override
	public Patient findById(Integer id) throws Exception {
		log.debug("getting TUser instance with id: " + id);
		try {
			Patient instance = (Patient) getHibernateTemplate().get(
					"com.windy.medqc.model.Patient", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Integer getTotalCount() {
		List list = getHibernateTemplate().find("select count(*) from Patient"); 
		Number num = (Number) list.get(0); 
		return num.intValue(); 
	}
	public List findAll() {
		log.debug("finding all Menu instances");
		try {
			String queryString = "from Patient patient";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Patient> getPatientsForPage(final int length,final int offset) {
		// TODO Auto-generated method stub
		System.out.print(length+" "+offset);
		List<Patient> list = getHibernateTemplate().executeFind(new HibernateCallback() { 
			public Object doInHibernate(Session session) 
			throws HibernateException, SQLException { 
			Query query = session.createQuery("from Patient"); 
			query.setFirstResult(offset); 
			query.setMaxResults(length); 
			List list = query.list(); 
			return list; 
			}
		});
		return list;
	}
	
}
