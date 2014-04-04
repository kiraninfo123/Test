package com.collaba.management.dao;
import java.util.Collection;

import com.collaba.management.exception.NotAlliedPersonException;
import com.collaba.management.vo.AlliedpersonVO;


public interface AlliedpersDao
{
	public AlliedpersonVO findById(AlliedpersonVO v);
	public void delete(AlliedpersonVO v)throws NotAlliedPersonException;
	public AlliedpersonVO create(AlliedpersonVO v) throws NotAlliedPersonException;
	public void update(AlliedpersonVO v)throws NotAlliedPersonException;
	public Collection<AlliedpersonVO> findAll() throws Exception,NotAlliedPersonException;
	public Collection<AlliedpersonVO> search(String Insmgtname) throws NotAlliedPersonException;
	
	
}