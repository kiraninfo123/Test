package com.collaba.management.dao;

import java.util.Collection;


import com.collaba.management.vo.AlliedVO;

public interface AlliedDao
{
	public Collection<AlliedVO> findById(String id)throws Exception;
	public int delete(String v)throws Exception;
	public int create(AlliedVO v) throws Exception;
	public int checkupdate(AlliedVO v) throws Exception;
	public int update(AlliedVO v) throws Exception;
	public int ckeckexistance(AlliedVO v) throws Exception;
	public int generateid() throws Exception;
	public int generateid1() throws Exception;
	public Collection<AlliedVO> findAll(String name)throws Exception;
	public String updateid(String id);
	
}