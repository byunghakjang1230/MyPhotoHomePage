package com.jbh.util.domain.insta;

public class Caption {

	private String id;
	private String text;
	private String created_time;
	private From from;
	
	public void setId(String id) { this.id = id; }
	public void setText(String text) { this.text = text; }
	public void setCreated_time(String created_time) { this.created_time = created_time; }
	public void setFrom(From from) { this.from = from; }
	
	public String getId() { return this.id; }
	public String getText() { return this.text; }
	public String getCreated_time() { return this.created_time; }
	public From getFrom() { return this.from; }
	
	public String toString() {
		return "Caption [id="+this.id+", text="+this.text+", created_time="+this.created_time+", from="+this.from+"]";
	}
	
}
