package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

public class Ball implements Phisic, Drawable{
	
	private Atom preasure;
	private Atom[] surface;
	private Binder[] binders;
	
	public Ball(double x, double y, int atomsAmount, double radius) {
		preasure = new Atom(x, y, atomsAmount);
		
		surface = new Atom[atomsAmount];
		binders = new Binder[2 * atomsAmount];
		
		Point2D.Double temp = new Point2D.Double();
		for(int i = 0; i < atomsAmount; i++) {
			AffineTransform.getRotateInstance(Math.toRadians(360 / atomsAmount * i), x, y).transform(new Point2D.Double(x, y - radius), temp);
			surface[i] = new Atom(temp, 1.0);
		}
		
		Binder bind;
		for(int i = 0; i < atomsAmount; i++) {
			bind = new Binder(preasure, surface[i]);
			surface[i].addBinder(bind);
			preasure.addBinder(bind);
			binders[i] =bind;
		}
		
		for(int i = 0; i < atomsAmount - 1; i++) {
			bind = new Binder(surface[i], surface[i + 1]);
			surface[i].addBinder(bind);
			surface[i + 1].addBinder(bind);
			binders[i + atomsAmount] = bind;
		}
		
		bind = new Binder(surface[0], surface[atomsAmount - 1]);
		surface[0].addBinder(bind);
		surface[atomsAmount - 1].addBinder(bind);
		binders[2 * atomsAmount - 1] = bind;
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
	public void calculePhisic(double time) {
		// TODO Auto-generated method stub
		
	}
	
}
