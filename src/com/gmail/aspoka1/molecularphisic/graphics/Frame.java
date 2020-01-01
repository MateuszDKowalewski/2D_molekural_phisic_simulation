package com.gmail.aspoka1.molecularphisic.graphics;

import com.gmail.aspoka1.molecularphisic.Main;
import com.gmail.aspoka1.molecularphisic.phisic.Ball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;


public class Frame extends JFrame {
	private static final long serialVersionUID = 801486476992470583L;

	private GenerateBallPanel gbp;
	private Panel c;
	
	public Frame(GameContainer gc) {
		super();
		setTitle(Main.NAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = new Panel(Main.WIDTH, GenerateBallPanel.WIDTH, Main.HEIGHT);
		add(c);
		setResizable(false);
		setVisible(true);
		pack();

		gbp = new GenerateBallPanel(c, this, gc);
	}

	public void clear() {
		c.clear();
	}
	
	public void addDrawableElement (Drawable e) {
		c.addDrawableElement(e);
	}

	public void setBall(Ball ball) {
		c.setBall(ball);
	}
	
	// getters
	public Panel getCanvas() { return c; }
}

class Panel extends JPanel {
	private static final long serialVersionUID = -6832117658886512528L;

	Ball ball;
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

		//ground.paint(g);

		if(ball != null) {
			ball.paint(g);
		}
		for(Drawable e : elements) {
			e.paint(g);
		}
	}

	public void clear() {
		elements = new LinkedList<>();
	}

	public void addDrawableElement(Drawable e) {
		elements.add(e);
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}
}

