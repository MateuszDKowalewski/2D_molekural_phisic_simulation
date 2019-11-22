package com.gmail.aspoka1.molekyralphisic;

/**
 * 
 * @version 1.0
 * @author aspoka
 */
public class Binder {
	private Atom a1;
	private Atom a2;
	
	private double defaultLenght;
	
	public Binder(Atom a1, Atom a2) {
		this.a1 = a1;
		this.a2 = a2;
		a1.addBinder(this);
		a2.addBinder(this);
		this.defaultLenght = a1.distance(a2);
	}
	
	public Binder(Atom a1, Atom a2, double defaultLenght) {
		this.a1 = a1;
		this.a2 = a2;
		a1.addBinder(this);
		a2.addBinder(this);
		this.defaultLenght = defaultLenght;
	}

	// Getters
	public Atom getA1() { return a1; }
	public Atom getA2() { return a2; }
	public double getDefaultLenght() { return defaultLenght; }
}
