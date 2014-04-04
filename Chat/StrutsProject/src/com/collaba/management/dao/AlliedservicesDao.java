package com.collaba.management.dao;
import java.util.Collection;

import com.collaba.management.exception.AlliedServicesNotFoundException;
import com.collaba.management.vo.AlliedservicesVO;


public interface AlliedservicesDao
{
	public AlliedservicesVO findById(AlliedservicesVO v);
	public void delete(AlliedservicesVO v)throws AlliedServicesNotFoundException;
	public AlliedservicesVO create(AlliedservicesVO v) throws AlliedServicesNotFoundException;
	public void update(AlliedservicesVO v)throws AlliedServicesNotFoundException;
	public Collection<AlliedservicesVO> findAll() throws Exception,AlliedServicesNotFoundException;
	public Collection<AlliedservicesVO> search(String Insmgtname) throws AlliedServicesNotFoundException;
	
	
}