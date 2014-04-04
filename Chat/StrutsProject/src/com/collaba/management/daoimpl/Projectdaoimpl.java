
package com.collaba.management.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import com.collaba.management.dao.projectDao;
import com.collaba.management.db.DBConnector;
import com.collaba.management.exception.ProjectNotFoundException;
import com.collaba.management.util.ProjectUtil;
import com.collaba.management.vo.BuilderVO;
import com.collaba.management.vo.ProjectVO;

public class Projectdaoimpl implements  projectDao {
	
	
	public static final String CREATE="create";
	public static final String UPDATE="update";
	public static final String DELETE="delete";
	public static final String DELETE_ALL="deleteall";
    ResultSet rst = null;
    DBConnector db = null;
    
	private static Logger log = Logger.getLogger(ProjectUtil.class.getName());
	
	
	public Projectdaoimpl()
	{
		System.out.println("Dao implementation");
	}
	
	
	public void performDBUIDOperation(String operation, ProjectVO v) {
		
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
			ProjectVO v) {
		// TODO Auto-generated method stub
		return null;
	}


	public Collection<ProjectVO> PerformDBQuery(String query) {
			
			Collection<ProjectVO> c = null;
			 DBConnector db = null;
			try {
				 db = new DBConnector();
				 
				}
				
				catch(ClassNotFoundException eq) { eq.printStackTrace(); }
				catch(SQLException eq) { eq.printStackTrace(); }		
			
			try
			{
					
			  ResultSet  rs = db.getResultSet(query, true);
	    	   c = ProjectUtil.makeObjectsFromResultSet(rs);
			    
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
	public Collection<BuilderVO> PerformDBQueryforbuilder(String query) {
		
		Collection<BuilderVO> c = null;
		 DBConnector db = null;
		try {
			 db = new DBConnector();
			 
			}
			
			catch(ClassNotFoundException eq) { eq.printStackTrace(); }
			catch(SQLException eq) { eq.printStackTrace(); }		
		
		try
		{
				
		  ResultSet  rs = db.getResultSet(query, true);
    	   c = ProjectUtil.makeObjectsFromResultSet1(rs);
		    
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
			
		
	
	
	
	public ProjectVO findById( ProjectVO v) throws ProjectNotFoundException {
		
		 Collection c = null;
		 
		if (v.getId() == null)
		{
			throw new NullPointerException("id parameter");
		}
				
			StringBuffer sbSelect = new StringBuffer();
			sbSelect.append("SELECT *FROM ");
			sbSelect.append("project");
			sbSelect.append(" WHERE id= ?");
			sbSelect.append(v.getId());
			
			System.out.print(sbSelect.toString());
			
			  c = PerformDBQuery(sbSelect.toString());
			 
			  
			  Iterator iter =  c.iterator();
			  ProjectVO result = (ProjectVO)iter.next();
			  
			  System.out.print("find Success");
			  
		return result;
	}
	
	public ProjectVO create( ProjectVO v) {
		
	   v.getId();
	    
	    performDBUIDOperation(CREATE, v);
		
		return v;
	 //System.out.println(";"+v+";");
	}
	
	private int getUniqueId() {
		
		int id = 0;
		try {
			
			 id = ProjectUtil.getUniqueId();
			
				}
				catch (SQLException ex)
				{
					log.info("SQL Query problem while generating unique ID " );
					ex.printStackTrace();
							
				}	
		
		return id;
		
	}
	
	private PreparedStatement createInsertQuery1(Connection conn, ProjectVO v) {
		
		
		StringBuffer sbInsert = new StringBuffer();
	
		
		
		sbInsert.append("INSERT INTO ");
        sbInsert.append("project");
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
	




	
	public void update(ProjectVO v) throws ProjectNotFoundException
	{
		
		
		performDBUIDOperation(UPDATE, v);
		
     
	}
	
	
	
	
	
    public	PreparedStatement createUpdateQuery(Connection conn, ProjectVO v) throws SQLException {
		
	   
		StringBuffer sbUpdate = new StringBuffer();
		
		
		sbUpdate.append("UPDATE ");
		sbUpdate.append("project");
		sbUpdate.append(" SET ");
		sbUpdate.append("L_Id =?, ");
		sbUpdate.append("L_Name =?,");
		
		sbUpdate.append(" WHERE L_Id =?");
	
		sbUpdate.append(ProjectUtil.getUniqueId());

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
    

	private void validateData(ProjectVO v) {
		// TODO Auto-generated method stub
		
	}


	public void delete(ProjectVO v) throws ProjectNotFoundException
	{
		if (v.getId() == null) 	{
			throw new NullPointerException("id parameter");
		}
		
		performDBUIDOperation(DELETE,v);
			
		
		}
	
	
	
	public	PreparedStatement createDeleteQuery(Connection conn, ProjectVO v) throws SQLException {
		
		StringBuffer sbDelete = new StringBuffer();
		
		
		sbDelete.append("DELETE FROM ");
		sbDelete.append("project");
		sbDelete.append(" WHERE id  =?");
		sbDelete.append(ProjectUtil.getUniqueId());
		PreparedStatement stmtDelete = null;
		try {
			stmtDelete = conn.prepareStatement(sbDelete.toString());
			stmtDelete.setString(1,v.getId());
		
		
	}
	
        catch(SQLException exr) {  exr.printStackTrace(); }
		
		System.out.print(stmtDelete.toString());
		
		return stmtDelete;
		}
	
				

	public	PreparedStatement createDeleteAllQuery(Connection conn, ProjectVO v) {
		
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


public Collection findAll()throws ProjectNotFoundException
{
	
	StringBuffer sbSelect = new StringBuffer();
	sbSelect.append("SELECT *FROM ");
	sbSelect.append("project where location='");

	System.out.println(sbSelect.toString());
	Collection  c = PerformDBQuery(sbSelect.toString());
	
	return c;
	
}



public Collection<ProjectVO> search(String location)
throws ProjectNotFoundException {
	
	
	StringBuffer searchQuery  = new StringBuffer();
	searchQuery.append(" Select * from ");
	searchQuery.append("project");
	searchQuery.append(" where location ='");
	searchQuery.append(location);
	searchQuery.append("'");
	
	System.out.println(searchQuery.toString());
	Collection<ProjectVO>  c = PerformDBQuery(searchQuery.toString());

		return c;
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
public Collection<BuilderVO> searchbuilder(String location) throws Exception {
	StringBuffer searchQuery  = new StringBuffer();
	searchQuery.append(" Select * from ");
	searchQuery.append("builder");
	searchQuery.append(" where city ='");
	searchQuery.append(location);
	searchQuery.append("'");
	
	System.out.println(searchQuery.toString());
	Collection<BuilderVO>  c = PerformDBQueryforbuilder(searchQuery.toString());

		return c;
}	
public Collection<BuilderVO> findById(BuilderVO v) throws Exception {
	StringBuffer searchQuery  = new StringBuffer();
	searchQuery.append(" Select * from ");
	searchQuery.append("builder");
	searchQuery.append(" where id ='");
	searchQuery.append(v.getLoginid());
	searchQuery.append("'");
	
	System.out.println(searchQuery.toString());
	Collection<BuilderVO>  c = PerformDBQueryforbuilder(searchQuery.toString());

		return c;
}	

public static void main(String[] args) {
		
		try 
		
		{
			
			
			Projectdaoimpl impl = new Projectdaoimpl();
			ProjectVO v = new ProjectVO();
			
		
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
		    v = (ProjectVO)iter.next();
			
			
		
			
			
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
