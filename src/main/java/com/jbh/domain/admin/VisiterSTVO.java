package com.jbh.domain.admin;

public class VisiterSTVO {

	private int count;
	private String countryCode;
	private String country;
	
	public void setCount(int count) { this.count = count; }
	public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
	public void setCountry(String country) { this.country = country; }
	
	public int getCount() { return this.count; }
	public String getCountryCode() { return this.countryCode; }
	public String getCountry() { return this.country; }
	
	public String toString() {
		return "VisiterSTVO [count="+this.count+", countryCode="+this.countryCode+", country="+this.country+"]";
	}
}
