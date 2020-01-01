package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.geom.Point2D;

/**
 * Dummy interface for static blocks which can collide with Atom
 */
public interface StaticCollisional {
    boolean isColliding(Atom atom);
    Point2D.Double calculateCollision(Atom a);
}