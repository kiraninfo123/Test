package com.collaba.management.vo;

import java.io.Serializable;

public class loginVO implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String password;
	public String regid;
	public String loginid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
}