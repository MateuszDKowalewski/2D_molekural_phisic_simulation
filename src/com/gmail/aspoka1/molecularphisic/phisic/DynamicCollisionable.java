package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.geom.Point2D;

public interface DynamicCollisionable {
	public Point2D.Double getPosition();
	public Point2D.Double getLastPosition();
	public void setPosiotion(Point2D.Double p);
}
