package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

public class Ball implements Phisic, Drawable, Gravitation{
	private Atom preasure;
	private List<Atom> surface = new LinkedList<>();
	private List<Binder> binders = new LinkedList<>();
	
	public Ball(double x, double y, int atomsAmount, double radius) {
		preasure = new Atom(x, y);
		
		Point2D.Double temp = new Point2D.Double();
		for(int i = 0; i < atomsAmount; i++) {
			AffineTransform.getRotateInstance(Math.toRadians(360 / atomsAmount * i), x, y).transform(new Point2D.Double(x, y - radius), temp);
			surface.add(new Atom(temp));
		}
		
		Binder bind;
		for(Atom t : surface) {
			bind = new Binder(preasure, t);
			t.addBinder(bind);
			preasure.addBinder(bind);
			binders.add(bind);
		}
		
		for(int i = 0; i < surface.size() - 1; i++) {
			bind = new Binder(surface.get(i), surface.get(i + 1));
			surface.get(i).addBinder(bind);
			surface.get(i + 1).addBinder(bind);
			binders.add(bind);
		}
		
		bind = new Binder(surface.get(0), surface.get(surface.size() - 1));
		surface.get(0).addBinder(bind);
		surface.get(surface.size() - 1).addBinder(bind);
		binders.add(bind);
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
