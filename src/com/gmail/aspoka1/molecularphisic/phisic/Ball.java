package com.gmail.aspoka1.molecularphisic.phisic;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import com.gmail.aspoka1.molecularphisic.graphics.Drawable;
import com.gmail.aspoka1.molecularphisic.Main;

public class Ball implements Physic, Drawable, DynamicCollisionable{

	public static final int DEFAULT_INIT_ATOMS_AMOUNT = 20;
	public static final int DEFAULT_INIT_RADIUS = 100;
	public static final int DEFAULT_INIT_SURFACE_ATOM_WEIGHT = 1;
	public static final int DEFAULT_INIT_AIR_WEIGHT = 20;
	public static final int DEFAULT_INIT_SURFACE_ELASTICITY = 10;
	public static final int DEFAULT_INIT_AIR_PRESSURE = 30;


	private Atom centerAtom;
	private Atom[] surface;
	private Binder[] binders;

	private double startX;
	private double startY;
	private double radius;
	private double surfaceElasticy;
	private double preasure;

	/**
	 * Create ball with specific parameters
	 * @param x position of center
	 * @param y position of center
	 * @param atomsAmount on ball surface
	 * @param radius of the ball
	 * @param surfaceAtomWeight of each atom
	 * @param airWeight weight of atom in ball center
	 * @param surfaceElasticity elastics of binders between atoms on surface
	 * @param pressure elastics between air atom and each atom on surface
	 */
	public  Ball(double x, double y, int atomsAmount, double radius, double surfaceAtomWeight, double airWeight, double surfaceElasticity, double pressure) {
		this.startX = x;
		this.startY = y;
		this.radius = radius;
		this.surfaceElasticy = surfaceElasticity;
		this.preasure = pressure;

		centerAtom = new Atom(x, y, airWeight);

		surface = new Atom[atomsAmount];
		binders = new Binder[2 * atomsAmount];

		Point2D.Double temp = new Point2D.Double();
		for(int i = 0; i < atomsAmount; i++) {
			AffineTransform.getRotateInstance(Math.toRadians((double)360 / atomsAmount * i), x, y).transform(new Point2D.Double(x, y - radius), temp);
			surface[i] = new Atom(temp, surfaceAtomWeight);
		}

		Binder bind;
		for(int i = 0; i < atomsAmount; i++) {
			bind = new Binder(centerAtom, surface[i], pressure);
			binders[i] = bind;
		}

		for(int i = 0; i < atomsAmount - 1; i++) {
			bind = new Binder(surface[i], surface[i + 1], surfaceElasticity);
			binders[i + atomsAmount] = bind;
		}

		bind = new Binder(surface[0], surface[atomsAmount - 1], surfaceElasticity);
		binders[2 * atomsAmount - 1] = bind;
	}

	/**
	 * Create ball on specific position, with specific atom amounts and radius.
	 * Other values will be default
	 *
	 * @param x position of center
	 * @param y position of center
	 * @param atomsAmount amounts of atoms on surface
	 * @param radius of ball
	 */
	public Ball(double x, double y, int atomsAmount, double radius) {
		this(x, y, atomsAmount, radius, 1D, atomsAmount, 10D, 30D);
	}

	/**
	 * Create ball, with default parameters, on screen center
	 */
	public Ball() {
		this(Main.WIDTH / 2, Main.HEIGHT / 2 - 100, DEFAULT_INIT_ATOMS_AMOUNT, DEFAULT_INIT_RADIUS, DEFAULT_INIT_SURFACE_ATOM_WEIGHT, DEFAULT_INIT_AIR_WEIGHT, DEFAULT_INIT_SURFACE_ELASTICITY, DEFAULT_INIT_AIR_PRESSURE);
	}

	/**
	 * Calculate forces for all atoms in ball
	 * This function had to be used in all atoms before {@code calculateAcceleration(double time)}
	 *
	 * @param time passed from last frame
	 */
	@Override
	public void calculateForce(double time) {
		centerAtom.calculateForce(time);
		for(Atom a : surface) {
			a.calculateForce(time);
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
		centerAtom.calculateAcceleration(time);
		for(Atom a : surface) {
			a.calculateAcceleration(time);
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
		centerAtom.calculateVelocity(time);
		for(Atom a : surface) {
			a.calculateVelocity(time);
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
		centerAtom.calculatePosition(time);
		for(Atom a : surface) {
			a.calculatePosition(time);
		}
	}

	/**
	 * Calculate collisions and change position to avoid theme
	 * This function should be used only once per frame
	 */
	@Override
	public void calculateCollision() {
		for(Atom d : surface) {
			d.calculateCollision();
		}
	}

	// Graphic methods
	@Override
	public void paint(Graphics g) {
		for(Binder t : binders) {
			t.paint(g);
		}
		centerAtom.paint(g);
		for(Atom t : surface) {
			t.paint(g);
		}
	}
}
