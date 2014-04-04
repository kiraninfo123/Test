
package com.collaba.management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import com.collaba.management.dao.LandmarkDao;
import com.collaba.management.db.DBConnector;
import com.collaba.management.exception.LandmarkNotFoundException;
import com.collaba.management.util.LandmarkUtil;
import com.collaba.management.vo.LandmarkVO;

public class Landmarkdaoimpl implements  LandmarkDao {
	
	
	public static final String CREATE="create";
	public static final String UPDATE="update";
	public static final String DELETE="delete";
	public static final String DELETE_ALL="deleteall";
    ResultSet rst = null;
    DBConnector db = null;
    
	private static Logger log = Logger.getLogger(LandmarkUtil.class.getName());
	
	
	public Landmarkdaoimpl()
	{
		System.out.println("Dao implementation");
	}
	
	
	public void performDBUIDOperation(String operation, LandmarkVO v) {
		
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
			LandmarkVO v) {
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
	    	   c = LandmarkUtil.makeObjectsFromResultSet(rs);
			    
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
			
		
	
	
	
	public LandmarkVO findById( LandmarkVO v)  {
		
		 Collection c = null;
		 
		if (v.getL_ID() == 0)
		{
			throw new NullPointerException("id parameter");
		}
				
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT *FROM ");
			sbSelect.append("landmark");
			sbSelect.append(" WHERE id= ?");
			sbSelect.append(v.getL_ID());
			
			System.out.print(sbSelect.toString());
			
			  c = PerformDBQuery(sbSelect.toString());
			 
			  
			  Iterator iter =  c.iterator();
			  LandmarkVO result = (LandmarkVO)iter.next();
			  
			  System.out.print("find Success");
			  
		return result;
	}
	
	public LandmarkVO create( LandmarkVO v) throws LandmarkNotFoundException {
		
	    try {
			v.setL_ID(LandmarkUtil.getUniqueId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    performDBUIDOperation(CREATE, v);
		
		return v;
	 //System.out.println(";"+v+";");
	}
	
	private int getUniqueId() {
		
		int id = 0;
		try {
			
			 id = LandmarkUtil.getUniqueId();
			
				}
				catch (SQLException ex)
				{
					log.info("SQL Query problem while generating unique ID " );
					ex.printStackTrace();
							
				}	
		
		return id;
		
	}
	
	private PreparedStatement createInsertQuery1(Connection conn, LandmarkVO v) {
		
		
		StringBuffer sbInsert = new StringBuffer();
	
		
		
		sbInsert.append("INSERT INTO ");
        sbInsert.append("landmark");
		sbInsert.append(" VALUES (");
		sbInsert.append(" ?, ?, ) ");
		
		
		
		PreparedStatement stmtInsert = null;
		
		try {
		stmtInsert = conn.prepareStatement(sbInsert.toString());
		
		stmtInsert.setString(1,Integer.toString(v.getL_ID()));
		stmtInsert.setString(2,v.getL_Name());
				
		}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtInsert.toString());
		
		return stmtInsert;
		
		
		
				
	}
	




	
	public void update(LandmarkVO v) throws LandmarkNotFoundException
	{
		
		
		performDBUIDOperation(UPDATE, v);
		
     
	}
	
	
	
	
	
    public	PreparedStatement createUpdateQuery(Connection conn, LandmarkVO v) throws SQLException {
		
	   
		StringBuffer sbUpdate = new StringBuffer();
		
		
		sbUpdate.append("UPDATE ");
		sbUpdate.append("landmark");
		sbUpdate.append(" SET ");
		sbUpdate.append("L_Id =?, ");
		sbUpdate.append("L_Name =?,");
		
		sbUpdate.append(" WHERE L_Id =?");
	
		sbUpdate.append(LandmarkUtil.getUniqueId());

		PreparedStatement stmtUpdate = null;
	
		try {
		stmtUpdate = conn.prepareStatement(sbUpdate.toString());
		
		stmtUpdate.setString(1,Integer.toString(v.getL_ID()));
		
		stmtUpdate.setString(2, v.getL_Name());
	
		}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtUpdate.toString());
		
		return stmtUpdate;
		}
    

	private void validateData(LandmarkVO v) {
		// TODO Auto-generated method stub
		
	}


	public void delete(LandmarkVO v) throws LandmarkNotFoundException
	{
		if (v.getL_ID() == 0) 	{
			throw new NullPointerException("id parameter");
		}
		
		performDBUIDOperation(DELETE,v);
			
		
		}
	
	
	
	public	PreparedStatement createDeleteQuery(Connection conn, LandmarkVO v) throws SQLException {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("landmark");
		sbDelete.append(" WHERE id  =?");
		sbDelete.append(LandmarkUtil.getUniqueId());
		PreparedStatement stmtDelete = null;
		try {
			stmtDelete = conn.prepareStatement(sbDelete.toString());
			stmtDelete.setString(1,Integer.toString(v.getL_ID()));
		
		
	}
	
        catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtDelete.toString());
		
		return stmtDelete;
		}
	PreparedStatement createDeleteAllQuery(Connection conn, LandmarkVO v) {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("landmark");
		
		
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


public Collection findAll()throws LandmarkNotFoundException
{
	
	StringBuffer sbSelect = new StringBuffer();
	sbSelect.append("SELECT *FROM ");
	sbSelect.append("landmark");

	System.out.println(sbSelect.toString());
	Collection  c = PerformDBQuery(sbSelect.toString());
	
	return c;
	
}



public Collection<LandmarkVO> search(String id)
throws LandmarkNotFoundException {
	
	
	StringBuffer searchQuery  = new StringBuffer();
	searchQuery.append(" Select * from ");
	searchQuery.append("landmark");
	searchQuery.append(" where id =");
	searchQuery.append(id);
	
	System.out.println(searchQuery.toString());
	Collection  c = PerformDBQuery(searchQuery.toString());

		return c;
}
	
	
	
	
public static void main(String[] args) {
		
		try 
		
		{
			
			
			Landmarkdaoimpl impl = new Landmarkdaoimpl();
			LandmarkVO v = new LandmarkVO();
					
		  //v.setId(1);
		 // v.setId(4);
			v.setL_Name("my");
			
			

			//v=impl.findById(v);
		
		    
		impl.create(v);
			
	//impl.update(v);
			
			
		//impl.delete(v);
		//impl.deleteAll();
			
			 Collection c = impl.findAll();
		    
		       Iterator iter = c.iterator();
		       
		  while(iter.hasNext()) {
		    v = (LandmarkVO)iter.next();
			
			
		
			
			
			System.out.println("Got Id : " + v.getL_ID());
			
			System.out.println("UsersId:" + v.getL_Name());
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




