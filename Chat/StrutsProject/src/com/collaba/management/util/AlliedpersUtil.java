package com.collaba.management.util;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector;
import com.collaba.management.vo.AlliedservicesVO;

public class AlliedpersUtil 
{
	String url;
    String driver;
    String username;
    String password;
    String database;
    String tablename ;
	
	
		private static Logger log = Logger.getLogger(AlliedpersUtil.class.getName());
		
		
		public   AlliedpersUtil(){ 	}
		
		
	
		
public static String getUniqueId()
		
			throws java.sql.SQLException
		{
			
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String Instmgt = "root";
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "allied_ser";
	
    ResultSet rst = null;
	
			String id = null;	
			Statement stmtSelect = null;
			ResultSet rs = null;
			DBConnector db= null;
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT ");
			sbSelect.append("max(A_S_Id)");
			sbSelect.append(" FROM ");
			sbSelect.append(" allied_ser ");
			
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
				
				AlliedservicesVO v = new AlliedservicesVO();
				v.setId(rs.getString(" A_S_Id "));
				v.setName(rs.getString(" A_S_Name "));
				v.setDesc(rs.getString(" A_S_Desc "));
				result.add(v); 	
			}
			
			return (Collection)result;
		}
		 
		 
	
		
	public static void printPropertymgmtInfo(Collection v)	{
		
		Iterator iter = v.iterator();
		
		while(iter.hasNext())
			
		{
			AlliedservicesVO t =(AlliedservicesVO)iter.next();
			
							
		}	
		
		
	}


public static void main(String[] args) {
	
	try 
	{
	String value = AlliedpersUtil.getUniqueId();
	System.out.println(value);
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String username = "root";
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "allied_ser";
	DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
	
	
	ResultSet rs = db.getResultSet("select * from allied_ser", true);
	Collection v = makeObjectsFromResultSet(rs);
	
	
	String id =  AlliedpersUtil.getUniqueId();
	
	System.out.println(" Iam here new ID" + id);
	

	
	}
	
	catch(Exception ex){}
}
}