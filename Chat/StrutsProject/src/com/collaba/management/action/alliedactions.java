package com.collaba.management.action;

import com.collaba.management.vo.RegistrationVO;
import com.collaba.management.dao.RegistrationDao;
import com.collaba.management.daofactory.DaoFactoryImpl;
import com.collaba.management.daoimpl.RegistrationDaoImpl;
import com.collaba.management.vo.AlliedVO;
import com.collaba.management.dao.AlliedDao;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class alliedactions extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession(false);
	//private HttpSession session ;
	@SuppressWarnings({ "unused", "rawtypes" })
	private Map sessionMap; 
	AlliedDao ad= DaoFactoryImpl.getInstance().architectdao();
	private Logger log = Logger.getLogger(Registration.class.getName());
	int result=0;	
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}

    public HttpServletRequest getServletRequest() {
		return request;
	}
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.request = servletRequest;
	}
	public HttpServletResponse getServletResponse() {
		return response;
	}
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.response = servletResponse;
	}
	
	public String logout() throws Exception
	{
		return SUCCESS;
	}
	public String home() throws Exception
	{
		return SUCCESS;
	}
	public String leftsearch() throws Exception
	{
		return SUCCESS;
	}
	public String leftpost() throws Exception
	{
		return SUCCESS;
	}
	public String leftrequire() throws Exception
	{
		return SUCCESS;
	}
	public String leftservices() throws Exception
	{
		return SUCCESS;
	}
	public String leftloan() throws Exception
	{
		return SUCCESS;
	}
	public String leftinvestor() throws Exception
	{
		return SUCCESS;
	}
	public String leftcompanyinfo() throws Exception
	{
		return SUCCESS;
	}
	public String allied() throws Exception
	{
		String architect="architect";
		String vaastu="vaastu";
		String builder="builder";
		String building="building";
		String contractor="contractor";
		String select="select";
		String string;
		String alliedtype=null;
		String name=request.getParameter("alliedservices");
		String service=request.getParameter("alliedservices");
		
		if(name.equals("Architects"))
			alliedtype="1";
		else if(name.equals("Vaastu Consultants"))
			alliedtype="2";
		else if(name.equals("Builders & Developers"))
			alliedtype="3";
		else if(name.equals("Building Material"))
			alliedtype="5";
		else if(name.equals("Building Contractors"))
			alliedtype="4";
		else{}
		Collection<AlliedVO> c=null;
		c=ad.findAll(alliedtype);
		session.setAttribute("allied", c);
		if(service.equals("Architects"))
			string=architect;
		else if(service.equals("Vaastu Consultants"))
			string=vaastu;
		else if(service.equals("Builders & Developers"))
			string=builder;
		else if(service.equals("Building Material"))
			string=building;
		else if(service.equals("Building Contractors"))
			string=contractor;
		else if(service.equals("--- Select Service ---"))
			string=select;
		else
			string=select;
			
		return string;
			
	}
	public String allieddetail() throws Exception 
	{
		String id=request.getParameter("choice");
		if(id.equals(null))
		{
			return ERROR;
		}
		else
		{
		System.out.println(id);
		Collection<AlliedVO> c=null;
		c=ad.findById(id);
		session.setAttribute("alliedservice", c);
		return SUCCESS;
		}
	}
	public String alliedupdate() throws Exception
	{
		String id=request.getParameter("choice");
		System.out.println(id);
		if(id.equals(null))
		return ERROR;
		else
		{session.setAttribute("id", id);
		return SUCCESS;
		}
	}
	public String allieddelete() throws Exception
	{
		String id=request.getParameter("choice");
		if(id.equals(null))
		{
			return ERROR;
		}
		else
		{
		int result=ad.delete(id);
		System.out.println(id);
		if(result==0)
		return ERROR;
		else
		return SUCCESS;
		}
	}
	/*	public String alliedlogin1() throws Exception
	{
		AlliedDao ad= DaoFactoryImpl.getInstance().architectdao();
		AlliedVO v=new AlliedVO();
		String id=request.getParameter("serviceid");
		v.setId(request.getParameter("serviceid"));
		v.setEmailid(request.getParameter("emailid"));
		v.setAllied(request.getParameter("alliedservices"));
		int result = 0;
		result = ad.checkupdate(v);
		if(result==1)
		{
			session.setAttribute("id",id);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
  public String alliedlogin2() throws Exception
	{
		AlliedDao ad= DaoFactoryImpl.getInstance().architectdao();
		AlliedVO v=new AlliedVO();
		String id=request.getParameter("serviceid");
		v.setId(request.getParameter("serviceid"));
		v.setEmailid(request.getParameter("emailid"));
		v.setAllied(request.getParameter("alliedservices"));
		int result = 0;
		result = ad.checkupdate(v);
		if(result==1)
		{
			ad.delete(v);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}*/
	public String myservices1() throws Exception
	{
		
		String aid=request.getParameter("id");
		System.out.println(aid);
		AlliedVO v=new AlliedVO();
		String name=request.getParameter("alliedservices");
		String alliedtype=null;
		if(name.equals("Architects"))
			alliedtype="1";
		else if(name.equals("Vaastu Consultants"))
			alliedtype="2";
		else if(name.equals("Builders & Developers"))
			alliedtype="3";
		else if(name.equals("Building Material"))
			alliedtype="5";
		else if(name.equals("Building Contractors"))
			alliedtype="4";
		else{}
		
		
		v.setAid(aid);
		v.setCompany(request.getParameter("companyname"));
		v.setUrl(request.getParameter("companywebsite"));
		v.setAddress1(request.getParameter("add1"));
		v.setAddress2(request.getParameter("add2"));
		v.setCity(request.getParameter("city"));
		v.setState(request.getParameter("state"));
		v.setContact(request.getParameter("number"));
		v.setCperson(request.getParameter("contactperson"));
		v.setEmailid(request.getParameter("emailid"));
		
		v.setAllied(alliedtype);
		v.setCountry(request.getParameter("country"));
		int result=ad.update(v);
		System.out.println(result);
		if(result>0)
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}
}