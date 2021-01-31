package com.jbh.util.domain.insta;

import java.math.BigInteger;

public class Location {

	private float latitude;
	private float longitude;
	private String name;
	private BigInteger id;
	
	public void setLatitude(float latitude) { this.latitude = latitude; }
	public void setLongitude(float longitude) { this.longitude = longitude; }
	public void setName(String name) { this.name = name; }
	public void setId(BigInteger id) { this.id = id; }
	
	public float getLatitude() { return this.latitude; }
	public float getLongitude() { return this.longitude; }
	public String getName() { return this.name; }
	public BigInteger getId() { return this.id; }
	
	public String toString() {
		return "Location [latitude="+this.latitude+", longitude="+this.longitude+", name="+this.name+", id="+this.id+"]";
	}
	
}
