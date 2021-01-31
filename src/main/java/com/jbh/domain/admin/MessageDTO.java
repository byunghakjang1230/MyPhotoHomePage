package com.jbh.domain.admin;

public class MessageDTO {

	private String name;
	private String email;
	private String message;
	
	public void setName(String name) { this.name = name; }
	public void setEmail(String email) { this.email = email; }
	public void setMessage(String message) { this.message = message; }
	
	public String getName() { return this.name; }
	public String getEmail() { return this.email; }
	public String getMessage() { return this.message; }
	
	public String toString() {
		return "MessageDTO [name="+this.name+", email="+this.email+", message="+this.message+"]";
	}
}
