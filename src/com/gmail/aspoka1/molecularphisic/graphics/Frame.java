package com.gmail.aspoka1.molecularphisic.graphics;

import com.gmail.aspoka1.molecularphisic.Main;

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

	// TODO: add collision with static block and remove it
	public void setGround(Drawable ground) {
		c.setGround(ground);
	}
	
	public void addDrawableElement (Drawable e) {
		c.addDrawableElement(e);
	}
	
	// getters
	public Panel getCanvas() { return c; }
}

class Panel extends JPanel {
	private static final long serialVersionUID = -6832117658886512528L;

	Drawable ground; // TODO: delete
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

	public void addDrawableElement(Drawable e) {
		elements.add(e);
	}
}

