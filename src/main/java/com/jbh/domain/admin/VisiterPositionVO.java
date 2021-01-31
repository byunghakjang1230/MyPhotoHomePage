package com.jbh.domain.admin;

public class VisiterPositionVO {
	
	private float lat;
	private float lng;
	
	public void setLat(float lat) { this.lat = lat; }
	public void setLon(float lon) {this.lng = lon; }
	
	public float getLat() { return this.lat; }
	public float getLng() { return this.lng; }
	
	public String toString() {
		return "VisiterPositionVO [lat="+this.lat+", lng="+this.lng+"]";
	}
}
