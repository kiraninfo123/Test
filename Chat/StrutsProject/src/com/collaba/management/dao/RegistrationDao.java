package com.collaba.management.dao;

import java.sql.SQLException;
import java.util.Collection;
import com.collaba.management.exception.NotRegisteredException;
import com.collaba.management.vo.ProjectVO;
import com.collaba.management.vo.RegistrationVO;

public interface RegistrationDao{

	public Collection findById(RegistrationVO v)	throws NotRegisteredException;
	public int delete(RegistrationVO v)throws NotRegisteredException;
	public void deleteAll()throws NotRegisteredException;	
	public RegistrationVO create( RegistrationVO v) throws NotRegisteredException;
	public void update(RegistrationVO v)throws Exception;
	public Collection<RegistrationVO> findAll() throws NotRegisteredException, Exception;
	public Collection<RegistrationVO> search(int id) throws NotRegisteredException;
	public int find(String loginid,String name,String password) throws NotRegisteredException;
	public int createuser(RegistrationVO v) throws NotRegisteredException;
	public int updateuser(RegistrationVO v) throws NotRegisteredException, SQLException;
	public String register(String id,String username);
	public int createproject(ProjectVO v) throws Exception;
	public int generateid() throws Exception;
}
