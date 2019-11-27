package com.gmail.aspoka1.molecularphisic.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


public class DrawFrame extends JFrame {
	private static final long serialVersionUID = 801486476992470583L;

	private DrawComponent c;
	
	public DrawFrame(int width, int height, String name) {
		super();
		setTitle(name);
		c = new DrawComponent(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(c);
		pack();
		setVisible(true);
	}
	
	public void addDrawableElement (Drawable e) {
		c.addDravableElement(e);
	}
	
	// getters
	Canvas getCanvas() { return c; }
	

}


class DrawComponent extends Canvas {
	private static final long serialVersionUID = 9091637057872804463L;
	
	List<Drawable> elements = new ArrayList<>();
	
	public DrawComponent(int width, int height) {
		setSize(width, height);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for(Drawable e : elements) {
			e.paint(g);
		}
	}
	
	public void addDravableElement(Drawable e) {
		elements.add(e);
	}
	
	public void clearDrawableElements() {
		elements.clear();
	}
}