package com.gmail.aspoka1.molecularphisic.graphics;

import java.awt.geom.Point2D;

import com.gmail.aspoka1.molecularphisic.phisic.Atom;
import com.gmail.aspoka1.molecularphisic.phisic.Ball;
import com.gmail.aspoka1.molecularphisic.phisic.CollisionBlock;
import com.gmail.aspoka1.molecularphisic.phisic.StaticCollisionable;

public class Main {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String NAME = "Molekular Phisic";
	
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame(WIDTH, HEIGHT, NAME);
		GameContainer gc = new GameContainer(frame.getCanvas());
		
		//frame.addDrawableElement(new Ball(WIDTH / 2, HEIGHT / 2, 60, 200));
		
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
		CollisionBlock c = new CollisionBlock(0, 400, 640, 80);
		frame.addDrawableElement(c);
		gc.addStaticCollisionableComponent(c);
		

		Atom a = new Atom(new Point2D.Double(100.0, 100.0), 1.0);
		frame.addDrawableElement(a);
		gc.addPhisicComponent(a);
		gc.addDynamicCollisionableComponent(a);
		
		
		
		gc.start();
	}
}