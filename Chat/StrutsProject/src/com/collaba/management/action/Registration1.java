package com.collaba.management.action;

import com.collaba.management.vo.ProjectVO;
import com.collaba.management.vo.RegistrationVO;
import com.collaba.management.dao.RegistrationDao;
import com.collaba.management.daofactory.DaoFactoryImpl;
import com.collaba.management.daoimpl.RegistrationDaoImpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Registration1 extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware,ApplicationAware
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
	

	public String register() throws Exception
	{
		int result=0;
		RegistrationVO v=new RegistrationVO();
		RegistrationVO vo=new RegistrationVO();
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
			return 	ERROR;
		}
		}
	}
	public String update() throws Exception
	{
		return 	SUCCESS;
	}
	public String delete() throws Exception 
	{
		return SUCCESS;
	}
	
	public String updateuser() throws Exception
	{
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		String loginid=request.getParameter("loginid");
		System.out.println(name);
		System.out.println(password);
		result=dao.find(loginid,name,password);
		
		if(result==1)
		{
			session.setAttribute("loginid", loginid);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	
	public String deleteuser() throws Exception
	{
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		String loginid=request.getParameter("loginid");
		System.out.println(name);
		System.out.println(password);
			RegistrationVO v=new RegistrationVO();
			v.setLoginid(loginid);
			v.setName(name);
			v.setPassword(password);
			int temp=dao.delete(v);
			System.out.println(+temp);
			if(temp==1)
			return SUCCESS;
			else
			return ERROR;
			
	}
	
	public String registeragain() throws Exception
	{
		String loginid=request.getParameter("loginid");
		String loginid1=request.getParameter("loginid1");
		System.out.println(loginid1);
		int temp1=0,temp2=0;
		String builder="builder";
		if(loginid.equals(loginid1))
		{
			
			temp1=some(1);
		}
		if(temp1==1)
		{
			int result=0;
			RegistrationVO v=new RegistrationVO();
			String address=request.getParameter("address");
			String emailid=request.getParameter("emailid");
			String contactnumber=request.getParameter("contact");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String country=request.getParameter("country");
			String type=request.getParameter("type");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			System.out.println(loginid);System.out.println(password);System.out.println(username);
			
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
			
			result=dao.updateuser(v);
			if(result!=0 && type.equals("Builder") )
			{
				session.setAttribute("user", username);
				session.setAttribute("loginid",loginid);
				return builder;
			}
			else if(result!=0 && type.equals("Agent")||type.equals("Owner"))
			{
				session.setAttribute("user", username);
				return SUCCESS;
			}
			else
			{
				return 	ERROR;
		}}
		else
		{
			return ERROR;
		}
	}
	public int some(int num)
	{
		if(num==1)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	public String Find() throws Exception
	{
		System.out.println("Inside find");
		String username=request.getParameter("user");
		String loginid=request.getParameter("loginid");
		System.out.println("For processing inforamion");
		String result=null;
		if(username.equals(null)||loginid.equals(null))
		{
			return INPUT;
		}
		else
		{
			RegistrationDao registrationdao= DaoFactoryImpl.getInstance().RegistrationDao();
			result=registrationdao.register(loginid, username);
			session.setAttribute("result",result);
		}
		if(result.equals(null))
		{
			return 	ERROR;
		}
		else
		{
			return SUCCESS;
		}
	}
	public String projectdetail() throws Exception
	{
		String projectypeid=null;
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String cost=request.getParameter("costrange");
		String projecttype=request.getParameter("Property Type");
		String builderid=null;
		int i=dao.generateid();
		builderid="Pro"+i;
		System.out.println(builderid);
		if(projecttype.equals("Independent House"))
			projectypeid="1";
		else if(projecttype.equals("Residential"))
			projectypeid="2";
		else if(projecttype.equals("Apartment"))
			projectypeid="3";
		else if(projecttype.equals("Plot land"))
			projectypeid="4";
		else if(projecttype.equals("Farm House"))
			projectypeid="5";
		String loginid=request.getParameter("loginid");
		System.out.println(loginid);
		ProjectVO v=new ProjectVO();
		v.setName(name);
		v.setLocation(location);
		v.setCost(cost);
		v.setProjecttype(projectypeid);
		v.setBuilderid(loginid);
	    v.setId(builderid);
		int result=dao.createproject(v);
		System.out.println("hwudhwduwduw  :"+result);
		
		System.out.println(name);System.out.println(location);System.out.println(cost);System.out.println(projecttype);System.out.println(loginid);
		return SUCCESS;
	}
	public String detail() throws Exception
	{
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		String cost=request.getParameter("costrange");
		String loginid=request.getParameter("loginid");
	
		String projecttype=request.getParameter("Property Type");
		RegistrationVO v=new RegistrationVO();
		v.setName(name);
		v.setLocation(location);
		v.setCost(cost);
		v.setProjecttype(projecttype);
		
		System.out.println(name);System.out.println(location);System.out.println(cost);System.out.println(projecttype);System.out.println(loginid);
		return SUCCESS;
		
	}
	public void validate()
	{
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
		if(address.equals(""))
		{
			this.addFieldError("address", "Address should not be blank");
			
		}
		if(city.equals("--Select City--"))
		{
			this.addFieldError("city", city +" is not a city");
		}
		if(state.equals("--Select State--"))
		{
			this.addFieldError("state", state+" is not a state");
		}
		if(country.equals("-- Select Country --"))
		{
			this.addFieldError("country", country+" is not a country");
		}
		if(username.equals(""))
		{
			this.addFieldError("username", "User name should not be blank");
		}
		if(password.equals(""))
		{
			this.addFieldError("userpassword","Password should not be blank");
		}
		if(loginid.equals(""))
		{
			this.addFieldError("userloginid", "Login id should  not be blank");
		}
		if(contactnumber.equals(""))
		{
			this.addFieldError("contact", "Please enter your contact number");
		}
		if(emailid.equals(""))
		{
			this.addFieldError("emailid", "Please enter your email id");
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