package com.jbh.util.domain.insta;

public class Position {

	private float x;
	private float y;
	
	public void setX(float x) { this.x = x; }
	public void setY(float y) { this.y = y; }
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	
	public String toString() {
		return "Position [x="+this.x+", y="+this.y+"]";
	}
}
