package com.semanticsquare.jvm;

public class Llama {

	private String name;
	private int eyeCount;
	private String color;
	private boolean isAlive;

	public Llama(String name, int eyeCount, String color, boolean isAlive) {
		super();
		this.name = name;
		this.eyeCount = eyeCount;
		this.color = color;
		this.isAlive = isAlive;
	}

	public void wool() {
		System.out.println("Provide Wool.");
	}
	
	private void eat() {
		System.out.println("Llama should eat");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEyeCount() {
		return eyeCount;
	}

	public void setEyeCount(int eyeCount) {
		this.eyeCount = eyeCount;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Llama [name=" + name + ", eyeCount=" + eyeCount + ", color=" + color + ", isAlive=" + isAlive + "]";
	}

}
