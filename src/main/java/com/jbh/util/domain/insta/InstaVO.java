package com.jbh.util.domain.insta;

public class InstaVO {

	private String url;
	private String link;
	
	public void setUrl(String url) { this.url = url; }
	public void setLink(String link) { this.link = link; }
	
	public String getUrl() { return this.url; }
	public String getLink() { return this.link; }
	
	public String toString() {
		return "InstaVO [url="+this.link+", link="+this.link+"]";
	}
}
