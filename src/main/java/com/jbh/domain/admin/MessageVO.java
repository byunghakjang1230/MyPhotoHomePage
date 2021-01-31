package com.jbh.domain.admin;

import java.sql.Timestamp;
import java.util.Date;

public class MessageVO {

	private int no;
	private String email;
	private String name;
	private String message;
	private Date regdate;
	
	public void setNo(int no) { this.no = no; }
	public void setEmail(String email) { this.email = email; }
	public void setName(String name) { this.name = name; }
	public void setMessage(String message) { this.message = message; }
	public void setRegdate(Timestamp regdate) { this.regdate = toDate(regdate);}
	
	public int getNo() { return this.no; }
	public String getEmail() { return this.email; }
	public String getName() { return this.name; }
	public String getMessage() { return this.message; }
	public Date getRegdate() { return this.regdate;}
	
	public String toString() {
		return "MessageVO [no="+this.no+", email="+this.email+", name="+this.name+", message="+this.message+", regdate="+this.regdate+"]";
	}
	
	private Date toDate(Timestamp regdate) {
		return new Date(regdate.getTime());
	}
}
