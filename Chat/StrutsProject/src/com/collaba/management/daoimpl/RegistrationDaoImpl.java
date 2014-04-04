package com.collaba.management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import com.collaba.management.dao.RegistrationDao;
import com.collaba.management.db.DBConnector;
import com.collaba.management.exception.NotRegisteredException;
import com.collaba.management.exception.PropertyTypeNotFoundException;
import com.collaba.management.exception.UsersNotFoundException;
import com.collaba.management.util.RegistrationUtil;
import com.collaba.management.vo.ProjectVO;
import com.collaba.management.vo.RegistrationVO;

public class RegistrationDaoImpl implements  RegistrationDao {
	
	
	public static final String CREATE="create";
	public static final String UPDATE="update";
	public static final String DELETE="delete";
	public static final String DELETE_ALL="deleteall";
    ResultSet rst = null;
    DBConnector db = null;
    
	private static Logger log = Logger.getLogger(RegistrationUtil.class.getName());
	
	
	public RegistrationDaoImpl()
	{
		System.out.println("Dao implementation");
	}
	

	public int performDBUIDOperation(String operation, RegistrationVO v) {
		
		int result = 0;
		DBConnector db = null;
		try {
			 db = new DBConnector();
			 
			}
			
			catch(ClassNotFoundException eq) { eq.printStackTrace(); }
			catch(SQLException eq) { eq.printStackTrace(); }		
		
		 
		try {
			
			PreparedStatement stat = null;
		
			if(operation.equals(CREATE)) {
		 stat= 	createInsertQuery(db.getConnection(), v);
			}
		
			else if(operation.equals(UPDATE)) {
				
				stat= 	createUpdateQuery(db.getConnection(), v);
			}
			
			
			else if (operation.equals(DELETE)){
				
				
				 stat= 	createDeleteQuery(db.getConnection(), v);	
				
			}
			
			else  {
			//	(operation.equals(DELETE_ALL))
				 stat= 	createDeleteAllQuery(db.getConnection(), v);	
				
			}
		   result = stat.executeUpdate();
		
		  return result;
        			
			
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
		return result;
        }
	

	
	private PreparedStatement createInsertQuery(Connection connection,
			RegistrationVO v) {
		// TODO Auto-generated method stub
		return null;
	}


	public Collection PerformDBQuery(String query) {
			
			Collection c = null;
			 DBConnector db = null;
			try {
				 db = new DBConnector();
				 
				}
				
				catch(ClassNotFoundException eq) { eq.printStackTrace(); }
				catch(SQLException eq) { eq.printStackTrace(); }		
			
			try
			{
					
			  ResultSet  rs = db.getResultSet(query, true);
	    	   c = RegistrationUtil.makeObjectsFromResultSet(rs);
			    
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
			
		
	
	
	
	public Collection findById( RegistrationVO v) throws NotRegisteredException {
		
		 Collection c = null;
		 
		if (v.getLoginid() == null)
		{
			throw new NullPointerException("id parameter");
		}
				
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT *FROM ");
			sbSelect.append("register");
			sbSelect.append(" WHERE loginid= ?");
			sbSelect.append(v.getLoginid());
			
			System.out.print(sbSelect.toString());
			
			  c = PerformDBQuery(sbSelect.toString());
			 
			  
			  
			  
		return c;
	}
	
	
	
	
	
	
	
	
	
	
	public RegistrationVO create( RegistrationVO v) {
		
	    v.setLoginid(getUniqueId());
	    
	    performDBUIDOperation(CREATE, v);
		
		return v;
	 //System.out.println(";"+v+";");
	}
	
	private String getUniqueId() {
		
		String id = null;
		try {
			
			 id = RegistrationUtil.getUniqueId();
			
				}
				catch (SQLException ex)
				{
					log.info("SQL Query problem while generating unique ID " );
					ex.printStackTrace();
							
				}	
		
		return id;
		
	}
	
	private PreparedStatement createInsertQuery1(Connection conn, RegistrationVO v) {
		
		
		StringBuffer sbInsert = new StringBuffer();
	
		validateData(v);
		
		sbInsert.append("INSERT INTO ");
        sbInsert.append("Property registration");
		sbInsert.append(" VALUES (");
		sbInsert.append(" ?, ?, ?, ?, ?) ");
		
		
		
		PreparedStatement stmtInsert = null;
		
		try {
		stmtInsert = conn.prepareStatement(sbInsert.toString());
		
		stmtInsert.setString(1,v.getLoginid());
		stmtInsert.setString(2,v.getName());
				
		}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtInsert.toString());
		
		return stmtInsert;
		
		
		
				
	}
	




	private  void  validateData(RegistrationVO v) {
		
         
		if (v.getLoginid() == null)	{
			throw new NullPointerException("id parameter");
			
		}
		
		if (v.getName() == null)	{
			throw new NullPointerException("password parameter");
			
		}
		
		
		
	}
	
	
	public void update(RegistrationVO v) throws Exception
	{
		
		
		performDBUIDOperation(UPDATE, v);
		
     
	}
	
	
	
	
	
    public	PreparedStatement createUpdateQuery(Connection conn, RegistrationVO v) {
		
	   
		StringBuffer string = new StringBuffer();
		
		
		validateData(v);
		
		
		string.append("UPDATE ");
		string.append("registration");
		string.append(" SET ");
		
		string.append(" name='");
		string.append(v.getName());
		string.append("',");
		string.append(" pword='");
		string.append(v.getPassword());
		string.append("',");
		string.append(" address='");
		string.append(v.getAddress());
		string.append("',");
		string.append(" email='");
		string.append(v.getEmail());
		string.append("',");
		string.append(" contactno='");
		string.append(v.getContactnumber());
		string.append("',");
		string.append(" city='");
		string.append(v.getCity());
		string.append("',");
		string.append(" state='");
		string.append(v.getState());
		string.append("',");
		string.append(" country='");
		string.append(v.getCountry());
		string.append("',");
		string.append(" usertype='");
		string.append(v.getUsertype());
		string.append("'");
		string.append(" where loginid='");
		string.append(v.getLoginid());
		string.append("'");
		
		String query=string.toString();
		
		DBConnector db=null;
		Connection connection=null;
		ResultSet rs=null;		
		PreparedStatement stmt = null;
		
		try {
			try {
				connection=db.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=connection.prepareStatement(query);
			int result=stmt.executeUpdate();
		
		
		
	
		}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(string.toString());
		
		return stmt;
		}
    

	

	public int delete(RegistrationVO v) throws NotRegisteredException
	{
		if (v.getLoginid() == null) 	{
			throw new NullPointerException("id parameter");
		}
		
		return performDBUIDOperation(DELETE,v);
			
		
		}
	
	
	
	public	PreparedStatement createDeleteQuery(Connection conn, RegistrationVO v) {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("login ");
		sbDelete.append(" WHERE loginid  =?");
		
		PreparedStatement stmtDelete = null;
		try {
			stmtDelete = conn.prepareStatement(sbDelete.toString());
			stmtDelete.setString(1,v.getLoginid());
		
		
	}
	
        catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtDelete.toString());
		
		return stmtDelete;
		}
	
				

	public	PreparedStatement createDeleteAllQuery(Connection conn, RegistrationVO v) {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("registration");
		
		
		PreparedStatement stmtDelete = null;
		try {
			stmtDelete = conn.prepareStatement(sbDelete.toString());
		
		
		
	}
	
        catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtDelete.toString());
		
		return stmtDelete;
		}


public void deleteAll()
{
	
	
	performDBUIDOperation(DELETE_ALL,null);
		
	
	}


public Collection findAll()throws NotRegisteredException
{
	
	StringBuffer sbSelect = new StringBuffer();
	sbSelect.append("SELECT *FROM ");
	sbSelect.append("registration");

	System.out.println(sbSelect.toString());
	Collection  c = PerformDBQuery(sbSelect.toString());
	
	return c;
	
}



public Collection<RegistrationVO> search(String id)
throws NotRegisteredException {
	
	
	StringBuffer searchQuery  = new StringBuffer();
	searchQuery.append(" Select * from ");
	searchQuery.append("register");
	searchQuery.append(" where loginid ='");
	searchQuery.append(id);
	searchQuery.append("'");
	
	System.out.println(searchQuery.toString());
	Collection  c = PerformDBQuery(searchQuery.toString());

		return c;
}

public int finduser(boolean loginid,boolean name,boolean password)
{
	int temp=0;
	
	if(loginid==true&&name==true&&password==true)
	{
		temp=1;
	}
	else if(loginid==true||name==true||password==true)
	{
		temp=-1;
	}
	return temp;
}




public String register(String loginid,String password,String name)
{
	StringBuffer string=new StringBuffer();
	string.append(" select ");
	string.append(" loginid='");
	string.append(loginid);
	string.append("',");
	string.append("name='");
	string.append(name);
	string.append("',pword='");
	string.append(password);
	string.append("' from ");
	string.append(" login ");
	Boolean flag1=false;
	Boolean flag2=false;
	Boolean flag3=false;
			
	String query=string.toString();
	 System.out.println(query);
	String userpassword=null;
	int result=0;
	DBConnector db = null;
	Connection conn=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	PreparedStatement stat2=null;
	try {
		 db = new DBConnector();
		 
		}
		
		catch(ClassNotFoundException eq) { eq.printStackTrace(); }
		catch(SQLException eq) { eq.printStackTrace(); }		
	
	try
	{
		conn=db.getConnection();
		PreparedStatement stat1=conn.prepareStatement(query);
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
	 }
	//	stat2=conn.prepareStatement(myquery);
		rs1=stat2.executeQuery();
		while(rs1.next())
		{
			userpassword=rs1.getString("pword");
		}
	  System.out.println(userpassword);
	 
	}catch(Exception e){System.out.println("Cant connect to db");}
	
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
	
		  return userpassword;
	
}

public int find(String loginid,String name,String password) throws NotRegisteredException
{
	StringBuffer string=new StringBuffer();
	string.append(" select ");
	string.append(" loginid=");
	string.append("'");
	string.append(loginid);
	string.append("'");
	string.append(",");
	string.append("name='");
	string.append(name);
	string.append("',");
	string.append("pword=");
	string.append("'");
	string.append(password);
	string.append("'");
	string.append(" ");
	string.append(" from login");
	String query=string.toString();
	System.out.println("Entered query is :"+query);
	
	Boolean flag1=false;
	Boolean flag2=false;
	Boolean flag3=false;
	Boolean flag4=false;
	Boolean flag5=false;
	Boolean flag6=false;
	
	int result = 0;
	
	DBConnector db = null;
	try {
		 db = new DBConnector();
		 
		}
		
		catch(ClassNotFoundException eq) { eq.printStackTrace(); }
		catch(SQLException eq) { eq.printStackTrace(); }		
	
	try
	{
			
	  ResultSet  rs = db.getResultSet(query, true);
	  while(rs.next())
	  {
		  System.out.println("error find");
		  flag1=rs.getBoolean(1);
		  flag2=rs.getBoolean(2);
		  flag3=rs.getBoolean(3);
		  if(flag1==true&&flag2==true&&flag3==true)
		  {
			  flag4=true;
			  flag5=true;
			  flag6=true;
			  break;
		  }
		 
	  }
		  
		  System.out.println("error find 1");
		  
	  
	  
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
    
    result=finduser(flag4,flag5,flag6);
    System.out.println("Result is "+result);
	return result;
	
}


	
	
public int createuser(RegistrationVO v) throws NotRegisteredException
{
	
	String username=v.getName();
	String password=v.getPassword();
	String loginid=v.getLoginid();
	String address=v.getAddress();
	String city=v.getCity();
	String country=v.getCountry();
	String contactnumber=v.getContactnumber();
	String state=v.getState();
	String email=v.getEmail();
	String usertype=v.getUsertype();
	int temp=0;
	DBConnector db=null;
	Statement stat=null;
	Connection connection=null;
	StringBuffer string=new StringBuffer();
	string.append("insert into register values('");
	string.append(loginid);
	string.append("','");
	string.append(username);
	string.append("','");
	string.append(password);
	string.append("','");
	string.append(contactnumber);
	string.append("','");
	string.append(address);
	string.append("','");
	string.append(email);
	string.append("','");
	string.append(city);
	string.append("','");
	string.append(state);
	string.append("','");
	string.append(country);
	string.append("','");
	string.append(usertype);
	string.append("')");
	String type=null;
	String project=null;
	if(usertype.equals("Builder"))
	{
		type="builder";
		
	}
	else if(usertype.equals("Owner"))
	{
		type="owner";
		
	}
	else if(usertype.equals("Agent"))
	{
		type="agent";
		
	}
	else{}
	StringBuffer string1=new StringBuffer();
	
	string1.append("insert into "+type+" values('");
	string1.append(loginid);
	string1.append("','");
	string1.append(username);
	string1.append("','");
	string1.append(password);
	string1.append("','");
	string1.append(contactnumber);
	string1.append("','");
	string1.append(address);
	string1.append("','");
	string1.append(email);
	string1.append("','");
	string1.append(city);
	string1.append("','");
	string1.append(state);
	string1.append("','");
	string1.append(country);
	string1.append("')");
	
	String query=string.toString();
	String query1=string1.toString();
	
	String query2="insert into login values('"+v.getLoginid()+"','"+v.getName()+"','"+v.getPassword()+"','1')";
	System.out.println(query);System.out.println(query1);System.out.println(query2);
	try
	{
		db=new DBConnector();
		connection=db.getConnection();
		stat=connection.createStatement();
	}catch(Exception e){e.printStackTrace();}
	
	
	
		try {
			stat.addBatch(query);
			System.out.println("bfbeufueb");
			stat.addBatch(query2);
			System.out.println("bdwydywdyf");
			stat.addBatch(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int a[] = null;
		try {
			a = stat.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i<a.length;i++)
		{
			System.out.println(+i);
		}
		temp=1;
	
	try {
		db.disconnect();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(a.length);
	return a.length;
}





public int updateuser(RegistrationVO v) throws SQLException
{
	StringBuffer string = new StringBuffer();
	StringBuffer string1=new StringBuffer();
	
	
	
	string.append("UPDATE ");
	string.append("register");
	string.append(" SET ");
	
	string.append(" name='");
	string.append(v.getName());
	string.append("',");
	string.append(" pword='");
	string.append(v.getPassword());
	string.append("',");
	string.append(" contact='");
	string.append(v.getAddress());
	string.append("',");
	string.append(" address='");
	string.append(v.getEmail());
	string.append("',");
	string.append(" emailid='");
	string.append(v.getContactnumber());
	string.append("',");
	string.append(" city='");
	string.append(v.getCity());
	string.append("',");
	string.append(" state='");
	string.append(v.getState());
	string.append("',");
	string.append(" country='");
	string.append(v.getCountry());
	string.append("',");
	string.append(" usertype='");
	string.append(v.getUsertype());
	string.append("'");
	string.append(" where loginid='");
	string.append(v.getLoginid());
	string.append("'");
	
	String usertype=v.getUsertype();
	string1.append("UPDATE ");
	string1.append(usertype);
	string1.append(" SET ");
	
	string1.append(" name='");
	string1.append(v.getName());
	string1.append("',");
	string1.append(" pword='");
	string1.append(v.getPassword());
	string1.append("',");
	string1.append(" contact='");
	string1.append(v.getAddress());
	string1.append("',");
	string1.append(" address='");
	string1.append(v.getEmail());
	string1.append("',");
	string1.append(" emailid='");
	string1.append(v.getContactnumber());
	string1.append("',");
	string1.append(" city='");
	string1.append(v.getCity());
	string1.append("',");
	string1.append(" state='");
	string1.append(v.getState());
	string1.append("',");
	string1.append(" country='");
	string1.append(v.getCountry());
	string1.append("' where id='");
	string1.append(v.getLoginid());
	string1.append("'");
	
	StringBuffer string2=new StringBuffer();
	string2.append("UPDATE ");
	string2.append("login ");
	string2.append(" SET ");
	
	string2.append(" name='");
	string2.append(v.getName());
	string2.append("',");
	string2.append(" pword='");
	string2.append(v.getPassword());
	string2.append("',roleid='1' ");
	string2.append(" where loginid='");
	string2.append(v.getLoginid());
	string2.append("'");
	String query=string.toString();
	String query1=string1.toString();
	String query2=string2.toString();
	
	System.out.println(query);
	System.out.println(query1);
	System.out.println(query2);
	
	DBConnector db=null;
	Connection connection=null;
	Statement stmt = null;
	int result=0;
	int a[]=null;
	
	try {
		db=new DBConnector();
		connection=db.getConnection();
		stmt=connection.createStatement();
		stmt.addBatch(query);
		stmt.addBatch(query2);
		stmt.addBatch(query1);
		
	try{	a=stmt.executeBatch(); } catch(Exception e){e.printStackTrace();}
		for(int i=0;i<a.length;i++)
		{
			System.out.println(+i);
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Error in updating");
	}
	return a.length;
}

public int createproject(ProjectVO v) throws Exception {
	
	DBConnector db=null;
	PreparedStatement stat=null;
	Connection connection=null;
	StringBuffer string=new StringBuffer();
	string.append("insert into project values('");
	string.append(v.getId());
	string.append("','");
	string.append(v.getName());
	string.append("','");
	string.append(v.getLocation());
	string.append("','");
	string.append(v.getBuilderid());
	string.append("','");
	string.append(v.getProjecttype());
	string.append("','");
	string.append(v.getCost());
	string.append("')");
	String query=string.toString();
	System.out.println(query);
	int result=0;
	try
	{
		db=new DBConnector();
		connection=db.getConnection();
		stat=connection.prepareStatement(query);
		result=stat.executeUpdate();
		System.out.println(result);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try{db.disconnect();}
		catch(Exception e){}
	}
	System.out.println(result);
	return result;
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
	
    	String query="select *from project";
	
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

public static void main(String[] args) {
		
		try 
		
		{
			
			
			PropertytypeDaoImpl impl = new PropertytypeDaoImpl();
			RegistrationVO v = new RegistrationVO();
			
		
		  //v.setId(1);
		 // v.setId(4);
			v.setLoginid("aber");
			v.setName("my");
			
			

			//v=impl.findById(v);
		
		    
		
			
							
		  
		  
		  
		  // find/get user  from userVO
		  
	/*	  RoleVO rv=new RoleVO();
		  rv.setId(v.getRoleId());
		  
		  rv = new RoleDaoImpl().findById(rv);
		  
		  PermroleDaoImpl pimpl = new PermroleDaoImpl();
		  Collection cp = pimpl.findAllPermissionByRole(rv);
		     
		*/     
		  // findrole
		  //findpermissionfor role
		  
		  
		  
		}
		catch(Exception ex){}
}




@Override
public Collection<RegistrationVO> search(int id) throws NotRegisteredException {
	// TODO Auto-generated method stub
	return null;
}


@Override
public String register(String id, String username) {
	// TODO Auto-generated method stub
	return null;
}





}