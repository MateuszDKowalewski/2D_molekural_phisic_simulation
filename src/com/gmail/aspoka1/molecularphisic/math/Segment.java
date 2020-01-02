package com.gmail.aspoka1.molecularphisic.math;

import java.awt.geom.Point2D;

public class Segment {
    Point2D.Double p1;
    Point2D.Double p2;

    public Segment(Point2D.Double p1, Point2D.Double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point2D.Double getP1() {
        return p1;
    }

    public Point2D.Double getP2() {
        return p2;
    }

    public double getLength() {
        return p1.distance(p2);
    }

    public double distance(Point2D.Double p) {
        Line l = new Line(this);
        Point2D.Double q = l.intersection(l.perpendicular(p));
        if(((p1.x <= p.x) && (p.x <= p2.x)) || ((p2.x <= p.x) && (p.x <= p1.x))) {
            return l.distance(p);
        } else {
            return (p.distance(p1) < p.distance(p2)) ? p.distance(p1) : p.distance(p2);
        }
    }

    public Point2D.Double findNearestTo(Point2D.Double p) {
        Line l = new Line(this);
        Point2D.Double q = l.intersection(l.perpendicular(p));
        if(((p1.x <= p.x) && (p.x <= p2.x)) || ((p2.x <= p.x) && (p.x <= p1.x))) {
            return q;
        } else {
            return (p.distance(p1) < p.distance(p2)) ? p1 : p2;
        }
    }

    public boolean isIntersect(Line l) {
        Point2D.Double p = l.intersection(new Line(this));
        if(p == null) {
            return false;
        }

        if(((p1.x < p.x) && (p.x < p2.x)) || ((p2.x < p.x) && (p.x < p1.x))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Segment{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
