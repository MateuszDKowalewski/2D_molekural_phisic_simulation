package com.gmail.aspoka1.molecularphisic;

import com.gmail.aspoka1.molecularphisic.graphics.Frame;
import com.gmail.aspoka1.molecularphisic.graphics.GameContainer;
import com.gmail.aspoka1.molecularphisic.phisic.CollisionBlock;

/**
 * Let's make first documentation to check if git works
 */
public class Main{
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String NAME = "Molecular Physic";
	
	public static void main(String[] args) {
		GameContainer gc = new GameContainer();
		Frame frame = new Frame(gc);
		gc.setPanel(frame.getCanvas());

		CollisionBlock c = new CollisionBlock(0, 400, 640, 80);
		frame.setGround(c);
		gc.addStaticCollisionalComponent(c);

		gc.run();
	}
}