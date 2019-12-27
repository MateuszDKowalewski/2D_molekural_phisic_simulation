package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;
import com.gmail.aspoka1.molecularphisic.Main;

public class Ball implements Phisic, Drawable, DynamicCollisionable{
	
	private Atom centerAtom;
	private Atom[] surface;
	private Binder[] binders;

	private double startX;
	private double startY;
	private double radius;
	private double surfaceElasticy;
	private double preasure;

	public  Ball(double x, double y, int atomsAmount, double radius, double surfaceAtomWeight, double centerAtomWeight, double surfaceElasticy, double preasure) {
		this.startX = x;
		this.startY = y;
		this.radius = radius;
		this.surfaceElasticy = surfaceElasticy;
		this.preasure = preasure;

		centerAtom = new Atom(x, y, centerAtomWeight);

		surface = new Atom[atomsAmount];
		binders = new Binder[2 * atomsAmount];

		Point2D.Double temp = new Point2D.Double();
		for(int i = 0; i < atomsAmount; i++) {
			AffineTransform.getRotateInstance(Math.toRadians(360 / atomsAmount * i), x, y).transform(new Point2D.Double(x, y - radius), temp);
			surface[i] = new Atom(temp, surfaceAtomWeight);
		}

		Binder bind;
		for(int i = 0; i < atomsAmount; i++) {
			bind = new Binder(centerAtom, surface[i], preasure);
			binders[i] = bind;
		}

		for(int i = 0; i < atomsAmount - 1; i++) {
			bind = new Binder(surface[i], surface[i + 1], surfaceElasticy);
			binders[i + atomsAmount] = bind;
		}

		bind = new Binder(surface[0], surface[atomsAmount - 1], surfaceElasticy);
		binders[2 * atomsAmount - 1] = bind;
	}

	public Ball(double x, double y, int atomsAmount, double radius) {
		this(x, y, atomsAmount, radius, 1D, atomsAmount, 10D, 30D);
	}

	public Ball() {
		this(Main.WIDTH / 2, Main.HEIGHT / 2 - 100, 20, 100, 1D, 20D, 10D, 30D);
	}

	@Override
	public void calculeForce(double time) {
		centerAtom.calculeForce(time);
		for(Atom a : surface) {
			a.calculeForce(time);
		}
	}

	@Override
	public void calculeAcceleration(double time) {
		centerAtom.calculeAcceleration(time);
		for(Atom a : surface) {
			a.calculeAcceleration(time);
		}
	}

	@Override
	public void calculeVelocity(double time) {
		centerAtom.calculeVelocity(time);
		for(Atom a : surface) {
			a.calculeVelocity(time);
		}
	}

	@Override
	public void calculePosition(double time) {
		centerAtom.calculePosition(time);
		for(Atom a : surface) {
			a.calculePosition(time);
		}
	}

	@Override
	public void paint(Graphics g) {
		for(Binder t : binders) {
			t.paint(g);
		}
		centerAtom.paint(g);
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

	public Ball clone() {
		return new Ball(startX, startY, surface.length, radius, surface[0].getWeight(), centerAtom.getWeight(), surfaceElasticy, preasure);
	}
}
