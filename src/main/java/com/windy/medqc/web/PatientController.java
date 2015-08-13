package com.windy.medqc.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.windy.medqc.model.Patient;
import com.windy.medqc.service.IPatientService;
import com.windy.medqc.util.DataGridModel;
import com.windy.medqc.vo.Pagination;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	private List<Patient> patients;
	@Autowired
	private IPatientService patientService;
	
	public IPatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(IPatientService patientService) {
		this.patientService = patientService;
	}
	
	private Pagination pagination;
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	@RequestMapping(value = "/getPatientByID", method = RequestMethod.GET)
	public String getPatientByID(@RequestParam("id") int id,Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", id);
		System.out.println(id);
		Patient patient= this.patientService.getPatientById(id);
		model.addAttribute("patient", patient );
	    model.addAttribute("id",id);
		return "patient";
	}
	@RequestMapping(value = "/getPatientList", method = RequestMethod.GET)
	@ResponseBody 
	public  Map<String, Object>  getPatientList(Model model) throws Exception {
		java.util.List<Patient> lstPatients=this.patientService.getPatientList();
		Map<String,Object> mapUsers=new HashMap<String, Object> ();
		model.addAttribute("lstPatients", lstPatients );
		mapUsers.put("lstPatients", lstPatients);
		return mapUsers;
	}
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getPatientListPage(Model model) throws Exception {
		java.util.List<Patient> lstPatients=this.patientService.getPatientList();
		Map<String,Object> mapUsers=new HashMap<String, Object> ();
		model.addAttribute("lstPatients", lstPatients );
		
		return "patient/list";
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String getUserListPage(@RequestParam(value="pageIndex",required=false) Integer pageIndex, Model model) throws Exception {
		/*java.util.List<Patient> lstPatients=this.patientService.getPatientList();
		Map<String,Object> mapUsers=new HashMap<String, Object> ();
		model.addAttribute("lstPatients", lstPatients );*/
		//System.out.print("pageIndex:"+pageIndex);
		
		if(this.pagination==null)
		{
			this.pagination=new Pagination();
			this.pagination.setPageSize(8);
		}
		if(pageIndex!=null)
			this.pagination.setPageIndex(pageIndex);
		System.out.println("pageIndex:"+this.pagination.getPageIndex());
		System.out.println("beginPage:"+this.pagination.getBeginPage());
		System.out.println("endPage:"+this.pagination.getEndPage());
		this.pagination.setTotalCount(this.patientService.getTotalCount());
		//System.out.println("pageCount:"+this.pagination.getPageCount());
		
		List<Patient> lstPatients = this.patientService.getPatientsForPage(this.pagination.getPageSize(), this.pagination.getOffset());
		model.addAttribute("lstPatients", lstPatients );
		model.addAttribute("pagination", pagination );
		
		return "patient/userlist";
	}

	@RequestMapping(value = "/exportToExcel", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> exportToExcel(HttpServletRequest request,DataGridModel dgm,
			Patient timeRecord) throws Exception {
		// spring太给力了，可以自动装配两个对象 会自动的装返回的Map转换成JSON对象
		// return userService.getPageListByExemple(dgm, user);
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("message", "导出成功");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// timeRecord.setCheck_date(sdf.parse("2015-4-9 11:29:00"));
		//timeRecord.setCheck_date(sdf.parse("2015-04-24 14:51:55"));
		List<Patient> lstPatients = patientService.getPatientList();
		String sheetName="excel.xls";
		String fileName=request.getSession().getServletContext().getRealPath("/")
		+"resources\\temp\\"+sheetName;
		System.out.println(fileName);
		if(!patientService.exportToExcel(lstPatients, fileName))
			map.put("message", "导出成功");
		else {
			map.put("message", "导出失败");
		}
		map.put("url",sheetName);
		return map;
	}
	
	@RequestMapping(value="download", method = RequestMethod.GET)
    public String download(HttpServletRequest request,HttpServletResponse response,String sheetName) throws IOException{
		String fileName=request.getSession().getServletContext().getRealPath("/")+"\\resources\\temp\\"+sheetName;
		FileInputStream fInputStream =new FileInputStream(fileName);		
        ByteArrayOutputStream out=new ByteArrayOutputStream(1024);

        byte[] temp=new byte[1024];
       
        int size=0;
       
        while((size=fInputStream.read(temp))!=-1)
        {
            out.write(temp,0,size);
        }
        fInputStream.close();
       
        byte[] content=out.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((sheetName).getBytes(), "iso-8859-1"));
        ServletOutputStream out2 = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out2);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
}
