package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

/**
 * Dummy collision block
 * it can only by display for now
 * TODO: add interaction with atoms
 *
 * @author aspoka
 * @version 1.0     27.12.2019
 */
public class CollisionBlock extends Rectangle2D.Double implements StaticCollisional, Drawable {
    private static final long serialVersionUID = 7326746329680438003L;

    private static final Color DEFAULT_COLOR = Color.GREEN;
    Color color;

    /**
     * Create collision block with specific position, dimensions and color
     * @param x of top left corner
     * @param y of top left corner
     * @param width of block
     * @param height of block
     * @param color of block
     */
    public CollisionBlock(double x, double y, double width, double height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    /**
     * Create collision block with specific position, dimensions and default color
     * @param x of top left corner
     * @param y of top left corner
     * @param width of block
     * @param height of block
     */
    public CollisionBlock(double x, double y, double width, double height) {
        this(x, y, width, height, DEFAULT_COLOR);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
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