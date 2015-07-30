package com.windy.medqc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;    
import org.springframework.mock.web.MockHttpServletResponse;    
import org.springframework.web.servlet.ModelAndView; 

import junit.framework.Assert;

public class HomeControllerTests extends JUnitActionBase{

	@Test
	public void testHome() throws Exception   {
		 MockHttpServletRequest request = new MockHttpServletRequest();    
	        MockHttpServletResponse response = new MockHttpServletResponse();    
	        request.setRequestURI("/patient/getpatientbyid");    
	        request.setMethod("GET");
	        request.setParameter("id", "1");
	        // 执行URI对应的action    
	        final ModelAndView mav = this.excuteAction(request, response);    
	        // Assert logic    
	        //Assert.assertEquals("", mav.getViewName());    
	        //String msg=(String)request.getAttribute("msg");    
	        //System.out.println(msg);    
	}

}
