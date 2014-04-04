package com.collaba.management.daoimpl;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;

import com.collaba.management.dao.loanDao;
import com.collaba.management.vo.loanVO;
import com.collaba.management.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class loandaoimpl implements loanDao
{
	int result=0;
	
	public int performquery(String query)
	{
		DBConnector db=null;
		PreparedStatement stat=null;
		Connection connection=null;
		
		try
		{
			db=new DBConnector();
		}
		catch(Exception e){System.out.println("error 1");}
		try
		{
			connection=db.getConnection();
			stat=connection.prepareStatement(query);
			result=stat.executeUpdate();
		}catch(Exception e){e.printStackTrace();System.out.println("error 2");}
		
		System.out.println("Result is "+result);
	return result;
	}
	public int career(loanVO v) throws Exception
	{
		String query="insert into careers values(?,?,?)";
		DBConnector db=null;
		Connection connection=null;
		PreparedStatement stat=null;
		int result=0;
		try
		{
			db=new DBConnector();
			connection=db.getConnection();
			stat=connection.prepareStatement(query);
			stat.setString(1, v.getLid());
			stat.setString(2, v.getPassword());
			String filename=v.getFile();
			File file=new File(filename);
			FileInputStream fis=new FileInputStream(file);
			stat.setBinaryStream(3, fis, filename.length());
			result=stat.executeUpdate();
			fis.close();
		}catch(Exception e){e.printStackTrace();}
		finally
		{
			try{db.disconnect();}
			catch(Exception e){e.printStackTrace();}
			
		}
		return result;
	}
	public int check(String loginid) throws Exception
	{
		loanVO v=new loanVO();
		String query="select *from careers where id='"+v.getLid()+"'";
		DBConnector db=null;
		Connection connection=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		Boolean flag=false;
		int result=0;
		try
		{
			db=new DBConnector();
			connection=db.getConnection();
			stat=connection.prepareStatement(query);
			rs=stat.executeQuery();
			while(rs.next())
			{
				flag=rs.getBoolean(1);
				if(flag==true)
				{
					result=1;
					break;
				}
			}
		}catch(Exception e){e.printStackTrace();}
		finally
		{
			try{
				db.disconnect();
			}
			catch(Exception e){e.printStackTrace();}
		}
		return result;
	}
	public int create(loanVO v) throws Exception
	{
		Date date=new Date();
		System.out.println(date);
		int num=0;
		String name=v.getName();
		String address1=v.getAddress1();
		String salary=v.getSalary();
		String amount=v.getAmount();
		String state=v.getState();
		String city=v.getCity();
		String contact=v.getContact();
		String emailid=v.getEmailid();
		String occupation=v.getOccupation();
		String country=v.getCountry();
		int id=v.getId();
		String sid="l"+id;
		StringBuffer string=new StringBuffer();
		String query;
		string.append("insert into loan values('");
		string.append(sid);
		string.append("','");
		string.append(salary);
		string.append("','");
		string.append(amount);
		string.append("','");
		string.append(contact);
		string.append("','");
		string.append(emailid);
		string.append("','");
		string.append(address1);
		string.append("','");
		string.append(city);
		string.append("','");
		string.append(state);
		string.append("','");
		string.append(country);
		string.append("','");
		string.append(occupation);
		string.append("','");
		string.append(date);
		string.append("','");
		string.append(name);
		string.append("')");
		query=string.toString();
		System.out.println(query);
		num=performquery(query);
		
		System.out.println(+num);
		return num;
	}
	public int generateid() throws Exception {
		ResultSet rst = null;
	    DBConnector db = null;
	    PreparedStatement stat=null;
	    Connection conn=null;
	    int i=0;
	    try
	    {
	    	db=new DBConnector();
	    	conn=db.getConnection();
		
	    	String query="select *from loan";
		
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

}