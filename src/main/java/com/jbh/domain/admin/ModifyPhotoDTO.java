package com.jbh.domain.admin;

public class ModifyPhotoDTO {

	private int no;
	private String maincate;
	private String subcate;
	private String title;
	private String context;
	private String filename;
	private String thumbname;
	private String change;
	
	public void setNo(int no) { this.no = no; }
	public void setMaincate(String maincate) { this.maincate = maincate; }
	public void setSubcate(String subcate) { this.subcate = subcate; }
	public void setTitle(String title) { this.title = title; }
	public void setContext(String context) { this.context = context; }
	public void setFilename(String filename) { this.filename = filename; }
	public void setThumbname(String thumbname) { this.thumbname = thumbname; }
	public void setChange(String change) { this.change = change; }
	
	public int getNo() { return this.no; }
	public String getMaincate() { return this.maincate; }
	public String getSubcate() { return this.subcate; }
	public String getTitle() { return this.title; }
	public String getContext() { return this.context; }
	public String getFilename() { return this.filename; }
	public String getThumbname() { return this.thumbname; }
	public String getChange() { return this.change; }

	public String toString() {
		return "ModifyPhotoDTO [no="+this.no+",maincate="+this.maincate+", subcate="+this.subcate+", title="+this.title+", context="+this.context+
				", filename="+this.filename+", thumbname="+this.thumbname+", change="+this.change+"]";
	}
}
