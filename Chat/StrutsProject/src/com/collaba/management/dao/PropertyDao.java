package com.collaba.management.dao;

import java.util.Collection;

import com.collaba.management.vo.PropertyVO;
import com.collaba.management.exception.PropertyNotFoundException;

public interface PropertyDao
{
	public Collection<PropertyVO> findById(String id)	throws PropertyNotFoundException;
	public void delete(PropertyVO v)throws PropertyNotFoundException;
	public void deleteAll()throws PropertyNotFoundException;	
	public int create(PropertyVO v) throws PropertyNotFoundException;
	public void update(PropertyVO v)throws PropertyNotFoundException;
	public Collection<PropertyVO> findAll() throws  PropertyNotFoundException,Exception;
	public Collection<PropertyVO> search( PropertyVO v) throws PropertyNotFoundException;
	public int check(PropertyVO v) throws PropertyNotFoundException;
	public int generateid() throws Exception;
	public Collection<PropertyVO> find(PropertyVO v) throws PropertyNotFoundException;
	
}

