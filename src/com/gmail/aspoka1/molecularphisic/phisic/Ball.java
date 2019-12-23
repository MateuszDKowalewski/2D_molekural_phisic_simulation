package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

public class Ball implements Phisic, Drawable, DynamicCollisionable{
	
	private Atom preasure;
	private Atom[] surface;
	private Binder[] binders;
	
	public Ball(double x, double y, int atomsAmount, double radius) {
		preasure = new Atom(x, y, 50.0);
		
		surface = new Atom[atomsAmount];
		binders = new Binder[2 * atomsAmount];
		
		Point2D.Double temp = new Point2D.Double();
		for(int i = 0; i < atomsAmount; i++) {
			AffineTransform.getRotateInstance(Math.toRadians(360 / atomsAmount * i), x, y).transform(new Point2D.Double(x, y - radius), temp);
			surface[i] = new Atom(temp, 1.0);
		}
		
		Binder bind;
		for(int i = 0; i < atomsAmount; i++) {
			bind = new Binder(preasure, surface[i], 100.0);
			binders[i] = bind;
		}
		
		for(int i = 0; i < atomsAmount - 1; i++) {
			bind = new Binder(surface[i], surface[i + 1], 100.0);
			binders[i + atomsAmount] = bind;
		}
		
		bind = new Binder(surface[0], surface[atomsAmount - 1], 100.0);
		binders[2 * atomsAmount - 1] = bind;
	}

	@Override
	public void calculeForce(double time) {
		preasure.calculeForce(time);
		for(Atom a : surface) {
			a.calculeForce(time);
		}
	}

	@Override
	public void calculeAcceleration(double time) {
		preasure.calculeAcceleration(time);
		for(Atom a : surface) {
			a.calculeAcceleration(time);
		}
	}

	@Override
	public void calculeVelocity(double time) {
		preasure.calculeVelocity(time);
		for(Atom a : surface) {
			a.calculeVelocity(time);
		}
	}

	@Override
	public void calculePosition(double time) {
		preasure.calculePosition(time);
		for(Atom a : surface) {
			a.calculePosition(time);
		}
	}

	@Override
	public void print() {
		// TODO: write print
	}

	@Override
	public void paint(Graphics g) {
		for(Binder t : binders) {
			t.paint(g);
		}
		preasure.paint(g);
		for(Atom t : surface) {
			t.paint(g);
		}
	}

	@Override
	public void calculeCollision() {
		for(Atom d : surface) {
			d.calculeCollision();
			/*if(s.isInCollision(d.getPosition())) {
				d.setPosiotion(s.calculeIntersection(d.getPosition(), d.getLastPosition()));
			}*/
		}
	}
	
}
