package com.jbh.util.domain.insta;

public class UsersInPhoto {

	private User user;
	private Position position;
	
	public void setUser(User user) { this.user = user; }
	public void setPosition(Position position) { this.position = position; }
	
	public User getUser() { return this.user; }
	public Position getPosition() { return this.position; }
	
	public String toString() {
		return "UsersInPhoto [user="+this.user+", position="+this.position+"]";
	}
}
