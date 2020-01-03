package com.gmail.aspoka1.molecularphisic.math;

import java.awt.geom.Point2D;

public class MathTests {
    public static void main(String[] args) {
        Segment s = new Segment(new Point2D.Double(0, 400), new Point2D.Double(320, 440));
        System.out.println(new Line(s));
        System.out.println(new Line(s).perpendicular(new Point2D.Double(320, 440)));

        //Point2D.Double p = new Point2D.Double(318, 440);

    }
}
