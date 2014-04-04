package com.collaba.management.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector;
import com.collaba.management.vo.RegistrationVO;


	public class RegistrationUtil {
		
		 String url;
	     String driver;
	     String username;
	     String password;
	     String database;
	     String tablename ;
		
		
			private static Logger log = Logger.getLogger(RegistrationUtil.class.getName());
			public RegistrationUtil(){}
			
			
		
	public static String getUniqueId()
			
				throws java.sql.SQLException
			{
				
		String url = "jdbc:mysql://localhost:3306/";
	    String driver = "com.mysql.jdbc.Driver";
	    String Instmgt = "root";
	    String password = "root";
	    String database= "RealEstateMgmt";
	    String tablename = "Register";
		
	     ResultSet rst = null;
		
		
				
				String id = null;
				
				Statement stmtSelect = null;
				ResultSet rs = null;
				DBConnector db= null;
				StringBuffer sbSelect = new StringBuffer();
				sbSelect.append("SELECT ");
				sbSelect.append("max(loginid)");
				sbSelect.append(" FROM registration ");
				
				String query = sbSelect.toString();
				
				System.out.println(query);
				try
				{
				db =new DBConnector();
			     rst =  db.getResultSet(query, true);
	            
			     rst.next();
			     {
			     
			     System.out.println(rst);
			     String idval = rst.getString(1);
			     id=idval;
			     }  
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
			
			

			
			 public static Collection makeObjectsFromResultSet(final ResultSet rs)
				throws java.sql.SQLException
			{
				
				Vector result = new Vector();
				System.out.println("Something inside vector");
			
				
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				int cols = resultSetMetaData.getColumnCount();
				
				System.out.println("columns:" + ""+cols);
			
				
				while (rs.next())
				{
					RegistrationVO v = new RegistrationVO();
					v.setLoginid(rs.getString("loginid"));
					v.setName(rs.getString("name"));
					v.setPassword(rs.getString("pword"));
					v.setAddress(rs.getString("address"));
					v.setEmail(rs.getString("email"));
					v.setContactnumber(rs.getString("contactno"));
					v.setCity(rs.getString("city"));
					v.setState(rs.getString("state"));
					v.setCountry(rs.getString("country"));
					v.setUsertype(rs.getString("usertype"));
					
					result.add(v); 	
				}
				
				return (Collection)result;
			}
			 
			 
		
			
		public static void printInstmgmtInfo(Collection v)	{
			
			Iterator iter = v.iterator();
			
			while(iter.hasNext())
				
			{
				RegistrationVO t =(RegistrationVO)iter.next();
				
								
			}	
			
			
		}


	public static void main(String[] args) {
		
		try 
		{
		String value = RegistrationUtil.getUniqueId();
		System.out.println(value);
		String url = "jdbc:mysql://localhost:3306/";
	    String driver = "com.mysql.jdbc.Driver";
	    String username = "root";
	    String password = "destiny";
	    String database= "RealEstateMgmt";
	    String tablename = "registration";
		DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
		
		
		ResultSet rs = db.getResultSet("select * from Register", true);
		
		Collection v = makeObjectsFromResultSet(rs);
		
		
		String id =  RegistrationUtil.getUniqueId();
		
		System.out.println(" Iam here new ID" + id);
		

		
		}
		
		catch(Exception ex){}
	}

			
					
		}









