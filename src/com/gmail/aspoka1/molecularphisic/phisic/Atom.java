package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;

/**
 * Basic class of atom
 * Point contain position, velocity, acceleration, force and its connected to list of it's binders
 * In each frame atom should be calculated in specified order:
 * add all forces -> calculateForce -> calculateAcceleration -> calculateVelocity -> calculatePosition
 * Each step of physics calculation had to be done for all atoms in simulation, then can be run next one
 *
 * @author aspoka
 * @version 2.0     27.12.2019
 */
public class Atom extends Point2D.Double implements Drawable, Physic {
    private static final long serialVersionUID = -367935700757882281L;

    public static final int DEFAULT_INITIAL_WEIGHT = 1;
    public static final double RESISTANCE_FORCE_SCALE = 0.1D;

    private static final int RADIUS = 2;
    private Point2D.Double lastPosition;
    private boolean simulatePhysic;

    private Point2D.Double velocity;
    private Point2D.Double acceleration;
    private Point2D.Double averageForce;
    private double weight;

    private List<Binder> binders;

    /**
     * Create atom with specified position and weight
     * Atom is without any binders, velocity, acceleration and force
     *
     * @param x position of atom
     * @param y position of atom
     * @param weight of atom
     */
    Atom(double x, double y, double weight) {
        super(x, y);
        this.weight = weight;
        this.setPhysicSimulation(true);
        this.lastPosition = new Point2D.Double(this.x, this.y);
        velocity = new Point2D.Double();
        acceleration = new Point2D.Double();
        averageForce = new Point2D.Double();
        binders = new LinkedList<>();
    }

    /**
     * Create atom with specified position and weight
     * Atom is without any binders, velocity, acceleration and force
     *
     * @param p position of atom
     * @param weight of atom
     */
    Atom(Point2D.Double p, double weight) {
        this(p.x, p.y, weight);
    }

    /**
     * Create atom with specified position and specific weight
     * Atom is without any binders, velocity, acceleration and force
     *
     * @param x position of atom
     * @param y position of atom
     */
    Atom(double x, double y) {
        this(x, y, DEFAULT_INITIAL_WEIGHT);
    }

    /**
     * Create atom with specified position and specific weight
     * Atom is without any binders, velocity, acceleration and force
     *
     * @param p position of atom
     */
    Atom(Point2D.Double p) {
        this(p.x, p.y, DEFAULT_INITIAL_WEIGHT);
    }

    /**
     * Add binder to atom
     * This binder had to have reference to this atom
     *
     * @param binder
     */
    void addBinder(Binder binder) {
        this.binders.add(binder);
    }

    /**
     * Adding force to atom
     * force is adding in only one frame
     *
     * @param force to add
     */
    void addForce(Point2D.Double force) {
        averageForce.x += force.x;
        averageForce.y += force.y;
    }

    /**
     * Calculate force attached to atom in this frame
     * including forces from {@code addBinder(Binder binder)} and force of all binders.
     * This function had to be used in all atoms before {@code calculateAcceleration(double time)}
     *
     * @param time passed from last frame
     */
    @Override
    public void calculateForce(double time) {
        if(simulatePhysic) {
            averageForce = new Point2D.Double();
            for (Binder t : binders) {
                this.addForce(t.calculateForce(this));
            }
            averageForce.y += Physic.GRAVITATION_FORCE * weight;

            averageForce.x -= velocity.x * RESISTANCE_FORCE_SCALE;
            averageForce.y -= velocity.y * RESISTANCE_FORCE_SCALE;
        }
    }

    /**
     * Calculate acceleration in this frame
     * This function had to be used in all atoms before {@code calculateVelocity(double time)}
     *
     * @param time passed from last frame
     */
    @Override
    public void calculateAcceleration(double time) {
        if(simulatePhysic) {
            acceleration.x = averageForce.x / weight;
            acceleration.y = averageForce.y / weight;
        }
    }

    /**
     * Calculate velocity in this frame
     * This function had to be used only once in all atoms before {@code calculatePosition(double time)}
     *
     * @param time passed from last frame
     */
    @Override
    public void calculateVelocity(double time) {
        if(simulatePhysic) {
            velocity.x += acceleration.x * time;
            velocity.y += acceleration.y * time;
        }
    }

    /**
     * Calculate position in this frame
     * This function had to be used only once in all atoms before {@code calculateCollision()}
     *
     * @param time passed from last frame
     */
    @Override
    public void calculatePosition(double time) {
        if(simulatePhysic) {
            lastPosition.x = this.x;
            lastPosition.y = this.y;
            x += velocity.x * time;
            y += velocity.y * time;
        }
    }

    /**
     * Calculate collisions and change position to avoid theme
     * This function should be used only once per frame
     * TODO: calculate collision with StaticCollisional objects
     */
    @Override
    public void calculateCollision() {
        if (this.y > 400) {
            this.y = 400;
            velocity.y = 0;
            acceleration.y = 0;
        }
    }

    // Graphic methods
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int) Math.round(x) - RADIUS, (int) Math.round(y) - RADIUS, 2 * RADIUS, 2 * RADIUS);
    }

    // Methods override from object
    @Override
    public String toString() {
        return super.toString() + averageForce.toString() + acceleration.toString() + velocity.toString();
    }

    // getters
    public Point2D.Double getVelocity() {
        return velocity;
    }
    public Point2D.Double getAcceleration() {
        return acceleration;
    }
    public double getWeight() {
        return weight;
    }
    public boolean isSimulatePhysic() {
        return simulatePhysic;
    }
    public Double getPosition() {
        return new Point2D.Double(x, y);
    }
    public Point2D.Double getLastPosition() {
        return lastPosition;
    }

    // setters
    public void setPhysicSimulation(boolean simulatePhysic) {
        this.simulatePhysic = simulatePhysic;
    }
}