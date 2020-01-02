package com.gmail.aspoka1.molecularphisic.math;

import java.awt.geom.Point2D;

public class Line {
    public double a;
    public double b;
    public double c;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Line(Point2D.Double p1, Point2D.Double p2) {
        a = p2.getY() - p1.getY();
        b = p1.getX() - p2.getX();
        c = -(a * p1.getX() + b * p1.getY());
    }

    public Line(Segment s) {
        this(s.getP1(), s.getP2());
    }

    public double distance(Point2D.Double p) {
        return Math.abs(a * p.getX() + b * p.getY() + c) / Math.sqrt(a * a + b * b);
    }

    public Line parallel(Point2D.Double p) {
        double c1 = -(a * p.getX() + b * p.getY());
        return new Line(a, b, c1);
    }

    public Line perpendicular(Point2D.Double p) {
        double c1 = a * p.getX() - b * p.getY();
        return new Line(-a, b, c);
    }

    public Point2D.Double intersection(Line l) {
        if((a == l.a) && (b == l.b)) {
            return null;
        }
        double w = a * l.b - l.a * b;
        double wx = l.c * b - c * l.b;
        double wy = c * l.a - l.c * a;
        double x = wx / w;
        double y = wy / w;
        return new Point2D.Double(x, y);
    }

    @Override
    public String toString() {
        return "Line{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
}
