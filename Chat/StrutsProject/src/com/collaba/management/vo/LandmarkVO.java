package com.collaba.management.vo;

import java.io.Serializable;

public class LandmarkVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int L_ID;
	public String L_Name;
	
	public int getL_ID() {
		return L_ID;
	}
	public void setL_ID(int l_id) {
		L_ID = l_id;
	}
	public String getL_Name() {
		return L_Name;
	}
	public void setL_Name(String name) {
		L_Name = name;
	}
}

	


	
	
	