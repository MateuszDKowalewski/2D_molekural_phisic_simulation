package com.gmail.aspoka1.molecularphisic.graphics;

import com.gmail.aspoka1.molecularphisic.phisic.Ball;

public class Main {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String NAME = "Molekular Phisic";
	
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame(WIDTH, HEIGHT, NAME);
		GameContainer gc = new GameContainer(frame.getCanvas());
		
		frame.addDrawableElement(new Ball(WIDTH / 2, HEIGHT / 2, 60, 200));
		
		gc.start();
	}
}