package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.geom.Point2D;

public interface StaticCollisionable {
	public boolean isInCollision(Point2D.Double p);
	public Point2D.Double calculeIntersection(Point2D.Double p1, Point2D.Double p2);
}
