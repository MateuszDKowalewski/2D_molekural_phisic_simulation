package com.gmail.aspoka1.molecularphisic.graphics;

import java.util.LinkedList;
import java.util.List;

import com.gmail.aspoka1.molecularphisic.phisic.Phisic;

public class GameContainer implements Runnable {
	private Thread thread;
	private Panel c;
	
	private boolean running = false;
	private final double UPDATE_CUP = 1.0 / 60.0;
	
	List<Phisic> toSimulate = new LinkedList<>();
	
	public GameContainer(Panel c) {
		this.c = c;
	}
	
	public void addPhisicComponent(Phisic component) {
		toSimulate.add(component);
	}
	
	public void start() {
		thread = new Thread(this);
		thread.run();
	}
	
	public void stop() {
		
	}
	
	public void run() {
		running = true;
		
		boolean render = false;
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		
		double frameTime = 0;
		int frames = 0;
		@SuppressWarnings("unused")
		int fps = 0;
		
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
				// TODO: update game
				for(Phisic t : toSimulate) {
					t.calculePhisic(UPDATE_CUP);
				}
				
				
				if(frameTime >= 1.0) {
					frameTime = 0;
					fps = frames;
					frames = 0;
					//System.out.println("FPS: " + fps);
				}
			}
			
			if(render) {
				frames++;
				// TODO: render game
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
	
	private void dispose() {
		
	}

}
