package com.windy.medqc.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public class GBKString  implements UserType{


    public GBKString() {   
        super();   
    }   
  
    public int[] sqlTypes() {   
        return new int[] { OracleTypes.VARCHAR };   
    }   
  
    public Class returnedClass() {   
        return String.class;   
    }   
  
    public boolean equals(Object x, Object y) throws HibernateException {   
        return (x == y) || (x != null && y != null && (x.equals(y)));   
    }   
  
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException,   
            SQLException {   
        String val = rs.getString(names[0]);   
        if (null == val) {   
            return null;   
        } else {   
            try {   
                val = new String(val.getBytes("iso-8859-1"), "GBK");   
            } catch (UnsupportedEncodingException e) {   
                throw new HibernateException(e.getMessage());   
            }   
            return val;   
        }   
    }   
  
    public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException,   
            SQLException {   
        if (value == null) {   
            st.setNull(index, OracleTypes.VARCHAR);   
        } else {   
            String val = (String)value;   
            try {   
            	val = new String(val.getBytes("GBK"), "ISO-8859-1");  
            } catch (UnsupportedEncodingException e) {   
                throw new HibernateException(e.getMessage());   
            }   
            st.setObject(index, val, OracleTypes.VARCHAR);   
        }   
    }   
    public Object deepCopy(Object value) throws HibernateException {   
        if (value == null)   
            return null;   
        return new String((String) value);   
    }   
  
    public boolean isMutable() {   
        return false;   
    }   
  
    public Object assemble(Serializable arg0, Object arg1) throws HibernateException {   
        // TODO Auto-generated method stub   
        return null;   
    }   
  
    public Serializable disassemble(Object arg0) throws HibernateException {   
        // TODO Auto-generated method stub   
        return null;   
    }   
  
    public int hashCode(Object arg0) throws HibernateException {   
        return HashCodeBuilder.reflectionHashCode(this);   
    }   
  
    public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {   
        // TODO Auto-generated method stub   
        return null;   
    }   

}
