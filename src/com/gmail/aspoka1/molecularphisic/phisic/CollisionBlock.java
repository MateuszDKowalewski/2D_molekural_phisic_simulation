package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

public class CollisionBlock extends Rectangle2D.Double implements StaticCollisionable, Drawable{
	private static final long serialVersionUID = 7326746329680438003L;

	public CollisionBlock(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	@Override
	public boolean isInCollision(Point2D.Double p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point2D.Double calculeIntersection(Point2D.Double p1, Point2D.Double p2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

}
