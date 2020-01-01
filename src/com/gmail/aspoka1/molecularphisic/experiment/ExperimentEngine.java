package com.gmail.aspoka1.molecularphisic.experiment;

import com.gmail.aspoka1.molecularphisic.phisic.Ball;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExperimentEngine {
    public static void main(String[] args) {
        int experimentNumber = 1;

        try {
            String content = "TutorialsPoint is one the best site in the world";
            File file = new File("Results\\E8Result.txt");
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("Atom amount:" + Ball.DEFAULT_INIT_ATOMS_AMOUNT + " Radius:" + Ball.DEFAULT_INIT_RADIUS + "\n");

                int atomWeight = 1;

                long start = System.currentTimeMillis();
                for(int pressure = Ball.MIN_AIR_PRESSURE; pressure <= Ball.MAX_AIR_PRESSURE; pressure += 1) {
                    for(int airWeight = Ball.MIN_AIR_WEIGHT; airWeight <= Ball.MAX_AIR_WEIGHT; airWeight += 1) {
                        for(int elasticity = Ball.MIN_SURFACE_ELASTICITY; elasticity <= Ball.MAX_SURFACE_ELASTICITY; elasticity += 1) {
                            Ball ball = new Ball(pressure, airWeight, atomWeight, elasticity);
                            Experiment e = new SimpleBallExperimentEngine(ball, 30);
                            e.run(1D / 60D);
                            bw.write(experimentNumber + " result:" + e.returnResult() + " pressure:" + pressure + " airWeight:" + airWeight + " atomWeight:" + atomWeight + " elasticity:" + elasticity + "\n");
                            //System.out.println(experimentNumber);
                            experimentNumber++;
                        }
                    }
                    System.out.println((double)pressure / (Ball.MAX_AIR_PRESSURE - Ball.MIN_AIR_PRESSURE) + "%");
                }
                long finish = System.currentTimeMillis();
                long timeElapsed = (finish - start) / 1000;
                bw.write("Time: " + timeElapsed);
                System.out.println("Time: " + timeElapsed);

                bw.close();
            } else {
                System.out.println("Experiment exist");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
