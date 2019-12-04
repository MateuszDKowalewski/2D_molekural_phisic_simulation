package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

public class CollisionBlock extends Rectangle2D.Double implements StaticCollisionable, Drawable {
	private static final long serialVersionUID = 7326746329680438003L;

	public CollisionBlock(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public boolean isInCollision(Point2D.Double p) {
		if ((x < p.x) && (p.x < x + width) && (y < p.y) && (p.y < y + height)) {
			return true;
		}
		return false;
	}

	/**
	 * @param p1 inner point
	 * @param p2 outer point
	 */
	public Point2D.Double calculeIntersection(Point2D.Double p1, Point2D.Double p2) {
		if(isSegmentCrossed(p1, p2, new Point2D.Double(x, y), new Point2D.Double(x + width, y))) {
			return whereLineCrossed(p1, p2, new Point2D.Double(x, y), new Point2D.Double(x + width, y));
		} else if(isSegmentCrossed(p1, p2, new Point2D.Double(x, y), new Point2D.Double(x, y + height))) {
			return whereLineCrossed(p1, p2, new Point2D.Double(x, y), new Point2D.Double(x, y + height));
		} else if(isSegmentCrossed(p1, p2, new Point2D.Double(x + width, y + height), new Point2D.Double(x + width, y))) {
			return whereLineCrossed(p1, p2, new Point2D.Double(x + width, y + height), new Point2D.Double(x + width, y));
		} else if(isSegmentCrossed(p1, p2, new Point2D.Double(x + width, y + height), new Point2D.Double(x, y + height))) {
			return whereLineCrossed(p1, p2, new Point2D.Double(x + width, y + height), new Point2D.Double(x, y + height));
		} 

		return null;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int) x, (int) y, (int) width, (int) height);
	}

	private boolean isSegmentCrossed(Point2D.Double p, Point2D.Double q, Point2D.Double r, Point2D.Double s) {
		int o1 = orientation(p, r, q);
		int o2 = orientation(p, r, s);
		int o3 = orientation(q, s, p);
		int o4 = orientation(q, s, r);

		if (o1 != o2 && o3 != o4)
			return true;

		// TODO: Is this needless?
		/*
		if (o1 == 0 && onSegment(p, q, r))
			return true;

		if (o2 == 0 && onSegment(p, s, r))
			return true;

		if (o3 == 0 && onSegment(q, p, s))
			return true;

		if (o4 == 0 && onSegment(q, r, s))
			return true;
		*/

		return false;
	}

	static int orientation(Point2D.Double p, Point2D.Double q, Point2D.Double r) {
		double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val == 0)
			return 0; // colinear

		return (val > 0) ? 1 : 2; // clock or counter clock wise
	}

	private Point2D.Double whereLineCrossed(Point2D.Double p, Point2D.Double q, Point2D.Double r, Point2D.Double s) {
		Point2D.Double u;
		// Point2D.Double v;
		double a;
		//double b;
		double W;
		double Wa;
		// double Wb;

		u = new Point2D.Double(q.x - p.x, q.y - p.y);
		// v = new Point2D.Double(s.x - r.x, s.y - r.y);

		W = (q.x - p.x) * (r.y - s.y) - (r.x - s.x) * (q.y - p.y);
		Wa = (r.x - p.x) * (r.y - s.y) - (r.x - s.x) * (r.y - p.y);
		// Wb = (q.x - p.x) * (r.y - p.y) - (r.x - p.x) * (q.y - p.y);

		a = Wa / W;
		// b = Wb / W;

		return new Point2D.Double(p.x + a * u.getX(), p.y + a * u.getY());
	}

}
