package com.collaba.management.dao;

import java.util.Collection;

import com.collaba.management.exception.PropertyTypeNotFoundException;
import com.collaba.management.vo.PropertytypeVO;

public interface PropertytypeDao {

	public PropertytypeVO findById(PropertytypeVO v)	throws PropertyTypeNotFoundException;
	public void delete(PropertytypeVO v)throws  PropertyTypeNotFoundException;
	public void deleteAll()throws  PropertyTypeNotFoundException;	
	public void create( PropertytypeVO v) throws  PropertyTypeNotFoundException;
	public void update(PropertytypeVO v)throws Exception;
	public Collection<PropertytypeVO> findAll() throws  PropertyTypeNotFoundException, Exception;
	public Collection<PropertytypeVO> search(int id) throws PropertyTypeNotFoundException;
	


}
