package com.gmail.aspoka1.molecularphisic.graphics;

import com.gmail.aspoka1.molecularphisic.phisic.Atom;
import com.gmail.aspoka1.molecularphisic.phisic.Binder;

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
		
		gc.start();
	}
}