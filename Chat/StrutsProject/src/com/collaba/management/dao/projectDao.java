package com.collaba.management.dao;

import java.util.Collection;

import com.collaba.management.vo.BuilderVO;
import com.collaba.management.vo.ProjectVO;
import com.collaba.management.exception.ProjectNotFoundException;

public interface projectDao
{
	public ProjectVO findById(ProjectVO v)	throws ProjectNotFoundException;
	public void delete(ProjectVO v)throws ProjectNotFoundException;
	public void deleteAll()throws ProjectNotFoundException;
	public ProjectVO create( ProjectVO v) throws ProjectNotFoundException;
	public void update(ProjectVO v)throws ProjectNotFoundException;
	public Collection<ProjectVO> findAll() throws ProjectNotFoundException,Exception;
	public Collection<ProjectVO> search(String Insmgtname) throws 	ProjectNotFoundException;
	public int generateid();
	public Collection<BuilderVO> findById(BuilderVO v) throws Exception;
	public Collection<BuilderVO> searchbuilder(String Insmgtname) throws Exception;
	
	
}

