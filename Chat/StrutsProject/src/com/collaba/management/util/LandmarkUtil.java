package com.collaba.management.util;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector;
import com.collaba.management.vo.LandmarkVO;

public class LandmarkUtil 
{
	String url;
    String driver;
    String username;
    String password;
    String database;
    String tablename ;
	
	
		private static Logger log = Logger.getLogger(LandmarkUtil.class.getName());
		
		
		public   LandmarkUtil(){ 	}
		
		
	
		
public static int getUniqueId()
		
			throws java.sql.SQLException
		{
			
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String Instmgt = "root";
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "Landmark";
	
    ResultSet rst = null;
	
	
			
			int id = 0;
			
			Statement stmtSelect = null;
			ResultSet rs = null;
			DBConnector db= null;
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT ");
			sbSelect.append(" max(id) ");
			sbSelect.append(" FROM Landmark  ");
			
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
				
				LandmarkVO v = new LandmarkVO();
				v.setL_ID(rs.getInt("id")); 	
				v.setL_Name(rs.getString("name"));
				result.add(v); 	
			}
			
			return (Collection)result;
		}
		 
		 
	
		
	public static void printPropertymgmtInfo(Collection v)	{
		
		Iterator iter = v.iterator();
		
		while(iter.hasNext())
			
		{
			LandmarkVO t =(LandmarkVO)iter.next();
			
							
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
   String tablename = "Landmark";
	DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
	
	
	ResultSet rs = db.getResultSet("select * from Landmark", true);
	Collection v = makeObjectsFromResultSet(rs);
	
	
	int id =  LandmarkUtil.getUniqueId();
	
	System.out.println(" Iam here new ID" + id);
	

	
	}
	
	catch(Exception ex){}
}
}
