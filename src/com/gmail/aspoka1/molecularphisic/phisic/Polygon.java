package com.gmail.aspoka1.molecularphisic.phisic;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;
import com.gmail.aspoka1.molecularphisic.math.Line;
import com.gmail.aspoka1.molecularphisic.math.Segment;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Polygon extends Path2D.Double implements StaticCollisional, Drawable {

    private final Point2D.Double[] points;
    private final Segment[] sides;
    private final Color color;



    public Polygon(Color color, Point2D.Double ... points) {
        this.points = points;
        this.color = color;
        moveTo(points[0].getX(), points[0].getY());
        for(int i = 1; i < points.length; i++) {
            lineTo(points[i].getX(), points[i].getY());
        }
        closePath();
        sides = new Segment[points.length];
        sides[0] = new Segment(points[points.length -1], points[0]);
        for(int i = 1; i < sides.length; i++) {
            sides[i] = new Segment(points[i - 1], points[i]);
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);
        g2d.fill(this);
    }

    @Override
    public boolean isColliding(Atom atom) {
        Line l = new Line(atom, new Point2D.Double(atom.x, atom.y + 1));
        int intersectionCounter = 0;
        for(Segment t : sides) {
            if(t.isIntersect(l)) {
                Point2D p = new Line(t).intersection(l);
                if(atom.getY() > p.getY()) {
                    intersectionCounter++;
                }
            }
        }
        if(intersectionCounter % 2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Point2D.Double calculateCollision(Atom a) {
        if(!isColliding(a)) {
            return null;
        }

        double distance = sides[3].distance(a);
        double currentDistance;
        Segment nearest = sides[3];

        for(Segment t : sides) {
            currentDistance = t.distance(a);
            if(currentDistance < distance) {
                distance = currentDistance;
                nearest = t;
            }
        }

        System.out.println(nearest);
        return nearest.findNearestTo(a);
    }
}
