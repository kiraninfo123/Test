package com.collaba.management.vo;

import java.io.Serializable;

public class PropertytypeVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int P_ID;
	public String P_Name;
	
	public int getP_ID() {
		return P_ID;
	}
	public void setP_ID(int p_id) {
		P_ID = p_id;
	}
	public String getP_Name() {
		return P_Name;
	}
	public void setP_Name(String name) {
		P_Name = name;
	}
}

	
	