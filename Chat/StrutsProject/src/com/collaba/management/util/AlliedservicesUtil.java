package com.collaba.management.util;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector;
import com.collaba.management.vo.ProjectVO;

public class AlliedservicesUtil
{
	String url;
    String driver;
    String username;
    String password;
    String database;
    String tablename ;
	
	
		private static Logger log = Logger.getLogger(AlliedservicesUtil.class.getName());
		
		
		public   AlliedservicesUtil(){ 	}
		
		
	
		
public static int getUniqueId()
		
			throws java.sql.SQLException
		{
			
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String Instmgt = "root";
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "propertytype";
	
    ResultSet rst = null;
	
	
			
			int id = 0;
			
			Statement stmtSelect = null;
			ResultSet rs = null;
			DBConnector db= null;
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT ");
			sbSelect.append("max(id)");
			sbSelect.append(" FROM project ");
			
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
		
		

		
		 public static Collection makeObjectsFromResultSet(final ResultSet rs)
			throws java.sql.SQLException
		{
			
			Vector result = new Vector();
		
			
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			int cols = resultSetMetaData.getColumnCount();
			
			System.out.println("columns:" + ""+cols);
		
			while (rs.next())
			{
				
				ProjectVO v = new ProjectVO();
				v.setId(rs.getString("id")); 	
				v.setName(rs.getString("name"));
				result.add(v); 	
			}
			
			return (Collection)result;
		}
		 
		 
	
		
	public static void printPropertymgmtInfo(Collection v)	{
		
		Iterator iter = v.iterator();
		
		while(iter.hasNext())
			
		{
			ProjectVO t =(ProjectVO)iter.next();
			
							
		}	
		
		
	}


public static void main(String[] args) {
	
	try 
	{

	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String username = "root";
   String password = "root";
   String database= "RealEstateMgmt";
   String tablename = "Alliedservices";
	DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
	
	
	ResultSet rs = db.getResultSet("select * from Alliedservices", true);
	Collection v = makeObjectsFromResultSet(rs);
	
	
	System.out.println(" Iam here new ID" + getUniqueId());
	

	
	}
	
	catch(Exception ex){}
}
}