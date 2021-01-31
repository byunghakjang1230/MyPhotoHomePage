package com.jbh.domain.admin;

import java.sql.Timestamp;
import java.util.Date;

public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String nickname;
	private String authority;
	private Date regidate;
	
	public void setId(String id) { this.id = id; }
	public void setPassword(String password) { this.password = password; }
	public void setName(String name) { this.name = name; }
	public void setNickname(String nickname) { this.nickname = nickname; }
	public void setAuthority(String authority) { this.authority = authority; }
	public void setRegidate(Timestamp regidate) { this.regidate = toDate(regidate); }
	
	public String getId() { return this.id; }
	public String getPassword() { return this.password; }
	public String getName() { return this.name; }
	public String getNickname() { return this.nickname; }
	public String getAuthority() { return this.authority; }
	public Date getRegidate() { return this.regidate; }
	
	private Date toDate(Timestamp regidate) {
		return new Date(regidate.getTime());
	}
	
	public String toString() {
		return "MemberVO [id="+this.id+", password="+this.password+", name="+this.name+", nickname="+this.nickname+", authority="+this.authority+
				", regidate="+this.regidate+"]";
	}
}
