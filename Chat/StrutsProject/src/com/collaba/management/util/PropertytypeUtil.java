package com.collaba.management.util;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector;
import com.collaba.management.vo.PropertyVO;
import com.collaba.management.vo.PropertytypeVO;

public class PropertytypeUtil 
{
	String url;
    String driver;
    String username;
    String password;
    String database;
    String tablename ;
	
	
		private static Logger log = Logger.getLogger(PropertytypeUtil.class.getName());
		
		
		public   PropertytypeUtil(){ 	}
		
		
	
		
public static int getUniqueId()
		
			throws java.sql.SQLException
		{
			
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String Instmgt = "root";
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "property";
	
    ResultSet rst = null;
	
	
			
			int id = 0;
			
			Statement stmtSelect = null;
			ResultSet rs = null;
			DBConnector db= null;
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT ");
			sbSelect.append("max(id)");
			sbSelect.append(" FROM propertytype ");
			
			String query = sbSelect.toString();
			
			System.out.println(query);
			try
			{
			db =new DBConnector();
		     rst =  db.getResultSet(query, true);
           
		     rst.next();
		     
		     System.out.println(rst);
		     
		     
		     
		     int idval = rst.getInt(1);
		     idval = idval+1;
		     id =+idval;
		     
			}
			
			catch(Exception ex)
			{
				
			}	
				
			finally
			{
				db.disconnect();
			}
		    
		     System.out.println(id);
		    
		
			return id;
		}
		
		

		
		 public static Collection<PropertyVO> makeObjectsFromResultSet(final ResultSet rs)
			throws java.sql.SQLException
		{
			
			Vector result = new Vector();
			
			
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			int cols = resultSetMetaData.getColumnCount();
			
			System.out.println("columns:" + ""+cols);
			String landmarkname=null;
			String amenityname=null;
			
			while (rs.next())
			{
				PropertyVO v=new PropertyVO();
				v.setId(rs.getString(1));
				System.out.println(rs.getString(1));
				v.setCity(rs.getString(2));
				System.out.println(rs.getString(2));
				v.setPropertyage(rs.getString(3));
				System.out.println(rs.getString(3));
				v.setSqft(rs.getString(4));
				System.out.println(rs.getString(4));
				v.setPropertytype(rs.getString(5));
				v.setPropertyfor(rs.getString(6));
				v.setBedrooms(rs.getString(7));
				v.setRooms(rs.getString(8));
				v.setCostrange(rs.getString(9));
				v.setState(rs.getString(10));
				v.setCountry(rs.getString(11));
				v.setLandmark(rs.getString(12));
				v.setFurnishing(rs.getString(13));
				v.setAmenities(rs.getString(14));
				v.setPlotno(rs.getString(15));
				v.setAdd1(rs.getString(16));
				v.setName(rs.getString(17));
				v.setEmailid(rs.getString(18));
				v.setContact(rs.getString(19));
				System.out.println(rs.getString(19));
				v.setDesc(rs.getString(20));
				System.out.println(rs.getString(20));
				v.setAdd2(rs.getString(21));
				System.out.println(rs.getString(21));
				result.add(v);
					
		    	}
			System.out.println("Try to returning");
			return (Collection)result;
		}
		 
		 
	
		
	public static void printPropertymgmtInfo(Collection v)	{
		
		Iterator iter = v.iterator();
		
		while(iter.hasNext())
			
		{
			PropertytypeVO t =(PropertytypeVO)iter.next();
			
							
		}	
		
		
	}


public static void main(String[] args) {
	
	try 
	{
	int value = PropertytypeUtil.getUniqueId();
	System.out.println(value);
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String username = "root";
   String password = "root";
   String database= "RealEstateMgmt";
   String tablename = "PropertyType";
	DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
	
	
	ResultSet rs = db.getResultSet("select * from PropertyType", true);
	Collection v = makeObjectsFromResultSet(rs);
	
	
	int id =  PropertytypeUtil.getUniqueId();
	
	System.out.println(" Iam here new ID" + id);
	

	
	}
	
	catch(Exception ex){}
}
}