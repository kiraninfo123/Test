package com.collaba.management.dao;
import java.util.Collection;

import com.collaba.management.exception.OwnerNotFoundException;
import com.collaba.management.vo.OwnerVO;


public interface OwnerDao
{
	public OwnerVO findById(OwnerVO v);
	public void delete(OwnerVO v)throws OwnerNotFoundException;
	public OwnerVO create(OwnerVO v) throws OwnerNotFoundException;
	public void update(OwnerVO v)throws OwnerNotFoundException;
	public Collection<OwnerVO> findAll() throws Exception,OwnerNotFoundException;
	public Collection<OwnerVO> search(String Insmgtname) throws OwnerNotFoundException;
	
	
}