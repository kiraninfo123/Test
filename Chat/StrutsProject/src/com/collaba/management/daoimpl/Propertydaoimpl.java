
package com.collaba.management.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import com.collaba.management.dao.PropertyDao;
import com.collaba.management.db.DBConnector;
import com.collaba.management.exception.BuilderNotFoundException;
import com.collaba.management.exception.PropertyNotFoundException;
import com.collaba.management.util.PropertytypeUtil;
import com.collaba.management.vo.BuilderVO;
import com.collaba.management.vo.PropertyVO;
import com.collaba.management.vo.PropertytypeVO;

public class Propertydaoimpl implements  PropertyDao {
	
	
	
    ResultSet rst = null;
    DBConnector db = null;
    PreparedStatement stat=null;
    Connection conn=null;
    int result=0;
//	private static Logger log = Logger.getLogger(PropertyUtil.class.getName());
	
	
	public Propertydaoimpl()
	{
		System.out.println("Dao implementation");
	}
	public int create(PropertyVO v) throws PropertyNotFoundException
	{
			
		    DBConnector db = null;
		    PreparedStatement stat=null;
		    Connection conn=null;
		    String amenityid = null,landmarkid=null;
		    
		    
		int i=0;
		try
		{
			db=new DBConnector();
			conn=db.getConnection();
			
			String query="insert into property values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			stat=conn.prepareStatement(query);
			
			stat.setString(1, v.getId());
			stat.setString(2, v.getCity());
			stat.setString(3,v.getPropertyage());
			stat.setString(4,v.getSqft());
			stat.setString(5,v.getPropertytype());
			stat.setString(6,v.getPropertyfor());
			stat.setString(7,v.getBedrooms());
			stat.setString(8,v.getRooms());
			stat.setString(9,v.getCostrange());
			stat.setString(10,v.getState());
			stat.setString(11,v.getCountry());
			stat.setString(12,v.getLandmark());
			stat.setString(13,v.getFurnishing());
			stat.setString(14,v.getAmenities());
			stat.setString(15,v.getPlotno());
			stat.setString(16,v.getAdd1());
			stat.setString(17,v.getName());
			stat.setString(18,v.getEmailid());
			stat.setString(19,v.getContact());
			stat.setString(20,v.getDesc());
			stat.setString(21,v.getAdd2());
			stat.setString(22,v.getPosted());
			
			System.out.println("21ssssssssssssooooooooooooo");
			System.out.println("21ssssssssssssooooooooooooo");
			i=stat.executeUpdate();
			System.out.println("2ssssssssssssooooooooooooo");
			System.out.println("Something "+i);
			System.out.println(amenityid);
			System.out.println(landmarkid);
			
		}
		catch(Exception e){e.printStackTrace();System.out.println("Error something hhhhhhhhhhhhhhhhhhhhhhhhh");}
		finally
		{
			try{
				db.disconnect();
			}catch(Exception e){e.printStackTrace();System.out.println("Error something find  hhhhhhhhhhhhhhhhhhhhhhhhh");}
		}
		return i;
		}
	
	public Collection<PropertyVO> find(PropertyVO v) throws PropertyNotFoundException
	{
		String query=null;
		StringBuffer string=new StringBuffer();
		string.append("select propid,location,age,area,proptype,propfor,bedrooms,rooms,price,state,country,landmarkid,furnished,amenities,plotno,propaddress,name,emailid,contactnumber,description,personaddress");
		string.append("  from property where location='");
		string.append(v.getCity());
		string.append("' or proptype='");
		string.append(v.getPropertytype());
		string.append("' or propfor='");
		string.append(v.getPropertyfor());
		string.append("' and posted='posted'");
		query=string.toString();
		System.out.println(query);
		
		System.out.println(query);
		Collection<PropertyVO>  c = PerformDBQuery(query);

			return c;
	}
	
	public Collection<PropertyVO> PerformDBQuery(String query) {
		
		 Collection<PropertyVO> c = null;
		 DBConnector db = null;
		try {
			 db = new DBConnector();
			}
			
			catch(ClassNotFoundException eq) { eq.printStackTrace(); }
			catch(SQLException eq) { eq.printStackTrace(); }		
		
		try
		{
				
		  ResultSet  rs = db.getResultSet(query, true);
		  System.out.println(query);
    	   c = PropertytypeUtil.makeObjectsFromResultSet(rs);
    	   System.out.println("ssssssssssssssseoooooooooooooooooooooooo");
		    
		}
	
  catch(Exception exw) {exw.printStackTrace();}
       
      finally
      {
			  try
		     	{
			
			     db.disconnect();
			
			   }
			   catch(Exception ed){ed.printStackTrace();}
		 }

		
		return c;
	}
		
	
	public void delete(PropertyVO v) throws PropertyNotFoundException {
		DBConnector db=null;
		Connection connection=null;
		PreparedStatement stat=null;
		try
		{
			String query="delete from property where propid='"+v.getId()+"'";
			db=new DBConnector();
			connection=db.getConnection();
			stat=connection.prepareStatement(query);
			int i=stat.executeUpdate();
			System.out.println(+i);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				db.disconnect();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() throws PropertyNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	public void update(PropertyVO v) throws PropertyNotFoundException {
		
		StringBuilder string=new StringBuilder();
		string.append("update property set propid='");
		string.append(v.getId());
		string.append("',location='");
		string.append( v.getCity());
		string.append("',age='");
		string.append(v.getPropertyage());
		string.append("',area='");
		string.append(v.getSqft());
		string.append("',proptype='");
		string.append(v.getPropertytype());
		string.append("',propfor='");
		string.append(v.getPropertyfor());
		string.append("',bedrooms='");
		string.append(v.getBedrooms());
		string.append("',rooms='");
		string.append(v.getRooms());
		string.append("',price='");
		string.append(v.getCostrange());
		string.append("',state='");
		string.append(v.getState());
		string.append("',country='");
		string.append(v.getCountry());
		string.append("',landmarkid='");
		string.append(v.getLandmark());
		string.append("',furnished='");
		string.append(v.getFurnishing());
		string.append("',amenities='");
		string.append(v.getAmenities());
		string.append("',plotno='");
		string.append(v.getPlotno());
		string.append("',propaddress='");
		string.append(v.getAdd1());
		string.append("',name='");
		string.append(v.getName());
		string.append("',emailid='");
		string.append(v.getEmailid());
		string.append("',contactnumber='");
		string.append(v.getContact());
		string.append("',description='");
		string.append(v.getDesc());
		string.append("',personaddress='");
		string.append(v.getAdd2());
		string.append("',posted='");
		string.append(v.getPosted());
		string.append("' where propid='");
		string.append(v.getId());
		string.append("'");
		
		String query=string.toString();
		System.out.println(query);
		int i=0;
		Connection connection=null;
		PreparedStatement stat=null;
		DBConnector db=null;
		try
		{
			db=new DBConnector();
			connection=db.getConnection();
			stat=connection.prepareStatement(query);
			i=stat.executeUpdate();
			System.out.println(+i);
		}
		catch(Exception e){e.printStackTrace();}
		finally
		{
			try
			{
				db.disconnect();
			}catch(Exception e){e.printStackTrace();}
		}
		
		System.out.println("21ssssssssssssooooooooooooo");
		System.out.println("21ssssssssssssooooooooooooo");
		System.out.println("2ssssssssssssooooooooooooo");
		System.out.println("Something "+i);
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public Collection<PropertyVO> findAll() throws PropertyNotFoundException,
			Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int check(PropertyVO v)
	{
		ResultSet rst = null;
	    DBConnector db = null;
	    PreparedStatement stat=null;
	    Connection conn=null;
	    boolean flag1=false;
		boolean flag2=false;
		boolean flag3=false;
		boolean flag4=false;
		boolean flag5=false;
		boolean flag6=false;
		boolean flag7=false;
		boolean flag8=false;
		boolean flag9=false;
		boolean flag10=false;
		boolean flag11=false;
		int result=0;
	    int i=0;
	try
	{
		db=new DBConnector();
		conn=db.getConnection();
		
		String query="select location'="+v.getCity()+"',prop_type='"+v.getPropertytype()+"',cost='"+v.getCostrange()+"',area='"+v.getSqft()+"',age='"+v.getPropertyage()+"',rooms='"+v.getRooms()+"',bedrooms='"+v.getBedrooms()+"',furnishing='"+v.getFurnishing()+"',amenities='"+v.getAmenities()+"',landmark='"+v.getLandmark()+"',prop_for='"
						+v.getPropertyfor()+"' from property";
		System.out.println(query);
		stat=conn.prepareStatement(query);
		rst=stat.executeQuery();
		while(rst.next())
		{
			flag1=rst.getBoolean(1);flag2=rst.getBoolean(2);flag3=rst.getBoolean(3);flag4=rst.getBoolean(4);flag5=rst.getBoolean(5);
			flag6=rst.getBoolean(6);flag7=rst.getBoolean(7);flag8=rst.getBoolean(8);flag9=rst.getBoolean(9);flag10=rst.getBoolean(10);
			flag11=rst.getBoolean(11);
			i=rst.getRow();
			if(flag1==true&&flag2==true&&flag3==true&&flag4==true&&flag5==true&&flag6==true&&flag7==true&&flag8==true&&flag9==true&&flag10==true&&flag11==true)
			{
				result=i;
				break;
			}
			else
			{
				result=0;
			}
			
		}
		
		
	}catch(Exception e){}
	finally
	{
		try{db.disconnect();
	}catch(Exception e){}
		
	}
	System.out.println("rows are :"+i);
	return result;
	
	}
	public int generateid()
	{
		ResultSet rst = null;
	    DBConnector db = null;
	    PreparedStatement stat=null;
	    Connection conn=null;
	    int i=0;
	try
	{
		db=new DBConnector();
		conn=db.getConnection();
		
		String query="select *from property";
		stat=conn.prepareStatement(query);
		rst=stat.executeQuery();
		while(rst.next())
		{
			i=rst.getRow();
		}
		
		
	}catch(Exception e){}
	finally
	{
		try{db.disconnect();
	}catch(Exception e){}
		
	}
	System.out.println("rows are :"+i);
	return i;
	
	}
	public Collection<PropertyVO> search(PropertyVO v)
			throws PropertyNotFoundException {
				
		String query=null;		
		StringBuffer string=new StringBuffer();
		string.append("select propid,location,age,area,proptype,propfor,bedrooms,rooms,price,state,country,landmarkid,furnished,amenities,plotno,propaddress,name,emailid,contactnumber,description,personaddress");
		string.append("  from property where location='");
		string.append(v.getCity());
		string.append("' and  proptype='");
		string.append(v.getPropertytype());
		string.append("' and propfor='");
		string.append(v.getPropertyfor());
		string.append("' and bedrooms='");
		string.append(v.getBedrooms());
		string.append("' or rooms='");
		string.append(v.getRooms());
		string.append("' and area='");
		string.append(v.getSqft());
		string.append("' and price='");
		string.append(v.getCostrange());
		string.append("' and landmarkid='");
		string.append(v.getLandmark());
		string.append("' and furnished='");
		string.append(v.getFurnishing());
		string.append("' and amenities='");
		string.append(v.getAmenities());
		string.append("' and posted='posted'");		
		query=string.toString();		
				
				System.out.println(query);
				Collection<PropertyVO>  c = PerformDBQuery(query);

					return c;
			}

	public Collection<PropertyVO> findById(String id)
			throws PropertyNotFoundException {
		String query;
	 	int id1 = 0;
	    Collection<PropertyVO> c=null;
	    query="select *from property where id='"+id1+"'";
		System.out.println(query);
	    c = PerformDBQuery(query);
	    System.out.print("find Success");
		Iterator iter =  c.iterator();
		System.out.print("find Success");
		PropertyVO result = (PropertyVO)iter.next();
		System.out.print("find Success");
		return c;
	}
}
	
	
	