
package com.collaba.management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import com.collaba.management.dao.AgentDao;
import com.collaba.management.dao.loginDao;
import com.collaba.management.db.DBConnector;
import com.collaba.management.exception.AgentNotFoundException;
import com.collaba.management.exception.UsersNotFoundException;
import com.collaba.management.util.loginUtil;
import com.collaba.management.vo.loginVO;

public class logindaoimpl implements  loginDao {
	
	
	public static final String CREATE="create";
	public static final String UPDATE="update";
	public static final String DELETE="delete";
	public static final String DELETE_ALL="deleteall";
    ResultSet rst = null;
    DBConnector db = null;
    
	private static Logger log = Logger.getLogger(loginUtil.class.getName());
	
	
	public logindaoimpl()
	{
		System.out.println("Dao implementation");
	}
	
	
	public void performDBUIDOperation(String operation, loginVO v) {
		
		int  result = 0;
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
        }
	

	
	private PreparedStatement createInsertQuery(Connection connection,
			loginVO v) {
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
	    	   c = loginUtil.makeObjectsFromResultSet(rs);
			    
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
			
		
	
	
	
	public loginVO findById( loginVO v) throws AgentNotFoundException {
		
		 Collection c = null;
		 
		if (v.getLoginid() == null||v.getName()==null||v.getPassword()==null)
		{
			throw new NullPointerException("id parameter");
		}
				
			StringBuffer sbSelect = new StringBuffer();
			String name=v.getName();
			String pword=v.getPassword();
			String login=v.getLoginid();
			
			String query="select  logid='"+login+"'";
			System.out.print(query);
			c = PerformDBQuery(query);
			 
			  Iterator iter =  c.iterator();
			  loginVO result = (loginVO)iter.next();
			  
			  System.out.print("find Success");
			  
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	public loginVO create( loginVO v) {
		
	    v.setLoginid(getUniqueId());
	    
	    performDBUIDOperation(CREATE, v);
		
		return v;
	 //System.out.println(";"+v+";");
	}
	
	private String getUniqueId() {
		
		String id = null;
		try {
			
			 id = loginUtil.getUniqueId();
			
				}
				catch (SQLException ex)
				{
					log.info("SQL Query problem while generating unique ID " );
					ex.printStackTrace();
							
				}	
		
		return id;
		
	}
	
	private PreparedStatement createInsertQuery1(Connection conn, loginVO v) {
		
		
		StringBuffer sbInsert = new StringBuffer();
	
		
		
		sbInsert.append("INSERT INTO ");
        sbInsert.append("login");
		sbInsert.append(" VALUES (");
		sbInsert.append(" ?, ?, ?, ?) ");
		
		
		
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
	




	
	public void update(loginVO v) throws UsersNotFoundException
	{
		
		
		performDBUIDOperation(UPDATE, v);
		
     
	}
	
	
	
	
	
    public	PreparedStatement createUpdateQuery(Connection conn, loginVO v) {
		
	   
		StringBuffer sbUpdate = new StringBuffer();
		
		
		sbUpdate.append("UPDATE ");
		sbUpdate.append("login");
		sbUpdate.append(" SET ");
		sbUpdate.append("L_Id =?, ");
		sbUpdate.append("L_Name =?,");
		
		sbUpdate.append(" WHERE L_Id =?");
	
		

		PreparedStatement stmtUpdate = null;
		
		try {
		stmtUpdate = conn.prepareStatement(sbUpdate.toString());
		
		stmtUpdate.setString(1,v.getLoginid());
		
		stmtUpdate.setString(2, v.getName());
	
		
		
	
		}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtUpdate.toString());
		
		return stmtUpdate;
		}
    

	private void validateData(loginVO v) {
		// TODO Auto-generated method stub
		
	}


	public void delete(loginVO v) throws UsersNotFoundException
	{
		if (v.getLoginid() == null) 	{
			throw new NullPointerException("id parameter");
		}
		
		performDBUIDOperation(DELETE,v);
			
		
		}
	
	
	
	public	PreparedStatement createDeleteQuery(Connection conn, loginVO v) throws SQLException {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("login");
		sbDelete.append(" WHERE id  =?");
		sbDelete.append(loginUtil.getUniqueId());
		PreparedStatement stmtDelete = null;
		try {
			stmtDelete = conn.prepareStatement(sbDelete.toString());
			stmtDelete.setString(1,v.getLoginid());
		
		
	}
	
        catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtDelete.toString());
		
		return stmtDelete;
		}
	
				

	public	PreparedStatement createDeleteAllQuery(Connection conn, loginVO v) {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("login");
		
		
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


public Collection findAll()throws AgentNotFoundException
{
	
	StringBuffer sbSelect = new StringBuffer();
	sbSelect.append("SELECT *FROM ");
	sbSelect.append("login");

	System.out.println(sbSelect.toString());
	Collection  c = PerformDBQuery(sbSelect.toString());
	
	return c;
	
}



public Collection<loginVO> search(String id)
throws AgentNotFoundException {
	
	
	StringBuffer searchQuery  = new StringBuffer();
	searchQuery.append(" Select * from ");
	searchQuery.append("login");
	searchQuery.append(" where id =");
	searchQuery.append(id);
	
	System.out.println(searchQuery.toString());
	Collection  c = PerformDBQuery(searchQuery.toString());

		return c;
}
	
	
	
	
public static void main(String[] args) {
		
		try 
		
		{
			
			
			logindaoimpl impl = new logindaoimpl();
			loginVO v = new loginVO();
			
		
		  //v.setId(1);
		 // v.setId(4);
			v.setName("aber");
			v.setLoginid("my");
			
			

			//v=impl.findById(v);
		
		    
		impl.create(v);
			
	//impl.update(v);
			
			
		//impl.delete(v);
		//impl.deleteAll();
			
			 Collection c = impl.findAll();
		    
		       Iterator iter = c.iterator();
		       
		  while(iter.hasNext()) {
		    v = (loginVO)iter.next();
			
			
		
			
			
			System.out.println("Got Id : " + v.getLoginid());
			
			System.out.println("UsersId:" + v.getName()+ ":");
			System.out.println("username" +v.getPassword()+":");
			
				
		  }
		  
		  
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



	



}


	
	


