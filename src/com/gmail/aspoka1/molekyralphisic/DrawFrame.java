package com.gmail.aspoka1.molekyralphisic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class DrawFrame extends JFrame {
	private static final long serialVersionUID = 801486476992470583L;

	private Canvas c;
	
	public DrawFrame(int width, int height, String name) {
		super();
		setTitle(name);
		c = new DrawComponent(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(c);
		pack();
		setVisible(true);
	}
	
	Canvas getCanvas() {
		return c;
	}

}


class DrawComponent extends Canvas {
	private static final long serialVersionUID = 9091637057872804463L;
	
	public DrawComponent(int width, int height) {
		setSize(width, height);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.RED);
		g.fillOval(100, 100, 10, 10);
	}
}