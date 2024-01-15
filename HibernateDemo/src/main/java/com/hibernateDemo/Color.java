package com.hibernateDemo;

public class Color {
	
	private long COLORID;
	private String name;
	
	public long getCOLORID() {
		return this.COLORID;
	}

	public String getName() {
		return this.name;
	}

	public void setCOLORID(long id) {
		this.COLORID = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
