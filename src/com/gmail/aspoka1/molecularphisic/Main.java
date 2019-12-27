package com.gmail.aspoka1.molecularphisic;

import com.gmail.aspoka1.molecularphisic.graphics.DrawFrame;
import com.gmail.aspoka1.molecularphisic.graphics.GameContainer;
import com.gmail.aspoka1.molecularphisic.phisic.CollisionBlock;

/**
 * Let's make first documentation to check if git works
 */
public class Main{
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final int SIDE_BAR_WIDTH = 200;
	public static final String NAME = "Molekular Phisic";
	
	public static void main(String[] args) throws InterruptedException {
		GameContainer gc = new GameContainer();
		DrawFrame frame = new DrawFrame(WIDTH, SIDE_BAR_WIDTH, HEIGHT, NAME, gc);
		gc.setPanel(frame.getCanvas());

		CollisionBlock c = new CollisionBlock(0, 400, 640, 80);
		frame.setGround(c);
		gc.addStaticCollisionableComponent(c);

		gc.run();
	}
}