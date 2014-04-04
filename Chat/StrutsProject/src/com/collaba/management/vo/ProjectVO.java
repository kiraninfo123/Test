package com.collaba.management.vo;

import java.io.Serializable;

public class ProjectVO implements Serializable
{
	public String id;
	public String name;
	public String location;
	public String projecttype;
	public String builderid;
	public String cost;
	
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getId() {
		return id;
	}
	public void setId(String i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProjecttype() {
		return projecttype;
	}
	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}
	public String getBuilderid() {
		return builderid;
	}
	public void setBuilderid(String builderid) {
		this.builderid = builderid;
	}
	
	
}