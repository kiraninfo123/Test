package com.collaba.management.dao;
import java.util.Collection;

import com.collaba.management.exception.BuilderNotFoundException;
import com.collaba.management.vo.BuilderVO;


public interface BuilderDao
{
	public BuilderVO findById(BuilderVO v);
	public void delete(BuilderVO v)throws BuilderNotFoundException;
	public BuilderVO create(BuilderVO v) throws BuilderNotFoundException;
	public void update(BuilderVO v)throws BuilderNotFoundException;
	public Collection<BuilderVO> findAll() throws Exception,BuilderNotFoundException;
	public Collection<BuilderVO> search(String Insmgtname) throws BuilderNotFoundException;
	
	
}