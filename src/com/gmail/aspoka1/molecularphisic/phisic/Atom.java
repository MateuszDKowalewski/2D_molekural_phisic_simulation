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
 * TODO can be display
 * TODO simulate phisic
 * 
 * @version 1.0
 * @author aspoka
 */
public class Atom extends Point2D.Double implements Drawable, Phisic, DynamicCollisionable{
	private static final long serialVersionUID = -367935700757882281L;

	private boolean simulatePhisic;
	
	private Point2D.Double velocity = new Point2D.Double();
	private Point2D.Double acceleration = new Point2D.Double();
	private Point2D.Double avergeForce = new Point2D.Double();
	
	private Point2D.Double lastPosition;
	
	private static final int radius = 2;
	private double weight;
	
	private List<Binder> binders = new LinkedList<>();
	
	public Atom(Point2D.Double p, double weight) {
		super(p.x, p.y);
		this.weight = weight;
		this.setPhisicSimulation(true);
		this.lastPosition = new Point2D.Double(this.x, this.y);
	}
	
	/**
	 * Create atom without any binders, velocity, acceleration and force
	 * @param x position of atom
	 * @param y position of atom
	 */
	public Atom(double x, double y, double weight) {
		super(x, y);
		this.weight = weight;
		this.setPhisicSimulation(true);
		this.lastPosition = new Point2D.Double(this.x, this.y);
	}
	
	/**
	 * Create atom with specified binders
	 * It's useless because point and it's binders had to have reference to each other
	 * @param x position of atom
	 * @param y position of atom
	 * @param binders list of binder attached to this point
	 */
	public Atom(double x, double y, double weight, Binder ... binders) {
		super(x, y);
		this.weight = weight;
		for(Binder t : binders) {
			this.binders.add(t);
		}
		this.setPhisicSimulation(true);
		this.lastPosition = new Point2D.Double(this.x, this.y);
	}
	
	/**
	 * Add binder to atom
	 * This binder had to have reference to this atom
	 * @param binder
	 */
	public void addBinder(Binder binder) {
		this.binders.add(binder);
	}
	
	public void addForce(Point2D.Double force) {
		avergeForce.x += force.x;
		avergeForce.y += force.y;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int)Math.round(x) - radius, (int)Math.round(y) - radius, 2 * radius, 2 * radius);
		
		
	}

	@Override
	public void calculePhisic(double time) {
		if(simulatePhisic) {
			lastPosition.x = this.x;
			lastPosition.y = this.y;
			
			for(Binder t : binders) {
				this.addForce(t.calculeForce(this));
			}

			//System.out.println(this);
			
			avergeForce.y += Phisic.GRAVITATION_FORCE * weight;

			acceleration.x = avergeForce.x / weight;
			acceleration.y = avergeForce.y / weight;
			
			velocity.x += acceleration.x * time;
			velocity.y += acceleration.y * time;
			
			x += velocity.x * time;
			y += velocity.y * time;
			
			avergeForce = new Point2D.Double();
		}
	}
	
	@Override
	public void calculeCollision(StaticCollisionable s) {
		if(s.isInCollision(getPosition())) {
			setPosiotion(s.calculeIntersection(getPosition(), getLastPosition()));
		}
	}
	
	public String toString() {
		return super.toString() + avergeForce.toString() + acceleration.toString() + velocity.toString();
	}
	
	// getters
	public Point2D.Double getVelocity() { return velocity; }
	public Point2D.Double getAvergeForce() { return new Point2D.Double(avergeForce.x + Phisic.GRAVITATION_FORCE, avergeForce.y); }
	public Point2D.Double getAcceleration() { return acceleration; }
	public double getWeight() { return weight; }
	public boolean isSimulatePhisic() { return simulatePhisic; }
	public Double getPosition() { return new Point2D.Double(x, y); }
	public Point2D.Double getLastPosition() { return lastPosition; }
	
	// setters
	public void setPhisicSimulation(boolean simulatePhisic) { this.simulatePhisic = simulatePhisic; }
	public void setPosiotion(Double p) { this.x = p.x; this.y = p.y; }
	
}
