package com.jbh.domain.admin;

public class EmailDTO {

	private String emailaddress;
	private String message;
	
	public void setEmailaddress(String emailaddress) { this.emailaddress = emailaddress; }
	public void setMessage(String message) { this.message = message; }
	
	public String getEmailaddress() { return this.emailaddress; }
	public String getMessage() { return this.message; }
	
	public String toString() {
		return "EmailDTO [emailaddress="+this.emailaddress+", message="+this.message+"]";
	}
}
