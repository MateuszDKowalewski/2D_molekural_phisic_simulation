package com.gmail.aspoka1.molecularphisic.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawFrame extends JFrame {
	private static final long serialVersionUID = 801486476992470583L;

	private Panel c;
	
	public DrawFrame(int width, int height, String name) {
		super();
		setTitle(name);
		c = new Panel(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(c);
		pack();
		setVisible(true);
	}
	
	public void addDrawableElement (Drawable e) {
		c.addDravableElement(e);
	}
	
	// getters
	Panel getCanvas() { return c; }
	

}

class Panel extends JPanel {
	private static final long serialVersionUID = -6832117658886512528L;
	
	List<Drawable> elements = new LinkedList<>();
	
	public Panel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		
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

class DrawComponent extends Canvas {
	private static final long serialVersionUID = 9091637057872804463L;
	
	List<Drawable> elements = new LinkedList<>();
	
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