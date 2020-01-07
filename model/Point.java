package model;

public class Point {
	private int x;
	private int y;
	private Point endPoint;
	private Point startPoint;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setLocation(int x, int y) {
		 this.x = x;
		 this.y = y;
	}
	public Point getStartPoint() {
		return this.startPoint;
	}
	public Point getEndPoint() {
		return this.endPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
}
