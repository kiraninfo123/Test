package com.collaba.management.dao;
import java.util.Collection;

import com.collaba.management.exception.AgentNotFoundException;
import com.collaba.management.vo.AgentVO;


public interface AgentDao
{
	public AgentVO findById(String id)throws AgentNotFoundException;
	public void delete(AgentVO v)throws AgentNotFoundException;
	public AgentVO create(AgentVO v) throws AgentNotFoundException;
	public void update(AgentVO v)throws AgentNotFoundException;
	public Collection<AgentVO> findAll() throws Exception,AgentNotFoundException;
	public Collection<AgentVO> search(String Insmgtname) throws AgentNotFoundException;
	
	
}