package com.jbh.domain.main;

public class BGImgVO {

	private String filename;
	private String comment;
	
	public void setFilename(String filename) { this.filename = filename; }
	public void setComment(String comment) { this.comment = comment; }
	
	public String getFilename() { return this.filename; }
	public String getComment() { return this.comment; }
	
	public String toString() {
		return "MainBGIVO [filename="+this.filename+", comment="+this.comment+"]";
	}
}
