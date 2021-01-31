package com.jbh.domain.admin;

public class AdminVO {

	private String name;
	private String nickname;
	private String authority;
	
	public void setName(String name) { this.name = name; }
	public void setNickName(String nickname) { this.nickname = nickname; }
	public void setAuthority(String authority) { this.authority = authority; }
	
	public String getName() { return this.name; }
	public String getNickName() { return this.nickname; }
	public String getAuthority() { return this.authority; }
	
	public String toString() {
		return "Admin [name="+this.name+", nickname="+this.nickname+", authority="+this.authority+"]";
	}
}
