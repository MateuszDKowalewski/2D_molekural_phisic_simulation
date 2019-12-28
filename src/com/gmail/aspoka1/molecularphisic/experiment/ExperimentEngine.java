package com.gmail.aspoka1.molecularphisic.experiment;

import com.gmail.aspoka1.molecularphisic.phisic.Ball;

public class ExperimentEngine {
    public static void main(String[] args) {
        int experimentAmount = 1;
        experimentAmount *= (Ball.MAX_AIR_PRESSURE - Ball.MIN_AIR_PRESSURE) / 5;
        experimentAmount *= (Ball.MAX_AIR_WEIGHT - Ball.MIN_AIR_WEIGHT) / 5;
        experimentAmount *= (Ball.MAX_SURFACE_ATOM_WEIGHT - Ball.MIN_SURFACE_ATOM_WEIGHT) / 5;
        experimentAmount *= (Ball.MAX_SURFACE_ELASTICITY - Ball.MIN_SURFACE_ELASTICITY) / 5;

        int experimentNumber = 1;

        for(int pressure = Ball.MIN_AIR_PRESSURE; pressure <= Ball.MAX_AIR_PRESSURE; pressure += 5) {
            for(int airWeight = Ball.MIN_AIR_WEIGHT; airWeight <= Ball.MAX_AIR_WEIGHT; airWeight += 5) {
                for(int atomWeight = Ball.MIN_SURFACE_ATOM_WEIGHT; atomWeight <= Ball.MAX_SURFACE_ATOM_WEIGHT; atomWeight += 5) {
                    for(int elasticity = Ball.MIN_SURFACE_ELASTICITY; elasticity <= Ball.MAX_SURFACE_ELASTICITY; elasticity += 5) {
                        Ball ball = new Ball(pressure, airWeight, atomWeight, elasticity);
                        Experiment e = new SimpleBallExperimentEngine(ball, 30);
                        e.run(1D / 60D);
                        System.out.println(experimentNumber + " of " + experimentAmount + ":" + e.returnResult() + ", pressure: " + pressure + ", airWeight: " + airWeight + ", atomWeight: " + atomWeight + ", elasticity: " + elasticity);
                        experimentNumber++;
                    }
                }
            }
        }
    }
}
