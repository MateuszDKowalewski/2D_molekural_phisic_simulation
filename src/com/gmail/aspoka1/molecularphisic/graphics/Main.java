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
		
		Atom a1 = new Atom(100, 100, 1);
		a1.setPhisicSimulation(false);
		Atom a2 = new Atom(100, 200, 1);
		Binder b = new Binder(a1, a2);

		frame.addDrawableElement(a1); // TODO: move addDraw... to game container?
		frame.addDrawableElement(a2);
		frame.addDrawableElement(b);

		gc.addPhisicComponent(a1);
		gc.addPhisicComponent(a2);
		
		gc.start();
	}
}