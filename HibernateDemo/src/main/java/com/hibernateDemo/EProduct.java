package com.hibernateDemo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EProduct {

	private long ID;
	private String name;
	private BigDecimal price;
	private Date dateAdded;

	List<Color> colors;

	Set<OS> oses;
	
	Collection<ScreenSize> screenSizes;
	
	Map finance ; 	
	
	

	public Collection<ScreenSize> getScreenSizes() {
		return screenSizes;
	}

	public void setScreenSizes(Collection<ScreenSize> screenSizes) {
		this.screenSizes = screenSizes;
	}

	public Map getFinance() {
		return finance;
	}

	public void setFinance(Map finance) {
		this.finance = finance;
	}

	public Set<OS> getOses() {
		return oses;
	}

	public void setOses(Set<OS> oses) {
		this.oses = oses;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

}