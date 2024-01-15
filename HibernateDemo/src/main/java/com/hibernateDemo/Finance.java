package com.hibernateDemo;

public class Finance {

	private long FINANCEID;
	private String name;
	private String ftype;
	
	
	public long getFINANCEID() {
		return FINANCEID;
	}
	public void setFINANCEID(long fINANCEID) {
		FINANCEID = fINANCEID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	
	
}
