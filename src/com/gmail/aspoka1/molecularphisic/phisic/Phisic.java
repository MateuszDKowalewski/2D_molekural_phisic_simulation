package com.gmail.aspoka1.molecularphisic.phisic;

public interface Phisic {
	public final static double GRAVITATION_FORCE = 9.81;

	public void calculeForce(double time);
	public void calculeAcceleration(double time);
	public void calculeVelocity(double time);
	public void calculePosition(double time);


	public void print();
}
