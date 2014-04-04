package com.collaba.management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import com.collaba.management.dao.PropertytypeDao;
import com.collaba.management.db.DBConnector;
import com.collaba.management.exception.PropertyTypeNotFoundException;
import com.collaba.management.exception.UsersNotFoundException;
import com.collaba.management.util.PropertytypeUtil;
import com.collaba.management.vo.PropertytypeVO;

public class PropertytypeDaoImpl implements  PropertytypeDao {
	
	
	public static final String CREATE="create";
	public static final String UPDATE="update";
	public static final String DELETE="delete";
	public static final String DELETE_ALL="deleteall";
    ResultSet rst = null;
    DBConnector db = null;
    
	private static Logger log = Logger.getLogger(PropertytypeUtil.class.getName());
	
	
	public PropertytypeDaoImpl()
	{
		System.out.println("Dao implementation");
	}
	
	
	public void performDBUIDOperation(String operation, PropertytypeVO v) {
		
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
			PropertytypeVO v) {
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
	    	   c = PropertytypeUtil.makeObjectsFromResultSet(rs);
			    
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
			
		
	
	
	
	public PropertytypeVO findById( PropertytypeVO v) throws PropertyTypeNotFoundException {
		
		 Collection c = null;
		 
		if (v.getP_ID() == 0)
		{
			throw new NullPointerException("id parameter");
		}
				
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT *FROM ");
			sbSelect.append("Propertytype");
			sbSelect.append(" WHERE id= ?");
			sbSelect.append(v.getP_ID());
			
			System.out.print(sbSelect.toString());
			
			  c = PerformDBQuery(sbSelect.toString());
			 
			  
			  Iterator iter =  c.iterator();
			  PropertytypeVO result = (PropertytypeVO)iter.next();
			  
			  System.out.print("find Success");
			  
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	public void create( PropertytypeVO v) {
		
	    v.setP_ID(getUniqueId());
	    
	    performDBUIDOperation(CREATE, v);
		
		
	 //System.out.println(";"+v+";");
	}
	
	private int getUniqueId() {
		
		int id = 0;
		try {
			
			 id = PropertytypeUtil.getUniqueId();
			
				}
				catch (SQLException ex)
				{
					log.info("SQL Query problem while generating unique ID " );
					ex.printStackTrace();
							
				}	
		
		return id;
		
	}
	
	private PreparedStatement createInsertQuery1(Connection conn, PropertytypeVO v) {
		
		
		StringBuffer sbInsert = new StringBuffer();
	
		validateData1(v);
		
		sbInsert.append("INSERT INTO ");
        sbInsert.append("Property Type");
		sbInsert.append(" VALUES (");
		sbInsert.append(" ?, ?, ?, ?, ?) ");
		
		
		
		PreparedStatement stmtInsert = null;
		
		try {
		stmtInsert = conn.prepareStatement(sbInsert.toString());
		
		stmtInsert.setInt(1,v.getP_ID());
		stmtInsert.setString(2,v.getP_Name());
				
		}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtInsert.toString());
		
		return stmtInsert;
		
		
		
				
	}
	




	private  void  validateData1(PropertytypeVO v) {
		
         
		if (v.getP_ID() == 0)	{
			throw new NullPointerException("id parameter");
			
		}
		
		if (v.getP_Name() == null)	{
			throw new NullPointerException("password parameter");
			
		}
		
		
		
	}
	
	
	public void update(PropertytypeVO v) throws Exception
	{
		
		
		performDBUIDOperation(UPDATE, v);
		
     
	}
	
	
	
	
	
    public	PreparedStatement createUpdateQuery(Connection conn, PropertytypeVO v) {
		
	   
		StringBuffer sbUpdate = new StringBuffer();
		
		
		validateData(v);
		
		
		sbUpdate.append("UPDATE ");
		sbUpdate.append("");
		sbUpdate.append(" SET ");
		sbUpdate.append("P_ID");
		sbUpdate.append("P_Name =?,");
		
		sbUpdate.append(" WHERE P_ID =?");
	
		

		PreparedStatement stmtUpdate = null;
		
		try {
		stmtUpdate = conn.prepareStatement(sbUpdate.toString());
		
		stmtUpdate.setInt(1,v.getP_ID());
		
		stmtUpdate.setString(2, v.getP_Name());
	
		
		
	
		}
		
		
		catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtUpdate.toString());
		
		return stmtUpdate;
		}
    

	private void validateData(PropertytypeVO v) {
		// TODO Auto-generated method stub
		
	}


	public void delete(PropertytypeVO v) throws PropertyTypeNotFoundException
	{
		if (v.getP_ID() == 0) 	{
			throw new NullPointerException("id parameter");
		}
		
		performDBUIDOperation(DELETE,v);
			
		
		}
	
	
	
	public	PreparedStatement createDeleteQuery(Connection conn, PropertytypeVO v) {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("Property Type");
		sbDelete.append(" WHERE id  =?");
		
		PreparedStatement stmtDelete = null;
		try {
			stmtDelete = conn.prepareStatement(sbDelete.toString());
			stmtDelete.setInt(1,v.getP_ID());
		
		
	}
	
        catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtDelete.toString());
		
		return stmtDelete;
		}
	
				

	public	PreparedStatement createDeleteAllQuery(Connection conn, PropertytypeVO v) {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("Property Type");
		
		
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


public Collection findAll()throws PropertyTypeNotFoundException
{
	
	StringBuffer sbSelect = new StringBuffer();
	sbSelect.append("SELECT *FROM ");
	sbSelect.append("Property Type");

	System.out.println(sbSelect.toString());
	Collection  c = PerformDBQuery(sbSelect.toString());
	
	return c;
	
}



public Collection<PropertytypeVO> search(int id)
throws PropertyTypeNotFoundException {
	
	
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
			
			
			PropertytypeDaoImpl impl = new PropertytypeDaoImpl();
			PropertytypeVO v = new PropertytypeVO();
			
		
		  //v.setId(1);
		 // v.setId(4);
			v.setP_Name("aber");
			v.setP_Name("my");
			
			

			//v=impl.findById(v);
		
		    
		impl.create(v);
			
	//impl.update(v);
			
			
		//impl.delete(v);
		//impl.deleteAll();
			
			 Collection c = impl.findAll();
		    
		       Iterator iter = c.iterator();
		       
		  while(iter.hasNext()) {
		    v = (PropertytypeVO)iter.next();
			
			
		
			
			
			System.out.println("Got Id : " + v.getP_ID());
			
			System.out.println("UsersId:" + v.getP_ID()+ ":");
			System.out.println("username" +v.getP_Name()+":");
			
				
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


	
	


