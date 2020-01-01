package com.gmail.aspoka1.molecularphisic;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;
import com.gmail.aspoka1.molecularphisic.graphics.Frame;
import com.gmail.aspoka1.molecularphisic.graphics.GameContainer;
import com.gmail.aspoka1.molecularphisic.phisic.CollisionBlock;
import com.gmail.aspoka1.molecularphisic.phisic.Polygon;

import java.awt.*;
import java.awt.geom.Point2D;

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

		//CollisionBlock c = new CollisionBlock(0, 400, 640, 80);
		//frame.setGround(c);
		//gc.addStaticCollisionalComponent(c);

		Point2D.Double p1 = new Point2D.Double(0D, 400D);
		Point2D.Double p2 = new Point2D.Double(320D, 440D);
		Point2D.Double p3 = new Point2D.Double(640D, 400D);
		Point2D.Double p4 = new Point2D.Double(640D, 480D);
		Point2D.Double p5 = new Point2D.Double(0D, 480D);

		Drawable d = new Polygon(Color.GREEN, p1, p2, p3, p4, p5);
		frame.addDrawableElement(d);

		gc.run();
	}
}