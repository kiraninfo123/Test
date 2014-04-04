package com.collaba.management.action;

import com.collaba.management.vo.AlliedVO;
import com.collaba.management.vo.BuilderVO;
import com.collaba.management.vo.ProjectVO;
import com.collaba.management.vo.PropertyVO;
import com.collaba.management.dao.AlliedDao;
import com.collaba.management.dao.PropertyDao;
import com.collaba.management.dao.projectDao;
import com.collaba.management.daofactory.DaoFactoryImpl;
import com.collaba.management.daoimpl.Projectdaoimpl;
import com.collaba.management.daoimpl.Propertydaoimpl;
import com.collaba.management.daoimpl.loandaoimpl;
import com.collaba.management.exception.PropertyNotFoundException;
import com.collaba.management.vo.loanVO;


import java.util.Collection;
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
import com.collaba.management.dao.loanDao;

public class property extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware
{
	private HttpServletResponse response;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession(false);
	//private HttpSession session ;
	@SuppressWarnings({ "unused", "rawtypes" })
	private Map sessionMap; 
	private int comp=0;
	private PropertyVO vo;
	PropertyDao dao=new Propertydaoimpl();
	projectDao pdao=new Projectdaoimpl();
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
	
	public String quicksearch() throws Exception
	{
		System.out.println("From search");
		String location=request.getParameter("Location");
		String propertyfor=request.getParameter("propertyfor");
		String cost=request.getParameter("costrange");
		String propertytypeid=null;
		String property=request.getParameter("Property Type");
		if(property.equals("Residential"))
			propertytypeid="1";
		else if(property.equals("Commercial"))
			propertytypeid="2";
		else if(property.equals("Agricultural"))
			propertytypeid="3";
		else if(property.equals("Industrial"))
			propertytypeid="4";
		else
		{}
		PropertyVO v=new PropertyVO();
		v.setCity(location);
		v.setPropertyfor(propertyfor);
		v.setPropertytype(propertytypeid);
		v.setCostrange(cost);
		System.out.println(cost);System.out.println(propertyfor);System.out.println(propertytypeid);
		int size=0;
		Collection<PropertyVO> c=null;
		try {
				c=dao.find(v);
				size=c.size();
				System.out.println("Size of result :"+c.size());
		} catch (PropertyNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		if(size>0)
		{
			session.setAttribute("quicksearch", c);
			return SUCCESS;	
		}
		else
		{
			session.setAttribute("quicksearch",c);
			return ERROR;
		}
		
		}
	
	public String search() throws Exception
	{
		
		Collection result=null;
		String amenities=request.getParameter("amenities");
		String amenityid=null;
		String landmarkid="null";
		String landmark=null;
		String propertytypeid=null;
		String property=request.getParameter("Property Type");
		if(property.equals("Residential"))
			propertytypeid="1";
		else if(property.equals("Commercial"))
			propertytypeid="2";
		else if(property.equals("Agricultural"))
			propertytypeid="3";
		else if(property.equals("Industrial"))
			propertytypeid="4";
		else
		{}
		if(amenities.equals("Park"))
			amenityid="1";
		else if(amenities.equals("Gym"))
			amenityid="2";
		else if(amenities.equals("Swimming Pool"))
			amenityid="3";
		else if(amenities.equals("Car Parking"))
			amenityid="4";
		else if(amenities.equals("Swimming Pool+Park"))
			amenityid="5";
		else if(amenities.equals("Gym+Park"))
			amenityid="6";
		else if(amenities.equals("Swimming Pool+Gym"))
			amenityid="7";
		else if(amenities.equals("Car Parking+Park"))
			amenityid="8";
		else if(amenities.equals("Car Parking+Gym"))
			amenityid="9";
		else if(amenities.equals("Car Parking+Swimming Pool"))
			amenityid="10";
		else if(amenities.equals("Swimming Pool+Gym+Park"))
			amenityid="11";
		else if(amenities.equals("Car Parking+Gym+Park"))
			amenityid="12";
		else if(amenities.equals("Car Parking+Swimming Pool+Park"))
			amenityid="13";
		else if(amenities.equals("Car Parking+Swimming Pool+Park+Gym"))
			amenityid="14";
		System.out.println(amenityid);
		
		 landmark = request.getParameter("landmark");
		if(landmark.equals("School"))
			landmarkid="1";
		else if(landmark.equals("Hospital"))
			landmarkid="2";
		else if(landmark.equals("Railway Station"))
			landmarkid="3";
		else if(landmark.equals("Bus Stand"))
			landmarkid="4";
		else if(landmark.equals("School+Hospital"))
			landmarkid="5";
		else if(landmark.equals("School+Railway Station"))
			landmarkid="6";
		else if(landmark.equals("School+Bus Stand"))
			landmarkid="7";
		else if(landmark.equals("Hospital+Railway Station"))
			landmarkid="8";
		else if(landmark.equals("Hospital+Bus Stand"))
			landmarkid="9";
		else if(landmark.equals("Railway Station+Bus Stand"))
			landmarkid="10";
		else if(landmark.equals("School+Hospital+Railway Station"))
			landmarkid="11";
		else if(landmark.equals("School+Railway Station+Bus Stand"))
			landmarkid="12";
		else if(landmark.equals("School+Hospital+Bus Stand"))
			landmarkid="13";
		else if(landmarkid.equals("Hospital+Railway Station+Bus Stand"))
			landmarkid="14";
		else if(landmark.equals("School+Hospital+Railway Station+Bus Stand"))
			landmarkid="15";
		else
		{}
		
		PropertyVO v=new PropertyVO();
		v.setAmenities(amenityid);
		v.setBedrooms(request.getParameter("noofbedrooms"));
		v.setCity(request.getParameter("Location"));
		v.setCostrange(request.getParameter("costrange"));
		v.setDesc(request.getParameter("desc"));
		v.setFurnishing(request.getParameter("furnished"));
		v.setLandmark(landmarkid);
		v.setPropertyage(request.getParameter("propertyage"));
		v.setPropertyfor(request.getParameter("propertyfor"));
		v.setPropertytype(propertytypeid);
		v.setRooms(request.getParameter("noofrooms"));
		v.setSqft(request.getParameter("sqft"));
		v.setCostrange(request.getParameter("range"));
		v.setPosted("posted");
		
		result=dao.search(v);
		if(result.size()>0)
		{
			session.setAttribute("search", result);
			return SUCCESS;
		}
		else
		{
			session.setAttribute("search",result);
			return ERROR;
		}
}
	public String postproperty() throws Exception
	{
		String amenities=request.getParameter("amenities");
		String amenityid=null;
		String landmarkid="null";
		String landmark=null;
		String propertytypeid=null;
		String property=request.getParameter("Property Type");
		if(property.equals("Residential"))
			propertytypeid="1";
		else if(property.equals("Commercial"))
			propertytypeid="2";
		else if(property.equals("Agricultural"))
			propertytypeid="3";
		else if(property.equals("Industrial"))
			propertytypeid="4";
		else
		{}
		if(amenities.equals("Park"))
			amenityid="1";
		else if(amenities.equals("Gym"))
			amenityid="2";
		else if(amenities.equals("Swimming Pool"))
			amenityid="3";
		else if(amenities.equals("Car Parking"))
			amenityid="4";
		else if(amenities.equals("Swimming Pool+Park"))
			amenityid="5";
		else if(amenities.equals("Gym+Park"))
			amenityid="6";
		else if(amenities.equals("Swimming Pool+Gym"))
			amenityid="7";
		else if(amenities.equals("Car Parking+Park"))
			amenityid="8";
		else if(amenities.equals("Car Parking+Gym"))
			amenityid="9";
		else if(amenities.equals("Car Parking+Swimming Pool"))
			amenityid="10";
		else if(amenities.equals("Swimming Pool+Gym+Park"))
			amenityid="11";
		else if(amenities.equals("Car Parking+Gym+Park"))
			amenityid="12";
		else if(amenities.equals("Car Parking+Swimming Pool+Park"))
			amenityid="13";
		else if(amenities.equals("Car Parking+Swimming Pool+Park+Gym"))
			amenityid="14";
		System.out.println(amenityid);
		
		 landmark = request.getParameter("landmark");
		if(landmark.equals("School"))
			landmarkid="1";
		else if(landmark.equals("Hospital"))
			landmarkid="2";
		else if(landmark.equals("Railway Station"))
			landmarkid="3";
		else if(landmark.equals("Bus Stand"))
			landmarkid="4";
		else if(landmark.equals("School+Hospital"))
			landmarkid="5";
		else if(landmark.equals("School+Railway Station"))
			landmarkid="6";
		else if(landmark.equals("School+Bus Stand"))
			landmarkid="7";
		else if(landmark.equals("Hospital+Railway Station"))
			landmarkid="8";
		else if(landmark.equals("Hospital+Bus Stand"))
			landmarkid="9";
		else if(landmark.equals("Railway Station+Bus Stand"))
			landmarkid="10";
		else if(landmark.equals("School+Hospital+Railway Station"))
			landmarkid="11";
		else if(landmark.equals("School+Railway Station+Bus Stand"))
			landmarkid="12";
		else if(landmark.equals("School+Hospital+Bus Stand"))
			landmarkid="13";
		else if(landmarkid.equals("Hospital+Railway Station+Bus Stand"))
			landmarkid="14";
		else if(landmark.equals("School+Hospital+Railway Station+Bus Stand"))
			landmarkid="15";
		else
		{}
		
		PropertyVO v=new PropertyVO();
		int i=dao.generateid();
		System.out.println("id is :"+i);
		String prop="Prop_P_";
		v.setId(prop+i);
		System.out.println(prop);
		v.setAdd1(request.getParameter("add1"));
		v.setAdd2(request.getParameter("add2"));
		v.setAmenities(amenityid);
		v.setBedrooms(request.getParameter("noofbedrooms"));
		v.setCity(request.getParameter("city"));
		v.setContact(request.getParameter("contact"));
		v.setCostrange(request.getParameter("costrange"));
		v.setDesc(request.getParameter("desc"));
		v.setEmailid(request.getParameter("emailid"));
		v.setFurnishing(request.getParameter("furnished"));
		v.setLandmark(landmarkid);
		v.setName(request.getParameter("name"));
		v.setPlotno(request.getParameter("plotno"));
		v.setPropertyage(request.getParameter("propertyage"));
		v.setPropertyfor(request.getParameter("propertyfor"));
		v.setPropertytype(propertytypeid);
		v.setRooms(request.getParameter("noofrooms"));
		v.setSqft(request.getParameter("sqft"));
		v.setState(request.getParameter("state"));
		v.setCountry(request.getParameter("country"));
		v.setPosted("posted");
		System.out.println(landmarkid);
		System.out.println(amenityid);
		result=dao.create(v);
		System.out.println(+result);
			
			if(result==1)
			{
				return SUCCESS;
			}
			else
			{
				return 	ERROR;
			}
		
	}
	
	public String postrequirements() throws Exception
	{
		String amenities=request.getParameter("amenities");
		String amenityid=null;
		String landmarkid="null";
		String landmark=null;
		String propertytypeid=null;
		String property=request.getParameter("Property Type");
		if(property.equals("Residential"))
			propertytypeid="1";
		else if(property.equals("Commercial"))
			propertytypeid="2";
		else if(property.equals("Agricultural"))
			propertytypeid="3";
		else if(property.equals("Industrial"))
			propertytypeid="4";
		else
		{}
		if(amenities.equals("Park"))
			amenityid="1";
		else if(amenities.equals("Gym"))
			amenityid="2";
		else if(amenities.equals("Swimming Pool"))
			amenityid="3";
		else if(amenities.equals("Car Parking"))
			amenityid="4";
		else if(amenities.equals("Swimming Pool+Park"))
			amenityid="5";
		else if(amenities.equals("Gym+Park"))
			amenityid="6";
		else if(amenities.equals("Swimming Pool+Gym"))
			amenityid="7";
		else if(amenities.equals("Car Parking+Park"))
			amenityid="8";
		else if(amenities.equals("Car Parking+Gym"))
			amenityid="9";
		else if(amenities.equals("Car Parking+Swimming Pool"))
			amenityid="10";
		else if(amenities.equals("Swimming Pool+Gym+Park"))
			amenityid="11";
		else if(amenities.equals("Car Parking+Gym+Park"))
			amenityid="12";
		else if(amenities.equals("Car Parking+Swimming Pool+Park"))
			amenityid="13";
		else if(amenities.equals("Car Parking+Swimming Pool+Park+Gym"))
			amenityid="14";
		System.out.println(amenityid);
		
		 landmark = request.getParameter("landmark");
		if(landmark.equals("School"))
			landmarkid="1";
		else if(landmark.equals("Hospital"))
			landmarkid="2";
		else if(landmark.equals("Railway Station"))
			landmarkid="3";
		else if(landmark.equals("Bus Stand"))
			landmarkid="4";
		else if(landmark.equals("School+Hospital"))
			landmarkid="5";
		else if(landmark.equals("School+Railway Station"))
			landmarkid="6";
		else if(landmark.equals("School+Bus Stand"))
			landmarkid="7";
		else if(landmark.equals("Hospital+Railway Station"))
			landmarkid="8";
		else if(landmark.equals("Hospital+Bus Stand"))
			landmarkid="9";
		else if(landmark.equals("Railway Station+Bus Stand"))
			landmarkid="10";
		else if(landmark.equals("School+Hospital+Railway Station"))
			landmarkid="11";
		else if(landmark.equals("School+Railway Station+Bus Stand"))
			landmarkid="12";
		else if(landmark.equals("School+Hospital+Bus Stand"))
			landmarkid="13";
		else if(landmarkid.equals("Hospital+Railway Station+Bus Stand"))
			landmarkid="14";
		else if(landmark.equals("School+Hospital+Railway Station+Bus Stand"))
			landmarkid="15";
		else
		{}
		
		PropertyVO v=new PropertyVO();
		int i=dao.generateid();
		System.out.println("id is :"+i);
		String prop="Prop_R_";
		v.setId(prop+i);
		System.out.println(prop);
		v.setAdd1("Not Available");
		v.setAdd2(request.getParameter("add2"));
		v.setAmenities(amenityid);
		v.setBedrooms(request.getParameter("noofbedrooms"));
		v.setCity(request.getParameter("city"));
		v.setContact(request.getParameter("contact"));
		v.setCostrange(request.getParameter("costrange"));
		v.setDesc(request.getParameter("desc"));
		v.setEmailid(request.getParameter("emailid"));
		v.setFurnishing(request.getParameter("furnished"));
		v.setLandmark(landmarkid);
		v.setName(request.getParameter("name"));
		v.setPlotno("Not Available");
		v.setPropertyage(request.getParameter("propertyage"));
		v.setPropertyfor(request.getParameter("propertyfor"));
		v.setPropertytype(propertytypeid);
		v.setRooms(request.getParameter("noofrooms"));
		v.setSqft(request.getParameter("sqft"));
		v.setState(request.getParameter("state"));
		v.setCountry(request.getParameter("country"));
		v.setPosted("required");
		System.out.println(landmarkid);
		System.out.println(amenityid);
		result=dao.create(v);
		System.out.println(+result);
			
			
			
			if(result==1)
			{
				return SUCCESS;
			}
			else
			{
				return 	ERROR;
			}
	}
	
	public String service() throws Exception
	{
		String allied=request.getParameter("alliedservices");
		int id=0;
		int id1=0;
		String alliedid=null;
		String type=null;
		String r=null;
		if(allied.equals("--- Select Service ---"))
		{
			return ERROR;
			
		}
		else
		{
		if(allied.equals("Architects"))
		{
			alliedid="1";
			type="Arch";
			r="A";
			
		}
		else if(allied.equals("Vaastu Consultants"))
		{		
			type="VC";
			r="V";
			alliedid="2";
		}
		else if(allied.equals("Builders & Developers"))
		{
			type="BD";
			r="D";
			alliedid="3";
		}
		else if(allied.equals("Building Contractors"))
		{
			type="BC";
			r="B";
			alliedid="4";
		}
		else if(allied.equals("Building Materials"))
		{
			type="BM";
			r="M";
			alliedid="5";
		}
		
		else if(allied.equals("Civil Contractors"))
		{
			type="CC";
			r="Civil";
			alliedid="6";
		}
		else if(allied.equals("Demolition Contractor"))
		{
			type="DC";
			r="Dem";
			alliedid="7";
		}
		else if(allied.equals("Electrical Contractors"))
		{
			type="EC";
			r="Elec";
			alliedid="8";
		}
		else if(allied.equals("Ceiling Contractors"))
		{
			type="CeC";
			r="Ceil";
			alliedid="9";
		}
		else if(allied.equals("Plumbing Contractors"))
		{
			type="PlC";
			r="Plum";
			alliedid="10";
		}
		else if(allied.equals("Aluminium Fabricators"))
		{
			type="AlF";
			r="Alu";
			alliedid="11";
		}			
		else if(allied.equals("Landscape Contractors"))
		{
			type="LC";
			r="Land";
			alliedid="12";
		}

		else if(allied.equals("Masonry Contractors"))
		{
			type="MC";
			r="Mas";
			alliedid="13";
		}
		else if(allied.equals("Painting Contractor"))
		{
			type="PaC";
			r="Paint";
			alliedid="14";
		}
		else if(allied.equals("Pest Control Contractor"))
		{
			type="PCC";
			r="Pest";
			alliedid="15";
		}
		else if(allied.equals("Plastering Contractors"))
		{
			type="PlastC";
			r="PlaC";
			alliedid="16";
		}
		else if(allied.equals("Corpentary Work"))
		{
			type="CoW";
			r="Cor";
			alliedid="17";
		}
		else if(allied.equals("Borewells or  Diviners"))
		{
			type="BoD";
			r="Bore";
			alliedid="18";
		}
		else if(allied.equals("Soil Mechanics"))
		{
			type="SoM";
			r="Soil";
			alliedid="19";
		}
		else if(allied.equals("Environment Consultant"))
		{
			type="Env";
			r="EnC";
			alliedid="20";
		}
		
		else {}
		AlliedDao ad= DaoFactoryImpl.getInstance().architectdao();
		AlliedVO v=new AlliedVO();
		try {
			id=ad.generateid();
			id1=ad.generateid1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type=type+id1;
		r=r+id;
		System.out.println(type);
		System.out.println(r);
		v.setId(type);
		v.setAid(r);
		v.setCompany(request.getParameter("companyname"));
		System.out.println(request.getParameter("companyname"));
		System.out.println(request.getParameter(type));
		v.setUrl(request.getParameter("companywebsite"));
		v.setAddress1(request.getParameter("add1"));
		v.setAddress2(request.getParameter("add2"));
		v.setCity(request.getParameter("city"));
		v.setState(request.getParameter("state"));
		v.setContact(request.getParameter("number"));
		v.setCperson(request.getParameter("contactperson"));
		v.setEmailid(request.getParameter("emailid"));
		v.setAllied(alliedid);
		v.setCountry(request.getParameter("country"));
		String desc=request.getParameter("desc");
		if(desc.equals(""))
			v.setDesc("Not Mentioned");
		else
			v.setDesc(desc);
		int result=ad.create(v);
		if(result!=0)
		return SUCCESS;
		else
			return ERROR;
	}
	}
	
	public String loan() throws Exception
	{
				loanDao loandao= DaoFactoryImpl.getInstance().loanDao();
				String name=request.getParameter("name");
				String occupation=request.getParameter("occupation");
				String salary=request.getParameter("salary");
				String amount=request.getParameter("amount");
				String address1=request.getParameter("address1");
				String city=request.getParameter("city");
				String state=request.getParameter("state");
				String contact=request.getParameter("contact");
				String emailid=request.getParameter("emailid");
				String country=request.getParameter("country");
				loandaoimpl impl=new loandaoimpl();
				int id=impl.generateid();
				
					
					loanVO v=new loanVO();
					v.setAddress1(address1);
					v.setAmount(amount);
					v.setCity(city);
					v.setContact(contact);
					v.setEmailid(emailid);
					v.setName(name);
					v.setOccupation(occupation);
					v.setSalary(salary);
					v.setState(state);
					v.setCountry(country);
					v.setId(id);
					int result=loandao.create(v);
					if(result==1)
		return SUCCESS;
		else
		return INPUT;
	}
	public String career() throws Exception
	{
		loandaoimpl impl=new loandaoimpl();
		String loginid=request.getParameter("loginid");
		String password=request.getParameter("password");
		String filename=request.getParameter("filename");
		System.out.println(filename);
		loanVO v=new loanVO();
		v.setFile(filename);
		v.setLid(loginid);
		v.setPassword(password);
		int result=0;
		int result1=0;
		result=impl.check(loginid);
		if(result!=1)
		{
			result1=impl.career(v);
			System.out.println(result1);
			return SUCCESS;
		}
		else
			return SUCCESS;
		
	}
	public String investors() throws Exception
	{
		return 	SUCCESS;
	}
	public String companyinfo() throws Exception
	{
		return SUCCESS;
	}
	public String searchproject() throws Exception
	{
		
		Collection<ProjectVO> c=null;
		String location=request.getParameter("location");
		if(location.equals(null))
		{
			return ERROR;
		}
		else
		{
		c=pdao.search(location);
		session.setAttribute("project", c);
		return 	SUCCESS;
		}
	}
	public String searchbuilder() throws Exception
	{
		Collection<BuilderVO> c=null;
		String location=request.getParameter("location");
		if(location.equals(null))
			return ERROR;
		else
		{
		c=pdao.searchbuilder(location);
		session.setAttribute("builder",c);
		return SUCCESS;
		}
	}
	public String buil() throws Exception
	{
		Collection<BuilderVO> c=null;
		String id=request.getParameter("choice");
		System.out.println(id);
		BuilderVO v=new BuilderVO();
		v.setLoginid(id);
		if(id.equals(null))
			return ERROR;
		else
		{
		c=pdao.findById(v);
		session.setAttribute("builderdetail", c);
		return SUCCESS;
		}
	}
	public String updateproperty() throws Exception
	{
		String id=request.getParameter("propid");
		System.out.println(id);
		session.setAttribute("propertyid", id);
		return SUCCESS;
	}
	public String deleteproperty() throws Exception
	{
		String id=request.getParameter("propid");
		System.out.println(id);
		PropertyVO v=new PropertyVO();
		v.setId(id);
		dao.delete(v);
		return SUCCESS;
	}
	public String updateproperties() throws Exception
	{
		String id=request.getParameter("pid");
		PropertyVO v=new PropertyVO();
		System.out.println(id);
		String amenities=request.getParameter("amenities");
		String amenityid=null;
		String landmarkid="null";
		String landmark=null;
		String propertytypeid=null;
		String property=request.getParameter("Property Type");
		if(property.equals("Residential"))
			propertytypeid="1";
		else if(property.equals("Commercial"))
			propertytypeid="2";
		else if(property.equals("Agricultural"))
			propertytypeid="3";
		else if(property.equals("Industrial"))
			propertytypeid="4";
		else
		{}
		if(amenities.equals("Park"))
			amenityid="1";
		else if(amenities.equals("Gym"))
			amenityid="2";
		else if(amenities.equals("Swimming Pool"))
			amenityid="3";
		else if(amenities.equals("Car Parking"))
			amenityid="4";
		else if(amenities.equals("Swimming Pool+Park"))
			amenityid="5";
		else if(amenities.equals("Gym+Park"))
			amenityid="6";
		else if(amenities.equals("Swimming Pool+Gym"))
			amenityid="7";
		else if(amenities.equals("Car Parking+Park"))
			amenityid="8";
		else if(amenities.equals("Car Parking+Gym"))
			amenityid="9";
		else if(amenities.equals("Car Parking+Swimming Pool"))
			amenityid="10";
		else if(amenities.equals("Swimming Pool+Gym+Park"))
			amenityid="11";
		else if(amenities.equals("Car Parking+Gym+Park"))
			amenityid="12";
		else if(amenities.equals("Car Parking+Swimming Pool+Park"))
			amenityid="13";
		else if(amenities.equals("Car Parking+Swimming Pool+Park+Gym"))
			amenityid="14";
		System.out.println(amenityid);
		
		 landmark = request.getParameter("landmark");
		if(landmark.equals("School"))
			landmarkid="1";
		else if(landmark.equals("Hospital"))
			landmarkid="2";
		else if(landmark.equals("Railway Station"))
			landmarkid="3";
		else if(landmark.equals("Bus Stand"))
			landmarkid="4";
		else if(landmark.equals("School+Hospital"))
			landmarkid="5";
		else if(landmark.equals("School+Railway Station"))
			landmarkid="6";
		else if(landmark.equals("School+Bus Stand"))
			landmarkid="7";
		else if(landmark.equals("Hospital+Railway Station"))
			landmarkid="8";
		else if(landmark.equals("Hospital+Bus Stand"))
			landmarkid="9";
		else if(landmark.equals("Railway Station+Bus Stand"))
			landmarkid="10";
		else if(landmark.equals("School+Hospital+Railway Station"))
			landmarkid="11";
		else if(landmark.equals("School+Railway Station+Bus Stand"))
			landmarkid="12";
		else if(landmark.equals("School+Hospital+Bus Stand"))
			landmarkid="13";
		else if(landmarkid.equals("Hospital+Railway Station+Bus Stand"))
			landmarkid="14";
		else if(landmark.equals("School+Hospital+Railway Station+Bus Stand"))
			landmarkid="15";
		else
		{}
		
		v.setId(id);
		v.setAdd1(request.getParameter("add1"));
		v.setAdd2(request.getParameter("add2"));
		v.setAmenities(amenityid);
		v.setBedrooms(request.getParameter("noofbedrooms"));
		v.setCity(request.getParameter("city"));
		v.setContact(request.getParameter("contact"));
		v.setCostrange(request.getParameter("costrange"));
		v.setDesc(request.getParameter("desc"));
		v.setEmailid(request.getParameter("emailid"));
		v.setFurnishing(request.getParameter("furnished"));
		v.setLandmark(landmarkid);
		v.setName(request.getParameter("name"));
		v.setPlotno(request.getParameter("plotno"));
		v.setPropertyage(request.getParameter("propertyage"));
		v.setPropertyfor(request.getParameter("propertyfor"));
		v.setPropertytype(propertytypeid);
		v.setRooms(request.getParameter("noofrooms"));
		v.setSqft(request.getParameter("sqft"));
		v.setState(request.getParameter("state"));
		v.setCountry(request.getParameter("country"));
		v.setPosted("posted");
		System.out.println(landmarkid);
		System.out.println(amenityid);
		
		
		
		dao.update(v);
		
		return SUCCESS;
		
	}
	/*
	public String postedproperty() throws Exception
	{
		String landmark=null;
		String amenities=null;
		String furnishing=null;
		String string1=request.getParameter("landmark1");
		String string2=request.getParameter("landmark2");
		String string3=request.getParameter("landmark3");
		String string4=request.getParameter("landmark4");
		String string5=request.getParameter("Amenities1");
		String string6=request.getParameter("Amenities2");
		String string7=request.getParameter("Amenities3");
		String string8=request.getParameter("Amenities4");
		String string9=request.getParameter("furnishing");
		
		landmark=string1+"+"+string2+"+"+string3+"+"+string4;
		amenities=string5+"+"+string6+"+"+string7+"+"+string8;
		furnishing=string9;
		PropertyVO v=new PropertyVO();
		PropertyDao pd=DaoFactoryImpl.getInstance().PropertyDao();
		vo=new PropertyVO();
		int i=pd.generateid();
		System.out.println("id is :"+i);
		String prop="Prop";
		v.setId(prop+i);
			v.setAdd1(request.getParameter("add1"));
			v.setAdd2(request.getParameter("add2"));
			v.setAmenities(amenities);
			v.setBedrooms(request.getParameter("noofbedrooms"));
			v.setCity(request.getParameter("city"));
			v.setContact(request.getParameter("contact"));
			v.setCostrange(request.getParameter("costrange"));
			v.setDesc(request.getParameter("desc"));
			v.setEmailid(request.getParameter("emailid"));
			v.setFurnishing(furnishing);
			v.setImage(request.getParameter("postimage"));
			v.setLandmark(landmark);
			v.setName(request.getParameter("name"));
			v.setPlotno(request.getParameter("plotno"));
			v.setPropertyage(request.getParameter("propertyage"));
			v.setPropertyfor(request.getParameter("propertyfor"));
			v.setPropertytype(request.getParameter("Property Type"));
			v.setRooms(request.getParameter("noofrooms"));
			v.setSqft(request.getParameter("sqft"));
			v.setState(request.getParameter("state"));
			v.setPosted("posted");
			int result=pd.create(v);
			if(result==1)
			{
				return SUCCESS;
			}
			else
			{
				return 	ERROR;
			}
		
	}
	
	public String requirements() throws Exception
	{
		String landmark=null;
		String amenities=null;
		String furnishing=null;
		String string1=request.getParameter("landmark1");
		String string2=request.getParameter("landmark2");
		String string3=request.getParameter("landmark3");
		String string4=request.getParameter("landmark4");
		String string5=request.getParameter("Amenities1");
		String string6=request.getParameter("Amenities2");
		String string7=request.getParameter("Amenities3");
		String string8=request.getParameter("Amenities4");
		String string9=request.getParameter("furnishing");
		landmark=string1+"+"+string2+"+"+string3+"+"+string4;
		amenities=string5+"+"+string6+"+"+string7+"+"+string8;
		furnishing=string9;
		PropertyVO v=new PropertyVO();
		PropertyDao pd=DaoFactoryImpl.getInstance().PropertyDao();
		System.out.println("searchsearh!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@@@@@22");
	
			
			v.setAmenities(amenities);
			v.setBedrooms(request.getParameter("noofbedrooms"));
			v.setCity(request.getParameter("city"));
			v.setContact(request.getParameter("contact"));
			v.setCostrange(request.getParameter("costrange"));
			v.setDesc(request.getParameter("desc"));
			v.setEmailid(request.getParameter("emailid"));
			v.setFurnishing(furnishing);
			v.setLandmark(landmark);
			v.setName(request.getParameter("name"));
			v.setPropertyage(request.getParameter("propertyage"));
			v.setPropertyfor(request.getParameter("propertyfor"));
			v.setPropertytype(request.getParameter("Property Type"));
			v.setRooms(request.getParameter("noofrooms"));
			v.setSqft(request.getParameter("sqft"));
			v.setPosted("required");
			int result=pd.create(v);
			if(result==1)
			{
				return SUCCESS;
			}
			else
			{
				return ERROR;
			}
	}
	public String alliedservice() throws Exception
	{
		String allied=request.getParameter("alliedservices");
		int id=0;
		String type=null;
		if(allied.equals("--- Select Service ---"))
		{
			return ERROR;
		}
		else
		{
		if(allied.equals("Architects"))
		{
			type="Arch";
			
		}
		else if(allied.equals("Vaastu Consultants"))
		{
			type="VC";
		}
		else if(allied.equals("Builders & Developers"))
		{
			type="BD";
		}
		else if(allied.equals("Building Contractors"))
		{
			type="BC";
		}
		else if(allied.equals("Building Materials"))
		{
			type="BM";
		}
		else {}
		
		
		
		AlliedDao ad= DaoFactoryImpl.getInstance().architectdao();
		AlliedVO v=new AlliedVO();
		try {
			id=ad.generateid();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type=type+id;
		System.out.println(type);
		v.setId(type);
		v.setCompany(request.getParameter("companyname"));
		System.out.println(request.getParameter("companyname"));
		System.out.println(request.getParameter(type));
		v.setUrl(request.getParameter("companywebsite"));
		v.setAddress1(request.getParameter("add1"));
		v.setAddress2(request.getParameter("add2"));
		v.setCity(request.getParameter("city"));
		v.setState(request.getParameter("state"));
		v.setContact(request.getParameter("number"));
		v.setCperson(request.getParameter("contactperson"));
		v.setEmailid(request.getParameter("emailid"));
		v.setAllied(request.getParameter("alliedservices"));
		v.setCountry(request.getParameter("country"));
		v.setIimage(request.getParameter("serviceimage"));
		ad.create(v);
		
		return SUCCESS;
	}
	
	
}
	public String allied() throws Exception
	{
		return null;
		
	}
public String advancesearch() throws Exception
	{
		return null;
	}
	*/
//do here


	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		

}
}