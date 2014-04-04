package com.collaba.management.action;

import com.collaba.management.vo.BuilderVO;
import com.collaba.management.vo.ProjectVO;
import com.collaba.management.vo.RegistrationVO;
import com.collaba.management.dao.RegistrationDao;
import com.collaba.management.daofactory.DaoFactoryImpl;
import com.collaba.management.daoimpl.RegistrationDaoImpl;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.Map;
import java.util.logging.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAware;

public class Registration extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware,ApplicationAware,ValidationAware
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
	RegistrationDao dao=new RegistrationDaoImpl();
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
	
	public String userlogin() throws Exception
	{
		
		return SUCCESS;
	}
	
	
	
	
	
	public String login() throws Exception
	{
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		String loginid=request.getParameter("loginid");
		System.out.println(name);
		System.out.println(password);
		System.out.println(request.getAuthType());
		System.out.println(request.getLocalAddr());
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteUser());
		ServletInputStream fis=request.getInputStream();
		fis.read();
		if(name.equals("")||loginid.equals("")||password.equals(""))
		{
			return INPUT;
		}
		else
		{
		result=dao.find(loginid,name,password);
		
		if(result==1)
		{
			session.setAttribute("user", name);
			return SUCCESS;
			
		}
		else
		{
			this.addActionMessage("mis-match in password,user name and loginid");
			return 	ERROR;
		}
		
		}
	
	}
	
		
	public String register() throws Exception
	{
		int result=0;
		RegistrationVO v=new RegistrationVO();
		String builder="builder";
		String address=request.getParameter("address");
		String emailid=request.getParameter("emailid");
		String contactnumber=request.getParameter("contact");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String type=request.getParameter("type");
		String username=request.getParameter("username");
		String password=request.getParameter("userpassword");
		String loginid=request.getParameter("userloginid");	
		System.out.println(loginid);System.out.println(password);System.out.println(username);
		if(address.equals("")||emailid.equals("")||contactnumber.equals("")||city.equals("")||state.equals("")||country.equals("")||username.equals("")||loginid.equals("")||password.equals(""))
		{
			return INPUT;
		}
		else
		{
		v.setAddress(address);
		v.setEmail(emailid);
		v.setCity(city);
		v.setState(state);
		v.setLoginid(loginid);
		v.setPassword(password);
		v.setContactnumber(contactnumber);
		v.setCountry(country);
		v.setUsertype(type);
		v.setName(username);
		result=dao.createuser(v);
		System.out.println(+result);
		session.setAttribute("user",username);
		
		if(result!=0 && type.equals("Builder") )
		{
			session.setAttribute("loginid", loginid);
			session.setAttribute("user", username);
			return builder;
		}
		else if(result!=0 && type.equals("Agent")||type.equals("Owner"))
		{
			session.setAttribute("user", username);
			return SUCCESS;
		}
		else
		{
			this.addActionError("mis-match in password,user name and loginid");
			return 	ERROR;
		}
		}
	}
	
	
		
	
	public void validate()
	{
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		String loginid=request.getParameter("loginid");
		
		if(name.equals(""))
		{
			
			this.addFieldError("userName", "Please enter user name");
			
		}
		if(loginid.equals(""))
		{
			this.addFieldError("loginid", "Please enter loginid");
		}
		if(password.equals(""))
		{
			this.addFieldError("password","Please enter password");
			
		}
		
		
		}
	
@Override
public void setSession(Map arg0)
	{
		// TODO Auto-generated method stub
		
	}
@Override
public void setApplication(Map arg0) {
	// TODO Auto-generated method stub
	
}
	
}