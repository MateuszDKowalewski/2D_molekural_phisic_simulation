package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;


/**
 * 
 * @version 1.0
 * @author aspoka
 */
public class Binder implements Drawable{
	private Atom a1;
	private Atom a2;
	
	private double k;
	
	private double defaultLenght;
	
	public Binder(Atom a1, Atom a2) {
		this.a1 = a1;
		this.a2 = a2;
		a1.addBinder(this);
		a2.addBinder(this);
		this.defaultLenght = a1.distance(a2);
		this.k = 1;
	}
	
	public Binder(Atom a1, Atom a2, double k) {
		this.a1 = a1;
		this.a2 = a2;
		a1.addBinder(this);
		a2.addBinder(this);
		this.defaultLenght = a1.distance(a2);
		this.k = k;
	}
	
	public Point2D.Double calculeForce(Atom a) {
		Point2D.Double force;
		double xForce;
		double yForce;
		
		double length = a1.distance(a2);
		double lengthDelta = length - defaultLenght;
		double forceLength = k * lengthDelta;
		
		xForce = (a2.x - a1.x) / defaultLenght * forceLength;
		yForce = (a2.y - a1.y) / defaultLenght * forceLength;
		
		if(a == a1) {
			force = new Point2D.Double(xForce, yForce);
		} else {
			force = new Point2D.Double(-xForce, -yForce);
		}
		return force;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawLine((int)a1.getX(), (int)a1.getY(), (int)a2.getX(), (int)a2.getY());
	}
	
	// Getters
	public Atom getA1() { return a1; }
	public Atom getA2() { return a2; }
	public double getDefaultLenght() { return defaultLenght; }

}
