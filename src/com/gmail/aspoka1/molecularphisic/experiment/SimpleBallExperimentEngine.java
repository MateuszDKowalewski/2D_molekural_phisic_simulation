package com.gmail.aspoka1.molecularphisic.experiment;

import com.gmail.aspoka1.molecularphisic.phisic.Ball;

class SimpleBallExperimentEngine implements Experiment{
    Ball ball;

    double passedTime;
    double targetTime;

    double currentBallY;
    double lastBallY;

    double maxHeight;

    SimpleBallExperimentEngine(Ball ball, double simulationTime){
        this.ball = ball;
        this.targetTime = simulationTime;
        this.passedTime = 0;
        this.maxHeight = Double.MAX_EXPONENT;
    }

    @Override
    public void run(double deltaTime) {
        while(passedTime < targetTime) {
            ball.calculateForce(deltaTime);
            ball.calculateAcceleration(deltaTime);
            ball.calculateVelocity(deltaTime);
            ball.calculatePosition(deltaTime);
            ball.calculateCollision();

            currentBallY = ball.getCenterAtom().getPosition().y;
            lastBallY = ball.getCenterAtom().getLastPosition().y;

            if((currentBallY < lastBallY) && (currentBallY < maxHeight)) {
                maxHeight = currentBallY;
            }

            passedTime += deltaTime;
        }
    }

    @Override
    public double returnResult() {
        return maxHeight;
    }
}
