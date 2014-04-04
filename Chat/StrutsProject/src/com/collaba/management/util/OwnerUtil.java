package com.collaba.management.util;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector;
import com.collaba.management.vo.OwnerVO;


public class OwnerUtil 
{
	String url=null;
    String driver=null;
    String username=null;
    String password=null;
    String database=null;
    String table=null;
	
	
		private static Logger log = Logger.getLogger(OwnerUtil.class.getName());
		
		
		public   OwnerUtil(){ 	}
		
		
	
		
public static String getUniqueId()
		
			throws java.sql.SQLException
		{
			
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String user = "root";
   String password = "destiny";
   String database= "RealEstateMgmt";
   String tablename = "owner";
	
    ResultSet rst = null;
	
	
			
			String id = null;
			String idval=null;
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT ");
			sbSelect.append("max(O_Id) ");
			sbSelect.append(" FROM owner ");
			
			String query = sbSelect.toString();
			
			System.out.println(query);
			try
			{
			DBConnector db=new DBConnector(database, tablename, driver, url, user, password);
		     rst =  db.getResultSet(query, true);
             rst.next();
             {
            	 System.out.println(rst);
                 idval = rst.getString(1);
             }
                 id =idval;
		     db.disconnect();
			}
			
			catch(Exception ex)
			{
				
			}	
			
		     System.out.println(id);
		    
		
			return id;
		}
		
		

		
		 public static Collection makeObjectsFromResultSet(final ResultSet rs)
			throws java.sql.SQLException, ClassNotFoundException
		{
			 String url = "jdbc:mysql://localhost:3306/";
			   String driver = "com.mysql.jdbc.Driver";
			   String user = "root";
			   String password = "destiny";
			   String database= "RealEstateMgmt";
			   String tablename = "owner";
				
			
				Vector result = new Vector();
				DBConnector db=new  DBConnector(database, tablename, driver, url, user, password);
			   ResultSetMetaData resultSetMetaData = rs.getMetaData();
			   int cols = resultSetMetaData.getColumnCount();
			
			System.out.println("columns:" + ""+cols);
		
			while (rs.next())
			{
				
				OwnerVO o=new OwnerVO();
				o.setId(rs.getString("O_Id"));
				o.setAddress(rs.getString("O_Name"));
				o.setCity(rs.getString("O_City"));
				o.setContactno(rs.getString("O_Contactno"));
				o.setState(rs.getString("O_State"));
				o.setAddress(rs.getString("O_Address"));
				result.add(o);
			}
			
			db.disconnect();
			
		    
		
			return (Collection)result;
		 
		 
		}
		
	public static void printPropertymgmtInfo(Collection v)	{
		
		Iterator iter = v.iterator();
		
		while(iter.hasNext())
			
		{
			OwnerVO t =(OwnerVO)iter.next();
			
							
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
   String tablename = "owner";
	DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
	
	
	ResultSet rs = db.getResultSet("select * from owner", true);
	Collection v = makeObjectsFromResultSet(rs);
	
	
	String id =  OwnerUtil.getUniqueId();
	System.out.println(" Iam here new ID" + id);
	}
	
	catch(Exception ex){}
}
}