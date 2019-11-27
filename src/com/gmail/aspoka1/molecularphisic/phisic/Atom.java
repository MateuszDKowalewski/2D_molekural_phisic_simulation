package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

/**
 * Basic class of atom
 * Point contain position, velocity, acceleration, force and its connected to list of it's binders
 * TODO can be display
 * TODO simulate phisic
 * 
 * @version 1.0
 * @author aspoka
 */
public class Atom extends Point2D.Double implements Gravitation, Drawable, Phisic{
	private static final long serialVersionUID = -367935700757882281L;

	private static final int radius = 2;
	
	private Point2D.Double velocity;
	private Point2D.Double acceleration;
	private Point2D.Double avergeForce;
	
	private List<Binder> binder = new LinkedList<>();
	
	public Atom(Point2D.Double p) {
		super(p.x, p.y);
	}
	
	/**
	 * Create atom without any binders, velocity, acceleration and force
	 * @param x position of atom
	 * @param y position of atom
	 */
	public Atom(double x, double y) {
		super(x, y);
	}
	
	/**
	 * Create atom with specified binders
	 * It's useless because point and it's binders had to have reference to each other
	 * @param x position of atom
	 * @param y position of atom
	 * @param binders list of binder attached to this point
	 */
	public Atom(double x, double y, Binder ... binders) {
		super(x, y);
		for(Binder t : binders) {
			this.binder.add(t);
		}
	}
	
	/**
	 * Add binder to atom
	 * This binder had to have reference to this atom
	 * @param binder
	 */
	public void addBinder(Binder binder) {
		this.binder.add(binder);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int)Math.round(x) - radius, (int)Math.round(y) - radius, 2 * radius, 2 * radius);
		
		
	}

	@Override
	public void calculePhisic(double time) {
		// TODO Auto-generated method stub
		
	}
	
	// Getters
	public Point2D.Double getVelocity() { return velocity; }
	public Point2D.Double getAvergeForce() { return avergeForce; }
	public Point2D.Double getAcceleration() { return acceleration; }
	
}
