package com.collaba.management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.io.*;
import com.collaba.management.db.DBConnector;
import com.collaba.management.util.AlliedUtil;
import com.collaba.management.vo.AlliedVO;
import com.collaba.management.dao.AlliedDao;
import com.collaba.management.exception.AlliedServicesNotFoundException;

import java.sql.*;

public class AlliedDaoImpl implements AlliedDao
{
	int result=0;
	boolean falg1=false;
	boolean flag2=false;
	
	
	public Collection<AlliedVO> findAll(String name)throws AlliedServicesNotFoundException
	{
		
		
		StringBuffer string= new StringBuffer();
		string.append("select company,name,aid,contact,id from alliedperson  where asid='");
		string.append(name);
		
		string.append("'");

		System.out.println(string.toString());
		Collection<AlliedVO>  c = PerformDBQuery1(string.toString());
		
		return c;
		
	}
	public Collection<AlliedVO> PerformDBQuery(String query) {
		
		Collection<AlliedVO> c = null;
		 DBConnector db = null;
		try {
			 db = new DBConnector();
			 
			}
			
			catch(ClassNotFoundException eq) { eq.printStackTrace(); }
			catch(SQLException eq) { eq.printStackTrace(); }		
		
		try
		{
				
		  ResultSet  rs = db.getResultSet(query, true);
    	   c = AlliedUtil.makeObjectsFromResultSet(rs);
		    
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
	public Collection<AlliedVO> PerformDBQuery1(String query) {
		
		Collection<AlliedVO> c = null;
		 DBConnector db = null;
		try {
			 db = new DBConnector();
			 
			}
			
			catch(ClassNotFoundException eq) { eq.printStackTrace(); }
			catch(SQLException eq) { eq.printStackTrace(); }		
		
		try
		{
				
		  ResultSet  rs = db.getResultSet(query, true);
    	   c = AlliedUtil.makeObjectsFromResultSet1(rs);
		    
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
	public Collection<AlliedVO> findById(String id)throws Exception
	{
		StringBuffer string = new StringBuffer();
		string.append("select a.cname,a.url,a.address,a.description,a.id,ap.id,ap.name,ap.contact,ap.emailid,ap.address,ap.city,ap.state,ap.country from alliedperson ap,alliedservice a ");
		string.append(" where ap.aid='");
		string.append(id);
		string.append("' and a.id='");
		string.append(id);
		string.append("'");

		System.out.println(string.toString());
		Collection<AlliedVO>  c = PerformDBQuery(string.toString());
		
		return c;
	}
	public int delete(String id)
	{
		String query;
		StringBuffer string=new StringBuffer();
		string.append("delete from alliedperson where  aid='");
		string.append(id);
		string.append("'");
		query=string.toString();
		Connection connection=null;
		PreparedStatement statement=null;
		int  result=0;
		DBConnector db=null;
		try
		{
			db=new DBConnector();
			connection=db.getConnection();
			statement=connection.prepareStatement(query);
			result=statement.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Something error");
		}
		finally
		{
			try{
				
				db.disconnect();
			}catch(Exception e){System.out.println("errrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrro");
		}
		
	}
		return result;
	
	}
	public int create(AlliedVO v) throws IOException,SQLException
	{
		String query=null;
		DBConnector db=null;
		Statement stat=null;
		Connection connection=null;
		int temp[]=null;
		try {
			 db = new DBConnector();
			 
			}
			
			catch(ClassNotFoundException eq) { eq.printStackTrace(); }
			catch(SQLException eq) { eq.printStackTrace(); }		
		try
		{
			StringBuffer string=new StringBuffer();
			StringBuffer string1=new StringBuffer();
			string.append("insert into alliedperson values('");
			string.append(v.getId());
			string.append("','");
			string.append(v.getCperson());
			string.append("','");
			string.append(v.getContact());
			string.append("','");
			string.append(v.getEmailid());
			string.append("','");
			string.append(v.getAddress2());
			string.append("','");
			string.append(v.getCity());
			string.append("','");
			string.append(v.getState());
			string.append("','");
			string.append(v.getCountry());
			string.append("','");
			string.append(v.getAid());
			string.append("','");
			string.append(v.getCompany());
			string.append("','");
			string.append(v.getAllied());
			string.append("')");
			string1.append("insert into alliedservice values('");
			string1.append(v.getAid());
			string1.append("','");
			string1.append(v.getAllied());
			string1.append("','");
			string1.append(v.getCompany());
			string1.append("','");
			string1.append(v.getUrl());
			string1.append("','");
			string1.append(v.getAddress1());
			string1.append("','");
			string1.append(v.getDesc());
			string1.append("','");
			string1.append(v.getCperson());
			string1.append("','");
			string1.append(v.getContact());
			string1.append("','");
			string1.append(v.getAddress2());
			string1.append("')");
			
			String query1;
			query=string.toString();
			query1=string1.toString();
			System.out.println(query);
			System.out.println(query1);
			connection=db.getConnection();
			stat=connection.createStatement();
			stat.addBatch(query1);
			stat.addBatch(query);
			String query2="select as.id='"+v.getAid()+"',ap.id='"+v.getId()+" from alliedperson ap,alliedservice";
			
			System.out.println("21ssssssssssssooooooooooooojjjjjjjjjjjjjjjjjjjj");
			try{ temp=stat.executeBatch();}catch(Exception e){e.printStackTrace();}
			int i=0;
			for(i=0;i<temp.length;i++)
			{
				System.out.println("2ssssssssssssooooooooooooo");
				System.out.println("Something "+i);
			}
			
			
		}catch(Exception e)
		{
			System.out.println("error inside connection");
		}
		finally{
			try{
				
				db.disconnect();
			}catch(Exception e){System.out.println("error inside connection vgvgggggggggggg");
		}
	}
		return temp.length;
	}
	public int ckeckexistance(AlliedVO v) throws Exception
	{
		int result=0;
		StringBuffer string=new StringBuffer();
		string.append(" select ");
		string.append(" id='");
		string.append(v.getId());
		string.append("'");
		string.append(" from ");
		string.append(" allied ");
		boolean flag1=false;
						
		String myquery=string.toString();
		DBConnector db = null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			 db = new DBConnector();
			 
			}
			
			catch(ClassNotFoundException eq) { eq.printStackTrace(); }
			catch(SQLException eq) { eq.printStackTrace(); }		
		
		try
		{
			conn=db.getConnection();
			PreparedStatement stat1=conn.prepareStatement(myquery);
			rs=stat1.executeQuery();
			while(rs.next())
			{
			  flag1=rs.getBoolean(1);
			  if(flag1==true)
			  {
				  result=1;
				  break;
			  }
			
			  System.out.println("error find");
			  System.out.println("existance of user:"+result);
		 }
		}catch(Exception e){System.out.println("qwetrytryw");}
		finally{
			try
			{
				db.disconnect();
			}
			catch(Exception e)
			{
				System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
			}
		}
		return result;
		
	}
		
	
		public int checkupdate(AlliedVO v) throws Exception {
			
			int result=0;
			StringBuffer string=new StringBuffer();
			string.append(" select ");
			string.append(" id='");
			string.append(v.getId());
			string.append("',");
			string.append("emailid='");
			string.append(v.getEmailid());
			string.append("',");
			string.append("A_Services='");
			string.append(v.getAllied());
			string.append("'");
			string.append(" from ");
			string.append(" allied ");
			boolean flag1=false;
			boolean flag2=false;
			boolean flag3=false;
					
			String myquery=string.toString();
			System.out.println(myquery);
			DBConnector db = null;
			Connection conn=null;
			ResultSet rs=null;
			try {
				 db = new DBConnector();
				 
				}
				
				catch(ClassNotFoundException eq) { eq.printStackTrace(); }
				catch(SQLException eq) { eq.printStackTrace(); }		
			
			try
			{
				conn=db.getConnection();
				PreparedStatement stat1=conn.prepareStatement(myquery);
				rs=stat1.executeQuery();
				while(rs.next())
				{
				  flag1=rs.getBoolean(1);
				  flag2=rs.getBoolean(2);
				  flag3=rs.getBoolean(3);
				  if(flag1==true&&flag2==true&&flag3==true)
				  {
					  result=1;
					  break;
				  }
				
				  System.out.println("error find");
				  System.out.println("existance of user:"+result);
			 }
			}catch(Exception e){System.out.println("qwetrytryw");}
			finally{
				try
				{
					db.disconnect();
				}
				catch(Exception e)
				{
					System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
				}
			}
			return result;
			
		}
			
	
			
		public int update(AlliedVO v)
		{
			int result[]=null;
			DBConnector db = null;
			Connection conn=null;
			ResultSet rs=null;
			String allied=v.getAid();
			Statement stat=null;
			StringBuffer string=new StringBuffer();
			StringBuffer string1=new StringBuffer();
			String query=null;
			String query1=null;
			
			try {
				 db = new DBConnector();
				 conn=db.getConnection();
				}
				
				catch(ClassNotFoundException eq) { eq.printStackTrace(); }
				catch(SQLException eq) { eq.printStackTrace(); }		
					try
					{
						stat=conn.createStatement();
						
						string.append("update alliedservice set asid='");
						string.append(v.getAllied());
						string.append("',cname='");
						string.append(v.getCompany());
						string.append("',url='");
						string.append(v.getUrl());
						string.append("',address='");
						string.append(v.getAddress1());
						string.append("',description='");
						string.append(v.getDesc());
						string.append("',pname='");
						string.append(v.getCperson());
						string.append("',pcontact='");
						string.append(v.getContact());
						string.append("',paddress='");
						string.append(v.getAddress2());
						string.append("' where id='");
						string.append(v.getAid());
						string.append("'");
						
						string1.append("update alliedperson set name='");
						string1.append(v.getCperson());
						string1.append("',contact='");
						string1.append(v.getContact());
						string1.append("',emailid='");
						string1.append(v.getEmailid());
						string1.append("',address='");
						string1.append(v.getAddress2());
						string1.append("',city='");
						string1.append(v.getCity());
						string1.append("',state='");
						string1.append(v.getState());
						string1.append("',country='");
						string1.append(v.getCountry());
						string1.append("',company='");
						string1.append(v.getCompany());
						string1.append("',asid='");
						string1.append(v.getAllied());
						string1.append("' where aid='");
						string1.append(v.getAid());
						string1.append("'");
						
						query=string.toString();
						query1=string1.toString();
						System.out.println(query);
						System.out.println(query1);
								
						stat.addBatch(query);
						stat.addBatch(query1);
						
						result=stat.executeBatch();
						
						
						
					}catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("error inside connection");
					}
					finally{
						try{
							
							db.disconnect();
						}catch(Exception e){System.out.println("error inside connection vgvgggggggggggg");
					}
				}
				return result.length;
			
		
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
			
			String query="select *from alliedservice";
			
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
		public int generateid1()
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
			
			String query="select *from alliedperson";
			
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
		public int check()
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
			String query="select *from allied";
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
		
		public String updateid(String id) {
			String string=null;
			if(id.equals("find"))
			{
				string=id;
			}
			else
			{
				string=id;
			}
			return string;
		}
		
		
}
