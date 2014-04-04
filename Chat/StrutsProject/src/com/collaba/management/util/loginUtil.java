package com.collaba.management.util;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector;
import com.collaba.management.vo.loginVO;


public class loginUtil 
{
	String url;
    String driver;
    String username;
    String password;
    String database;
    String tablename ;
	
	
		private static Logger log = Logger.getLogger(loginUtil.class.getName());
		
		
		public   loginUtil(){ 	}
		
		
	
		
public static String getUniqueId()
		
			throws java.sql.SQLException
		{
			
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String Instmgt = "root";
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "Login";
	
    ResultSet rst = null;
	
	
			
			String id = null;
			
			Statement stmtSelect = null;
			ResultSet rs = null;
			DBConnector db= null;
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT ");
			sbSelect.append(" max(logid) ");
			sbSelect.append(",");
			sbSelect.append("name");
			sbSelect.append(",");
			sbSelect.append("psword");
			sbSelect.append(" FROM login ");
			
			String query = sbSelect.toString();
			
			System.out.println(query);
			try
			{
			db =new DBConnector();
		     rst =  db.getResultSet(query, true);
           
		     rst.next();
		     
		     System.out.println(rst);
		     
		     
		     
		     String idval = rst.getString(1);
		     id =idval;
		     
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
				
				loginVO o=new loginVO();
				o.setLoginid(rs.getString("logid"));
				o.setPassword(rs.getString("psword"));
				o.setName(rs.getString("name"));
				result.add(o);
			
	
			}
			
			return (Collection)result;
		}
		 
		 
	
		
	public static void printPropertymgmtInfo(Collection v)	{
		
		Iterator iter = v.iterator();
		
		while(iter.hasNext())
			
		{
			loginVO t =(loginVO)iter.next();
		
							
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
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "login";
	DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
	
	
	ResultSet rs = db.getResultSet("select * from login", true);
	Collection v = makeObjectsFromResultSet(rs);
	
	
	String id =  OwnerUtil.getUniqueId();
	System.out.println(" Iam here new ID" + id);
	}
	
	catch(Exception ex){}
}
}