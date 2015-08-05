package com.windy.medqc;

import java.util.List;

import org.junit.Assert;    
import org.junit.Test;    
import org.springframework.mock.web.MockHttpServletRequest;    
import org.springframework.mock.web.MockHttpServletResponse;    
import org.springframework.web.servlet.ModelAndView; 




public class PatientControllerTest  extends JUnitActionBase  {
	 @Test    
	    public void testList() throws Exception {    
		    System.out.println("1");
		    MockHttpServletRequest request = new MockHttpServletRequest();    
	        MockHttpServletResponse response = new MockHttpServletResponse();    
	        request.setRequestURI("/timerecord.do");
	        request.setParameter("method", "toShowAllPage");
	        request.setMethod("GET"); 
	        System.out.println("1");
	        // 执行URI对应的action    
	        final ModelAndView mav = this.excuteAction(request, response);    
	        // Assert logic    
	       // Assert.assertEquals("user/list", mav.getViewName());    
	        String msg=(String)request.getAttribute("msg");    
	        System.out.println(msg);    
	    }
	 @Test    
	    public void queryListTest() throws Exception {    
		    System.out.println("1");
		    MockHttpServletRequest request = new MockHttpServletRequest();    
	        MockHttpServletResponse response = new MockHttpServletResponse();    
	        request.setRequestURI("/timerecord.do");
	        request.setMethod("POST");
	        request.setParameter("method", "querylist"); 
	        System.out.println("1");
	        // 执行URI对应的action    
	        final ModelAndView mav = this.excuteAction(request, response); 
	        System.out.println(response.getContentAsString());  
	        // Assert logic    
	       // Assert.assertEquals("user/list", mav.getViewName());    
	        //String msg=(String)request.getAttribute("msg");    
	        //System.out.println(msg);    
	    }
	 @Test    
	    public void queryList2Test() throws Exception {    
		    System.out.println("1");
		    System.out.println("wo zai ce ceshi ");
		    System.out.println("hell world 14.28");
		    MockHttpServletRequest request = new MockHttpServletRequest();    
	        MockHttpServletResponse response = new MockHttpServletResponse();    
	        request.setRequestURI("/timerecord/querylist2");
	        request.setParameter("check_date", "2015-04-28");
	        request.setParameter("qc_result", "3");
	        request.setParameter("page", "1");
	        request.setParameter("rows", "10");
	        request.setMethod("POST");
	        System.out.println("1");
	        // 执行URI对应的action    
	        final ModelAndView mav = this.excuteAction(request, response); 
	        System.out.println(response.getContentAsString());  
	        // Assert logic    
	       // Assert.assertEquals("user/list", mav.getViewName());    
	        //String msg=(String)request.getAttribute("msg");    
	        //System.out.println(msg);    
	    }
	 @Test    
	    public void exportToExcelTest() throws Exception {    
		    System.out.println("1");
		    MockHttpServletRequest request = new MockHttpServletRequest();    
	        MockHttpServletResponse response = new MockHttpServletResponse();    
	        request.setRequestURI("/patient/exportToExcel");
	        request.setParameter("check_date", "2015-04-28");
	        request.setParameter("qc_result", "5");
	        request.setParameter("page", "1");
	        request.setParameter("rows", "10");
	        request.setMethod("POST");
	        System.out.println("1");
	        // 执行URI对应的action    
	        final ModelAndView mav = this.excuteAction(request, response); 
	        System.out.println(response.getContentAsString());  
	        // Assert logic    
	       // Assert.assertEquals("user/list", mav.getViewName());    
	        //String msg=(String)request.getAttribute("msg");    
	        //System.out.println(msg);    
	    }
}
