package com.gmail.aspoka1.molecularphisic.phisic;

public interface Physic {
	double GRAVITATION_FORCE = 9.81;

	void calculateForce(double time);
	void calculateAcceleration(double time);
	void calculateVelocity(double time);
	void calculatePosition(double time);
}
