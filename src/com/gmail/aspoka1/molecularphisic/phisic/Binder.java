package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;


/**
 * Binder is physic connection between two atoms
 * It has default length and like spring push atom when they are too close to each other
 * and pull when they are too fare
 * To create binder it's necessary to indicate atoms to bind
 * distance between this atoms will be default binder length
 *
 * @author aspoka
 * @version 2.0     27.12.2019
 */
public class Binder implements Drawable{
	public static final int DEFAULT_INIT_ELASTICITY = 1;

	private Atom a1;
	private Atom a2;
	
	private double defaultLength;
	private double k;

	/**
	 * Create binder for two atoms with given elasticity factor
	 *
	 * @param a1 first atom
	 * @param a2 second atom
	 * @param k elasticity factor
	 */
	public Binder(Atom a1, Atom a2, double k) {
		this.a1 = a1;
		this.a2 = a2;
		a1.addBinder(this);
		a2.addBinder(this);
		this.defaultLength = a1.distance(a2);
		this.k = k;
	}

	/**
	 * Create binder for two atoms with given default factor
	 *
	 * @param a1 first atom
	 * @param a2 second atom
	 */
	public Binder(Atom a1, Atom a2) {
		this(a1, a2, DEFAULT_INIT_ELASTICITY);
	}

	/**
	 * Calculate force given by this binder to atom
	 *
	 * @param a atom to calculate
	 * @return force attached to {@code a}, 0 if this binder are not connect to {@code a}
	 */
	public Point2D.Double calculateForce(Atom a) {
		Point2D.Double force;
		double xForce;
		double yForce;
		
		double length = a1.distance(a2);
		double lengthDelta = length - defaultLength;
		double forceLength = k * lengthDelta;
		
		xForce = (a2.x - a1.x) / defaultLength * forceLength;
		yForce = (a2.y - a1.y) / defaultLength * forceLength;
		
		if(a == a1) {
			force = new Point2D.Double(xForce, yForce);
		} else if (a == a2){
			force = new Point2D.Double(-xForce, -yForce);
		} else {
			force = new Point2D.Double(0, 0);
		}
		return force;
	}

	// Graphic methods
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawLine((int)a1.getX(), (int)a1.getY(), (int)a2.getX(), (int)a2.getY());
	}
	
	// Getters
	public Atom getA1() {
		return a1;
	}
	public Atom getA2() {
		return a2;
	}
	public double getDefaultLength() {
		return defaultLength;
	}

}
