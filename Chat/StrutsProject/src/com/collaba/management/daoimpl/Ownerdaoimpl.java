package com.collaba.management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import com.collaba.management.dao.OwnerDao;
import com.collaba.management.db.DBConnector;
import com.collaba.management.exception.OwnerNotFoundException;
import com.collaba.management.util.OwnerUtil;
import com.collaba.management.vo.OwnerVO;

public class Ownerdaoimpl implements  OwnerDao {
	
	
	public static final String CREATE="create";
	public static final String UPDATE="update";
	public static final String DELETE="delete";
	public static final String DELETE_ALL="deleteall";
    ResultSet rst = null;
    DBConnector db = null;
    
	private static Logger log = Logger.getLogger(OwnerUtil.class.getName());
	
	
	public Ownerdaoimpl()
	{
		System.out.println("Dao implementation");
	}
	
	
	public void performDBUIDOperation(String operation, OwnerVO v) {
		
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
				
				stat= 	createDeleteQuery(db.getConnection(), v);
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
			OwnerVO v) {
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
	    	   c = OwnerUtil.makeObjectsFromResultSet(rs);
			    
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
			
		
	
	
	
	public OwnerVO findById( OwnerVO v) {
		
		 Collection c = null;
		 
		if (v.getId() == null)
		{
			throw new NullPointerException("id parameter");
		}
				
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT *FROM ");
			sbSelect.append("Propertytype");
			sbSelect.append(" WHERE id= ?");
			sbSelect.append(v.getId());
			
			System.out.print(sbSelect.toString());
			
			  c = PerformDBQuery(sbSelect.toString());
			 
			  
			  Iterator iter =  c.iterator();
			  OwnerVO result = (OwnerVO)iter.next();
			  
			  System.out.print("find Success");
			  
		return result;
	}
	
	public OwnerVO create( OwnerVO v) {
		
	    v.setId(getUniqueId());
	    
	    performDBUIDOperation(CREATE, v);
		
		return v;
	 //System.out.println(";"+v+";");
	}
	
	private String getUniqueId() {
		
		String id = null;
		try {
			
			 id = OwnerUtil.getUniqueId();
			
				}
				catch (SQLException ex)
				{
					log.info("SQL Query problem while generating unique ID " );
					ex.printStackTrace();
							
				}	
		
		return id;
		
	}
	
	private PreparedStatement createInsertQuery1(Connection conn, OwnerVO v) {
		
		
		StringBuffer sbInsert = new StringBuffer();
	
		
		
		sbInsert.append("INSERT INTO ");
        sbInsert.append("owner");
		sbInsert.append(" VALUES (");
		sbInsert.append(" ?, ?, ?, ?, ?) ");
		
		
		
		PreparedStatement stmtInsert = null;
		
		try {
		stmtInsert = conn.prepareStatement(sbInsert.toString());
		
		stmtInsert.setString(1,v.getId());
		stmtInsert.setString(2,v.getName());
				
		}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtInsert.toString());
		
		return stmtInsert;
		
		
		
				
	}
	




	
	
	public void update(OwnerVO v) throws OwnerNotFoundException
	{
		
		
		performDBUIDOperation(UPDATE, v);
		
     
	}
	
	
	
	
	
    public	PreparedStatement createUpdateQuery(Connection conn, OwnerVO v) {
		
	   
		StringBuffer sbUpdate = new StringBuffer();
		
		sbUpdate.append("UPDATE ");
		sbUpdate.append("owner");
		sbUpdate.append(" SET ");
		sbUpdate.append("O_ID");
		sbUpdate.append("O_Name =?,");
		
		sbUpdate.append(" WHERE O_ID =?");
		
		PreparedStatement stmtUpdate = null;
		
		try {
		stmtUpdate = conn.prepareStatement(sbUpdate.toString());
		
		stmtUpdate.setString(1,v.getId());
		
		stmtUpdate.setString(2, v.getName());
	}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtUpdate.toString());
		
		return stmtUpdate;
		}
    


	public void delete(OwnerVO v) throws OwnerNotFoundException
	{
		if (v.getId() == null) 	{
			throw new NullPointerException("id parameter");
		}
		
		performDBUIDOperation(DELETE,v);
			
		
		}
	
	
	
	public	PreparedStatement createDeleteQuery(Connection conn, OwnerVO v) throws SQLException {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("owner");
		sbDelete.append(" WHERE id  =?");
		sbDelete.append(OwnerUtil.getUniqueId());
		PreparedStatement stmtDelete = null;
		try {
			stmtDelete = conn.prepareStatement(sbDelete.toString());
			stmtDelete.setString(1,v.getId());
		
		
	}
	
        catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtDelete.toString());
		
		return stmtDelete;
		}
	
				

	public	PreparedStatement createDeleteAllQuery(Connection conn, OwnerVO v) {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("owner");
		
		
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


public Collection findAll()throws OwnerNotFoundException
{
	
	StringBuffer sbSelect = new StringBuffer();
	sbSelect.append("SELECT *FROM ");
	sbSelect.append("owner");

	System.out.println(sbSelect.toString());
	Collection  c = PerformDBQuery(sbSelect.toString());
	
	return c;
	
}



public Collection<OwnerVO> search(int id)
throws OwnerNotFoundException {
	
	
	StringBuffer searchQuery  = new StringBuffer();
	searchQuery.append(" Select * from ");
	searchQuery.append("Users");
	searchQuery.append(" where id =");
	searchQuery.append(id);
	
	System.out.println(searchQuery.toString());
	Collection  c = PerformDBQuery(searchQuery.toString());

		return c;
}
	
	
	
	
public static void main(String[] args) {
		
		try 
		
		{
			
			
			Ownerdaoimpl impl = new Ownerdaoimpl();
			OwnerVO v = new OwnerVO();
			
		
		  //v.setId(1);
		 // v.setId(4);
			v.setName("aber");
			v.setAddress("my");
			
			

			//v=impl.findById(v);
		
		    
		impl.create(v);
			
	//impl.update(v);
			
			
		//impl.delete(v);
		//impl.deleteAll();
			
			 Collection c = impl.findAll();
		    
		       Iterator iter = c.iterator();
		       
		  while(iter.hasNext()) {
		    v = (OwnerVO)iter.next();
			
			
		
			
			
			System.out.println("Got Id : " + v.getId());
			
			System.out.println("username" +v.getName()+":");
			
				
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


@Override
public Collection<OwnerVO> search(String Insmgtname)
		throws OwnerNotFoundException {
	// TODO Auto-generated method stub
	return null;
}
}