package com.jbh.util.domain.insta;

public class From {

	private String id;
	private String full_name;
	private String profile_picture;
	private String username;
	
	public void setId(String id) { this.id = id; }
	public void setFull_name(String full_name) { this.full_name = full_name; }
	public void setProfile_picture(String profile_picture) { this.profile_picture = profile_picture; }
	public void setUsername(String username) { this.username = username; }
	
	public String getId() { return this.id; }
	public String getFull_name() { return this.full_name; }
	public String getProfile_picture() { return this.profile_picture; }
	public String getUsername() { return this.username; }
	
	public String toString() {
		return "From [id="+this.id+", full_name="+this.full_name+", profile_picture="+this.profile_picture+", username="+this.username+"]";
	}
}
