package com.collaba.management.util;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Logger;

import com.collaba.management.db.DBConnector;
import com.collaba.management.vo.BuilderVO;
import com.collaba.management.vo.ProjectVO;

public class ProjectUtil 
{
	String url;
    String driver;
    String username;
    String password;
    String database;
    String tablename ;
	
	
		private static Logger log = Logger.getLogger(ProjectUtil.class.getName());
		
		
		public   ProjectUtil(){ 	}
		
		
	
		
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
		
		

		
		 public static Collection<ProjectVO> makeObjectsFromResultSet(final ResultSet rs)
			throws java.sql.SQLException
		{
			
			Vector<ProjectVO> result = new Vector<ProjectVO>();
		
			
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			int cols = resultSetMetaData.getColumnCount();
			
			System.out.println("columns:" + ""+cols);
		
			while (rs.next())
			{
				
				ProjectVO v = new ProjectVO();
				v.setId(rs.getString(1)); 	
				v.setName(rs.getString(2));
				v.setLocation(rs.getString(3));
				v.setBuilderid(rs.getString(4));
				v.setProjecttype(rs.getString(5));
				v.setCost(rs.getString(6));
				result.add(v); 	
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
			
			return (Collection<ProjectVO>)result;
		}
		 public static Collection<BuilderVO> makeObjectsFromResultSet1(final ResultSet rs)
					throws java.sql.SQLException
				{
					
					Vector<BuilderVO> result = new Vector<BuilderVO>();
				
					
					ResultSetMetaData resultSetMetaData = rs.getMetaData();
					int cols = resultSetMetaData.getColumnCount();
					
					System.out.println("columns:" + ""+cols);
				
					while (rs.next())
					{
						
						BuilderVO v=new BuilderVO();
						v.setLoginid(rs.getString(1));
						v.setName(rs.getString(2));
						v.setPassword(rs.getString(3));
						v.setContactnumber(rs.getString(4));
						v.setAddress(rs.getString(5));
						v.setEmail(rs.getString(6));
						v.setCity(rs.getString(7));
						v.setState(rs.getString(8));
						v.setCountry(rs.getString(9));
						result.add(v); 	
					}
					
					return (Collection<BuilderVO>)result;
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
	int value = ProjectUtil.getUniqueId();
	System.out.println(value);
	String url = "jdbc:mysql://localhost:3306/";
   String driver = "com.mysql.jdbc.Driver";
   String username = "root";
   String password = "root";
   String database= "RealEstateMgmt";
   String tablename = "PropertyType";
	DBConnector db = new DBConnector( database, tablename, driver, url,username,password);
	
	
	ResultSet rs = db.getResultSet("select * from project", true);
	Collection v = makeObjectsFromResultSet(rs);
	
	
	System.out.println(" Iam here new ID" + value);
	

	
	}
	
	catch(Exception ex){}
}
}