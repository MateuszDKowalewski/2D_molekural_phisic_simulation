package com.gmail.aspoka1.molekyralphisic;

public class Main {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String NAME = "Molekular phisic";
	
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame(WIDTH, HEIGHT, NAME);
		GameContainer gc = new GameContainer(frame.getCanvas());
		gc.start();
	}
}