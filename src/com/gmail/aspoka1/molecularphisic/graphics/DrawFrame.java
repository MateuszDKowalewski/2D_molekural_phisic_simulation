package com.gmail.aspoka1.molecularphisic.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;


public class DrawFrame extends JFrame {
	private static final long serialVersionUID = 801486476992470583L;

	GenerateBallPanel gbp;

	private Panel c;

	int width;
	int height;
	int sideBarWidth;
	
	public DrawFrame(int width, int sideBarWidth, int height, String name, GameContainer gc) {
		super();
		setTitle(name);
		c = new Panel(width, sideBarWidth, height);
		gbp = new GenerateBallPanel(sideBarWidth, height, width, 0, c, this, gc);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(c);
		getContentPane().setBackground(Color.red); // why dont work
		setBackground(Color.red);
		setResizable(false);
		pack();
		setVisible(true);

		this.width = width;
		this.sideBarWidth = sideBarWidth;
		this.height = height;
	}

	public void clear() {
		c.clear();
	}

	public void setGround(Drawable ground) {
		c.setGround(ground);
	}
	
	public void addDrawableElement (Drawable e) {
		c.addDravableElement(e);
	}
	
	// getters
	public Panel getCanvas() { return c; }

}

class Panel extends JPanel {
	private static final long serialVersionUID = -6832117658886512528L;

	JButton generate;
	JButton start;
	JButton end;

	Drawable ground;
	List<Drawable> elements = new LinkedList<>();

	int width;
	int height;
	int sideBarWidth;

	public Panel(int width, int sideBarWidth, int height) {
		setLayout(null);
		setPreferredSize(new Dimension(width + sideBarWidth, height));

		this.width = width;
		this.height = height;
		this.sideBarWidth = sideBarWidth;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);

		g.setColor(Color.CYAN);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(width, 0, sideBarWidth, height);
		g.setColor(Color.BLACK);
		g.drawLine(width, 0, width, height);

		ground.paint(g);

		for(Drawable e : elements) {
			e.paint(g);
		}
	}

	public void setGround(Drawable ground) {
		this.ground = ground;
	}

	public void clear() {
		elements = new LinkedList<>();
	}

	public void addDravableElement(Drawable e) {
		elements.add(e);
	}

	public void clearDrawableElements() {
		elements.clear();
	}
}

