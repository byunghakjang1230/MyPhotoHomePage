package com.jbh.util.domain.insta;

public class Image {

	private int width;
	private int height;
	private String url;
	
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setUrl(String url) { this.url = url; }
	
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public String getUrl() { return this.url; }
	
	public String toString() {
		return "Image [width="+this.width+", height="+this.height+", url="+this.url+"]";
	}
}
