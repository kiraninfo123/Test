
package com.collaba.management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import com.collaba.management.dao.AlliedservicesDao;
import com.collaba.management.db.DBConnector;
import com.collaba.management.exception.AlliedServicesNotFoundException;
import com.collaba.management.util.AlliedservicesUtil;
import com.collaba.management.vo.AlliedservicesVO;

public class Alliedservicesdaoimpl implements  AlliedservicesDao {
	
	
	public static final String CREATE="create";
	public static final String UPDATE="update";
	public static final String DELETE="delete";
	public static final String DELETE_ALL="deleteall";
    ResultSet rst = null;
    DBConnector db = null;
    
	private static Logger log = Logger.getLogger(AlliedservicesUtil.class.getName());
	
	
	public Alliedservicesdaoimpl()
	{
		System.out.println("Dao implementation");
	}
	
	
	public void performDBUIDOperation(String operation, AlliedservicesVO v) {
		
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
			AlliedservicesVO v) {
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
	    	   c = AlliedservicesUtil.makeObjectsFromResultSet(rs);
			    
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
			
		
	
	
	
	public AlliedservicesVO findById(AlliedservicesVO v) {
		
		 Collection c = null;
		 
		if (v.getId() == null)
		{
			throw new NullPointerException("id parameter");
		}
				
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT *FROM ");
			sbSelect.append("alliedservices");
			sbSelect.append(" WHERE id= ?");
			sbSelect.append(v.getId());
			
			System.out.print(sbSelect.toString());
			
			  c = PerformDBQuery(sbSelect.toString());
			 
			  
			  Iterator iter =  c.iterator();
			  AlliedservicesVO result = (AlliedservicesVO)iter.next();
			  
			  System.out.print("find Success");
			  
		return result;
	}
	
	public AlliedservicesVO create( AlliedservicesVO v) {
		
	    v.setId(Double.toString(getUniqueId()));
	    
	    performDBUIDOperation(CREATE, v);
		
		return v;
	 //System.out.println(";"+v+";");
	}
	
	private int getUniqueId() {
		
		int id = 0;
		try {
			
			 id = AlliedservicesUtil.getUniqueId();
			
				}
				catch (SQLException ex)
				{
					log.info("SQL Query problem while generating unique ID " );
					ex.printStackTrace();
							
				}	
		
		return id;
		
	}
	
	private PreparedStatement createInsertQuery1(Connection conn, AlliedservicesVO v) {
		
		
		StringBuffer sbInsert = new StringBuffer();
	
		
		
		sbInsert.append("INSERT INTO ");
        sbInsert.append("alliedservices");
		sbInsert.append(" VALUES (");
		sbInsert.append(" ?, ?, ?, ?) ");
		
		
		
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
	




	
	public void update(AlliedservicesVO v) throws AlliedServicesNotFoundException
	{
		
		
		performDBUIDOperation(UPDATE, v);
		
     
	}
	
	
	
	
	
    public	PreparedStatement createUpdateQuery(Connection conn, AlliedservicesVO v) throws SQLException {
		
	   
		StringBuffer sbUpdate = new StringBuffer();
		
		
		sbUpdate.append("UPDATE ");
		sbUpdate.append("alliedservices");
		sbUpdate.append(" SET ");
		sbUpdate.append("A_S_Id =?, ");
		sbUpdate.append("A_S_Name =?,");
		
		sbUpdate.append(" WHERE A_S_Id =?");
	
		sbUpdate.append(AlliedservicesUtil.getUniqueId());

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
    

	private void validateData(AlliedservicesVO v) {
		// TODO Auto-generated method stub
		
	}


	public void delete(AlliedservicesVO v) throws AlliedServicesNotFoundException
	{
		if (v.getId() == null) 	{
			throw new NullPointerException("id parameter");
		}
		
		performDBUIDOperation(DELETE,v);
			
		
		}
	
	
	
	public	PreparedStatement createDeleteQuery(Connection conn,AlliedservicesVO v) throws SQLException {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("project");
		sbDelete.append(" WHERE id  =?");
		sbDelete.append(AlliedservicesUtil.getUniqueId());
		PreparedStatement stmtDelete = null;
		try {
			stmtDelete = conn.prepareStatement(sbDelete.toString());
			stmtDelete.setString(1,v.getId());
		
		
	}
	
        catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtDelete.toString());
		
		return stmtDelete;
		}
	
				

	public	PreparedStatement createDeleteAllQuery(Connection conn, AlliedservicesVO v) {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("project");
		
		
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


public Collection findAll()throws AlliedServicesNotFoundException
{
	
	StringBuffer sbSelect = new StringBuffer();
	sbSelect.append("SELECT *FROM ");
	
	
	
	sbSelect.append("architect");

	System.out.println(sbSelect.toString());
	Collection  c = PerformDBQuery(sbSelect.toString());
	
	return c;
	
}



public Collection<AlliedservicesVO> search(String id)
throws AlliedServicesNotFoundException {
	
	
	StringBuffer searchQuery  = new StringBuffer();
	searchQuery.append(" Select * from ");
	searchQuery.append("project");
	searchQuery.append(" where id =");
	searchQuery.append(id);
	
	System.out.println(searchQuery.toString());
	Collection  c = PerformDBQuery(searchQuery.toString());

		return c;
}
	
	
	
	
public static void main(String[] args) {
		
		try 
		
		{
			
			
			Alliedservicesdaoimpl impl = new Alliedservicesdaoimpl();
			AlliedservicesVO v = new AlliedservicesVO();
			
		
		  //v.setId(1);
		 // v.setId(4);
			v.setId("aber");
			v.setName("my");
			
			

			//v=impl.findById(v);
		
		    
		impl.create(v);
			
	//impl.update(v);
			
			
		//impl.delete(v);
		//impl.deleteAll();
			
			 Collection c = impl.findAll();
		    
		       Iterator iter = c.iterator();
		       
		  while(iter.hasNext()) {
		    v = (AlliedservicesVO)iter.next();
			
			
		
			
			
			System.out.println("Got Id : " + v.getId());
			
			System.out.println("UsersId:" + v.getName());
	/*	  RoleVO rv=new RoleVO();
		  rv.setId(v.getRoleId());
		  
		  rv = new RoleDaoImpl().findById(rv);
		  
		  PermroleDaoImpl pimpl = new PermroleDaoImpl();
		  Collection cp = pimpl.findAllPermissionByRole(rv);
		     
		*/     
		  // findrole
		  //findpermissionfor role
		  
		  
		  
		}
		}
		catch(Exception ex){}
}

		}




