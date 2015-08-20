package com.windy.medqc;

import java.util.List;

import org.junit.Assert;    
import org.junit.Test;    
import org.springframework.mock.web.MockHttpServletRequest;    
import org.springframework.mock.web.MockHttpServletResponse;    
import org.springframework.web.servlet.ModelAndView; 




public class LabMasterControllerTest  extends JUnitActionBase  {
	
	 @Test    
	    public void getLabMasterListTest() throws Exception {    
		    System.out.println("1");
		    System.out.println("wo zai ce ceshi ");
		    System.out.println("hell world 14.28");
		    MockHttpServletRequest request = new MockHttpServletRequest();    
	        MockHttpServletResponse response = new MockHttpServletResponse();    
	        request.setRequestURI("/labmaster/list");
	        request.setParameter("patientID", "Y100000003");
	        request.setParameter("visitID", "1");
	        request.setMethod("GET");
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
