package com.jbh.domain.admin;

public class TempImgNamesVO {
	
	private String filename;
	private String thumbname;
	
	public void setFilename(String filename) { this.filename = filename; }
	public void setThumbname(String thumbname) { this.thumbname = thumbname; }
	
	public String getFilename() { return this.filename; }
	public String getThumbname() { return this.thumbname; }
	
	public String toString() {
		return "TempImgNamesVO [filename="+this.filename+", thumbname="+this.thumbname+"]";
	}
}
