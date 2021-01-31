package com.jbh.domain.admin;

public class RegistPhotoInfoDTO {
	
	private String maincate;
	private String subcate;
	private String title;
	private String context;
	private String filename;
	private String thumbname;
	
	public void setMaincate(String maincate) { this.maincate = maincate; }
	public void setSubcate(String subcate) { this.subcate = subcate; }
	public void setTitle(String title) { this.title = title; }
	public void setContext(String context) { this.context = context; }
	public void setFilename(String filename) { this.filename = filename; }
	public void setThumbname(String thumbname) { this.thumbname = thumbname; }
	
	public String getMaincate() { return this.maincate; }
	public String getSubcate() { return this.subcate; }
	public String getTitle() { return this.title; }
	public String getContext() { return this.context; }
	public String getFilename() { return this.filename; }
	public String getThumbname() { return this.thumbname; }
	
	public String toString() {
		return "RegistPhotoInfoDTO [maincate="+this.maincate+", subcate="+this.subcate+", title="+this.title+", context="+this.context+
				", filename="+this.filename+", thumbname="+this.thumbname+"]";
	}
}
