package com.collaba.management.dao;

import java.util.Collection;

import com.collaba.management.vo.loginVO;


public interface loginDao
{
	public loginVO findById(loginVO v)	throws Exception;
	public void delete(loginVO v)throws Exception;
	public loginVO create( loginVO v) throws Exception;
	public void update(loginVO v)throws Exception;
	public Collection<loginVO> findAll() throws Exception;
	public Collection<loginVO> search(String Insmgtname) throws Exception;
	
}