package com.gmail.aspoka1.molecularphisic.graphics;

import java.util.LinkedList;
import java.util.List;

import com.gmail.aspoka1.molecularphisic.phisic.Ball;
import com.gmail.aspoka1.molecularphisic.phisic.Physic;
import com.gmail.aspoka1.molecularphisic.phisic.StaticCollisional;

public class GameContainer implements Runnable {
	private Thread thread;
	private Panel c;

	private boolean running = false;
	private final double UPDATE_CUP = 1.0 / 60.0;

	Ball toSimulate = null;
	List<StaticCollisional> staticCollisionalsBlock = new LinkedList<>();

	public GameContainer() {
		thread = new Thread(this);
	}

	@Override
	public void run() {
		boolean render;
		double firstTime;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime;
		double unprocessedTime = 0;

		double frameTime = 0;
		int frames = 0;
		@SuppressWarnings("unused")
		int fps = 0;

		running = true;

		while(running) {
			render = false;

			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;

			unprocessedTime += passedTime;
			frameTime += passedTime;

			while(unprocessedTime >= UPDATE_CUP) {
				unprocessedTime -= UPDATE_CUP;
				render = true;
				if(toSimulate != null) {
					toSimulate.calculateForce(UPDATE_CUP);
					toSimulate.calculateAcceleration(UPDATE_CUP);
					toSimulate.calculateVelocity(UPDATE_CUP);
					toSimulate.calculatePosition(UPDATE_CUP);
					toSimulate.calculateCollision();
				}
				/*
				for(Physic t : toSimulate) {
					t.calculateForce(UPDATE_CUP);
				}
				for(Physic t : toSimulate) {
					t.calculateAcceleration(UPDATE_CUP);
				}
				for(Physic t : toSimulate) {
					t.calculateVelocity(UPDATE_CUP);
				}
				for(Physic t : toSimulate) {
					t.calculatePosition(UPDATE_CUP);
				}
				for(Physic d : toSimulate) {
					d.calculateCollision();
				}
				*/
				if(frameTime >= 1.0) {
					frameTime = 0;
					fps = frames;
					frames = 0;
					//System.out.println("FPS: " + fps);
				}
			}

			if(render) {
				frames++;
				c.repaint();
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		dispose();
	}

	public void start() {
		running = true;
	}

	public void stop() {
		running = false;
	}

	private void dispose() {

	}

	public void setPanel(Panel c) {
		this.c = c;
	}

	public void setBall(Ball ball) {
		toSimulate = ball;
	}

	/*
	public void addPhysicComponent(Physic component) {
		toSimulate.add(component);
	}
	*/

	public void addStaticCollisionalComponent(StaticCollisional component) {
		staticCollisionalsBlock.add(component);
	}
}