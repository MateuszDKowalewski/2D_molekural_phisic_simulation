package com.gmail.aspoka1.molecularphisic;

public class ThreadController {
    private boolean running;

    public  ThreadController() {
        running = true;
    }

    public boolean canRun() {
        return running;
    }

    public void turnOn() {
        running = true;
    }

    public void turnOff() {
        running = false;
    }
}
