package com.collaba.management.util;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector; 
import com.collaba.management.vo.AlliedVO;

public class AlliedUtil 
{
	String url;
    String driver;
    String username;
    String password;
    String database;
    String tablename ;
	
	
		private static Logger log = Logger.getLogger(AlliedUtil.class.getName());
		
		
		public   AlliedUtil(){ 	}
		
		
	
		


		
		 public static Collection<AlliedVO> makeObjectsFromResultSet(final ResultSet rs)
			throws java.sql.SQLException
		{
			
			Vector<AlliedVO> result = new Vector<AlliedVO>();
		
			
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			int cols = resultSetMetaData.getColumnCount();
			
			System.out.println("columns:" + ""+cols);
			AlliedVO v=null;
			while (rs.next())
			{
				System.out.println("error");
				v=new AlliedVO();
				v.setCompany(rs.getString(1));
				v.setUrl(rs.getString(2));
				v.setAddress1(rs.getString(3));
				v.setDesc(rs.getString(4));
				v.setAid(rs.getString(5));
				v.setCperson(rs.getString(6));
				v.setId(rs.getString(7));
				v.setContact(rs.getString(8));
				v.setEmailid(rs.getString(9));
				v.setAddress2(rs.getString(10));
				v.setCity(rs.getString(11));
				v.setState(rs.getString(12));
				v.setCountry(rs.getString(13));
				
				
				result.add(v);	
			}
			return (Collection<AlliedVO>)result;
		}
			public static Collection<AlliedVO> makeObjectsFromResultSet1(final ResultSet rs)
					throws java.sql.SQLException
				{
					
					Vector<AlliedVO> result = new Vector<AlliedVO>();
				
					
					ResultSetMetaData resultSetMetaData = rs.getMetaData();
					int cols = resultSetMetaData.getColumnCount();
					
					System.out.println("columns:" + ""+cols);
					AlliedVO v=null;
					while (rs.next())
					{
						System.out.println("error");
						v=new AlliedVO();
						v.setCompany(rs.getString(1));
						v.setCperson(rs.getString(2));
						v.setAid(rs.getString(3));
						v.setContact(rs.getString(4));
						v.setId(rs.getString(5));
						
						
						result.add(v);	
					}
			
			
			return (Collection<AlliedVO>)result;
		}
		 
		 
	
		
	public static void printPropertymgmtInfo(Collection v)	{
		
		Iterator iter = v.iterator();
			}


public static void main(String[] args) {
	
	try 
	{
	int value = PropertytypeUtil.getUniqueId();
	System.out.println(value);
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String username = "root";
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "builder";
	DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
	
	
	ResultSet rs = db.getResultSet("select * from builder", true);
	Collection v = makeObjectsFromResultSet(rs);
	
	
	
	}
	
	catch(Exception ex){}
}
}