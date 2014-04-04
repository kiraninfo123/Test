package com.collaba.management.vo;
import java.io.*;

public class AlliedVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String company;
	public String url;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String country;
	public String emailid;
	public String cperson;
	public FileOutputStream oimage;
	public String iimage;
	public String allied;
	public String desc;
	public String alliedid;
	public String aid;
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAlliedid() {
		return alliedid;
	}
	public void setAlliedid(String alliedid) {
		this.alliedid = alliedid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc=desc;
	}
	public String getAllied() {
		return allied;
	}
	public void setAllied(String allied) {
		this.allied = allied;
	}
	public FileOutputStream getOimage() {
		return oimage;
	}
	public void setOimage(FileOutputStream oimage) {
		this.oimage = oimage;
	}
	public String getIimage() {
		return iimage;
	}
	public void setIimage(String iimage) {
		this.iimage = iimage;
	}
	public String contact;
	public String notes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getCperson() {
		return cperson;
	}
	public void setCperson(String cperson) {
		this.cperson = cperson;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}