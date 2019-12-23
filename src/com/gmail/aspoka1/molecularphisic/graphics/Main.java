package com.gmail.aspoka1.molecularphisic.graphics;

import com.gmail.aspoka1.molecularphisic.phisic.Atom;
import com.gmail.aspoka1.molecularphisic.phisic.Ball;
import com.gmail.aspoka1.molecularphisic.phisic.CollisionBlock;

import java.awt.geom.Point2D;

/**
 * Let's make first documentation to check if git works
 */
public class Main {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String NAME = "Molekular Phisic";
	
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame(WIDTH, HEIGHT, NAME);
		GameContainer gc = new GameContainer(frame.getCanvas());
		
		// pendulum test
		/*
		
		Atom a1, a2;
		Binder b;
		
		a1 = new Atom(100, 100, 1);
		a2 = new Atom(200, 100, 1);
		b = new Binder(a1, a2, 1.0);
		a1.setPhisicSimulation(false);
		//a2.addForce(new Point.Double(500.0, 0.0));
		frame.addDrawableElement(a1);
		frame.addDrawableElement(a2);
		frame.addDrawableElement(b);
		gc.addPhisicComponent(a1);
		gc.addPhisicComponent(a2);
		
		
		a1 = new Atom(300, 100, 1);
		a2 = new Atom(400, 100, 1);
		b = new Binder(a1, a2, 100);
		a1.setPhisicSimulation(false);
		//a2.addForce(new Point.Double(500.0, 0.0));
		frame.addDrawableElement(a1);
		frame.addDrawableElement(a2);
		frame.addDrawableElement(b);
		gc.addPhisicComponent(a1);
		gc.addPhisicComponent(a2);
		*/
		
		// collision test
		/*
		CollisionBlock c = new CollisionBlock(0, 400, 640, 80);
		frame.addDrawableElement(c);
		gc.addStaticCollisionableComponent(c);
		

		Atom a = new Atom(new Point2D.Double(100.0, 100.0), 1.0);
		a.setPrintable(true);
		a.addForce(new Point2D.Double(1000, 0));
		frame.addDrawableElement(a);
		gc.addPhisicComponent(a);
		gc.addDynamicCollisionableComponent(a);
		*/


		CollisionBlock c = new CollisionBlock(0, 400, 640, 80);
		frame.addDrawableElement(c);
		gc.addStaticCollisionableComponent(c);
		
		Ball b = new Ball(WIDTH / 2, HEIGHT / 2 - 50, 30, 100);
		frame.addDrawableElement(b);
		gc.addPhisicComponent(b);
		gc.addDynamicCollisionableComponent(b);

		Point2D.Double p = new Point2D.Double(0, 10);
		Point2D.Double q = new Point2D.Double(20, 10);
		Point2D.Double r = new Point2D.Double(10, 10);
		Point2D.Double s = new Point2D.Double(15, 20);

		System.out.println(c.isInCollision(new Point2D.Double(100, 400)));
		System.out.println(c.isSegmentCrossed(p, q, s, r));



		/*
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		gc.start();
	}
}