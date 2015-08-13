package com.windy.medqc.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.windy.medqc.model.LabMaster;
import com.windy.medqc.model.Patient;
import com.windy.medqc.util.CustomerContextHolder;
import com.windy.medqc.util.DataSourceMap;

@Repository("labMasterDao")
public class LabMasterDaoImpl  extends HibernateDaoSupport    implements ILabMasterDao {
	private static final Logger log = LoggerFactory.getLogger(LabMasterDaoImpl.class);
	
	@Resource  
    public void setMySessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    }  
	protected void initDao() {
		log.info("initDao");
		
	}
	
	public List findAll() {
		CustomerContextHolder.setCustomerType(DataSourceMap.meddocString);//设置数据源
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
	@Override
	public List<LabMaster> findAllByPatient(String szPatientID, int visitId) {
		CustomerContextHolder.setCustomerType(DataSourceMap.meddocString);//设置数据源
		System.out.println("findAll");
		Map<String, Object> result = new HashMap<String, Object>(1); 
		String fullQuery = " from LabMaster labMaster where 1=1 "; 
		String orderString = "";
		StringBuffer sb = new StringBuffer();
		Map<String,Object> params = new HashMap<String,Object>();
		
		sb.append(" and Patient_ID = :PatientID");
		params.put("PatientID", szPatientID);

		sb.append(" and Visit_ID = :VisitID");
		params.put("VisitID", visitId);
		
		Query queryList = getSession().createQuery(fullQuery + sb.toString() + orderString);
     	if(params!=null && !params.isEmpty()){
			Iterator<String> it = params.keySet().iterator();
			while(it.hasNext()){					
				String key = it.next();	
				queryList.setParameter(key, params.get(key));
			}	
		}			
		List list = queryList.list();
			
		return list;
	}
	
}
