package com.collaba.management.dao;
import java.util.Collection;

import com.collaba.management.exception.LandmarkNotFoundException;
import com.collaba.management.vo.LandmarkVO;


public interface LandmarkDao
{
	public LandmarkVO findById(LandmarkVO v);
	public void delete(LandmarkVO v)throws LandmarkNotFoundException;
	public LandmarkVO create(LandmarkVO v) throws LandmarkNotFoundException;
	public void update(LandmarkVO v)throws LandmarkNotFoundException;
	public Collection<LandmarkVO> findAll() throws Exception,LandmarkNotFoundException;
	public Collection<LandmarkVO> search(String Insmgtname) throws LandmarkNotFoundException;
	
	
}