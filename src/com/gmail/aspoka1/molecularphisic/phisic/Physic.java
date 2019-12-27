package com.gmail.aspoka1.molecularphisic.phisic;

public interface Physic {
	double GRAVITATION_FORCE = 9.81;

	/**
	 * Calculate force attached to atom in this frame
	 * including forces from {@code addBinder(Binder binder)} and force of all binders.
	 * This function had to be used in all atoms before {@code calculateAcceleration(double time)}
	 *
	 * @param time passed from last frame
	 */
	void calculateForce(double time);
	/**
	 * Calculate acceleration in this frame
	 * This function had to be used in all atoms before {@code calculateVelocity(double time)}
	 *
	 * @param time passed from last frame
	 */
	void calculateAcceleration(double time);
	/**
	 * Calculate velocity in this frame
	 * This function had to be used only once in all atoms before {@code calculatePosition(double time)}
	 *
	 * @param time passed from last frame
	 */
	void calculateVelocity(double time);
	/**
	 * Calculate position in this frame
	 * This function had to be used only once in all atoms before {@code calculateCollision()}
	 *
	 * @param time passed from last frame
	 */
	void calculatePosition(double time);
	/**
	 * Calculate collisions and change position to avoid theme
	 * This function should be used only once per frame
	 */
	void calculateCollision();
}
