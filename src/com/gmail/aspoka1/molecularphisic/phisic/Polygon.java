package com.gmail.aspoka1.molecularphisic.phisic;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Polygon extends Path2D.Double implements StaticCollisional, Drawable {

    private final Point2D.Double[] points;
    private final Color color;



    public Polygon(Color color, Point2D.Double ... points) {
        this.points = points;
        this.color = color;
        moveTo(points[0].getX(), points[0].getY());
        for(int i = 1; i < points.length; i++) {
            lineTo(points[i].getX(), points[i].getY());
        }
        closePath();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);
        g2d.fill(this);
    }

    @Override
    public boolean isColliding(Atom atom) {
        return false;
    }

    @Override
    public Point2D.Double calculateCollision(Atom a) {
        return null;
    }
}
