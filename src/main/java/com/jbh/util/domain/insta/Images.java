package com.jbh.util.domain.insta;

public class Images {

	private Image thumbnail;
	private Image low_resolution;
	private Image standard_resolution;
	
	public void setThumbnail(Image thumbnail) { this.thumbnail = thumbnail; }
	public void setLow_resolution(Image low_resolution) { this.low_resolution = low_resolution; }
	public void setStandard_resolution(Image standard_resolution) { this.standard_resolution = standard_resolution; }
	
	public Image getThumbnail() { return this.thumbnail; }
	public Image getLow_resolution() { return this.low_resolution; }
	public Image getStandard_resolution() { return this.standard_resolution; }
	
	public String toString() {
		return "Images [thumbnail="+this.thumbnail+", low_resolution="+this.low_resolution+", standard_resolution="+this.standard_resolution+"]";
	}
}
