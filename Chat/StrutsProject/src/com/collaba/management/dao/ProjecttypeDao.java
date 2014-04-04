package com.collaba.management.dao;
import java.util.Collection;

import com.collaba.management.exception.ProjecttypeNotExistException;
import com.collaba.management.vo.ProjecttypeVO;


public interface ProjecttypeDao
{
	public ProjecttypeVO findById(ProjecttypeVO v);
	public void delete(ProjecttypeVO v)throws ProjecttypeNotExistException;
	public ProjecttypeVO create(ProjecttypeVO v) throws ProjecttypeNotExistException;
	public void update(ProjecttypeVO v)throws ProjecttypeNotExistException;
	public Collection<ProjecttypeVO> findAll() throws Exception,ProjecttypeNotExistException;
	public Collection<ProjecttypeVO> search(String Insmgtname) throws ProjecttypeNotExistException;
	
	
}