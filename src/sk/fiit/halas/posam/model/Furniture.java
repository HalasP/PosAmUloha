package sk.fiit.halas.posam.model;

public class Furniture {

	private char type;
	private int length;
	private int width;
	private boolean[][] spaceMatrix;
	
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public boolean[][] getSpaceMatrix() {
		return spaceMatrix;
	}
	public void setSpaceMatrix(boolean[][] spaceMatrix) {
		this.spaceMatrix = spaceMatrix;
	}
	
}
