package com.gmail.aspoka1.molecularphisic.graphics;

import com.gmail.aspoka1.molecularphisic.Main;
import com.gmail.aspoka1.molecularphisic.phisic.Ball;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateBallPanel implements ActionListener{
    public static final int WIDTH = 200;
    
    JButton generate;

    Frame frame;
    JPanel panel;
    GameContainer gc;

    Ball ball;
    int atomAmounts;
    int radius;
    int surfaceAtomWeight;
    int centerAtomWeight;
    int surfaceElasticity;
    int pressure;
    int height;

    GenerateBallPanel(JPanel panel, Frame frame, GameContainer gc) {
        this.gc = gc;
        this.panel = panel;
        this.frame = frame;

        this.atomAmounts = Ball.DEFAULT_INIT_ATOMS_AMOUNT;
        this.radius = Ball.DEFAULT_INIT_RADIUS;
        this.surfaceAtomWeight = Ball.DEFAULT_INIT_SURFACE_ATOM_WEIGHT;
        this.centerAtomWeight = Ball.DEFAULT_INIT_AIR_WEIGHT;
        this.surfaceElasticity = Ball.DEFAULT_INIT_SURFACE_ELASTICITY;
        this.pressure = Ball.DEFAULT_INIT_AIR_PRESSURE;
        this.height = 0;

        JLabel label1 = new JLabel("<html>Atoms<br>Amount:</html>");
        label1.setBounds(Main.WIDTH + 10, 0, 80, 50);
        panel.add(label1);
        JSlider atomsAmountSlider = new JSlider(JSlider.HORIZONTAL, 10, 50, this.atomAmounts);
        atomsAmountSlider.setBounds(Main.WIDTH + 80, 0, WIDTH - 80, 50);
        atomsAmountSlider.addChangeListener(e -> atomAmounts = atomsAmountSlider.getValue());
        atomsAmountSlider.setMajorTickSpacing(20);
        atomsAmountSlider.setMinorTickSpacing(5);
        atomsAmountSlider.setPaintTicks(true);
        atomsAmountSlider.setPaintLabels(true);
        panel.add(atomsAmountSlider);

        JLabel label2 = new JLabel("<html>Ball<br>radius:</html>");
        label2.setBounds(Main.WIDTH + 10, 50, 80, 50);
        panel.add(label2);
        JSlider radiusSlider = new JSlider(JSlider.HORIZONTAL, 50, 150, this.radius);
        radiusSlider.setBounds(Main.WIDTH + 80, 50, WIDTH - 80, 50);
        radiusSlider.addChangeListener(e -> radius = radiusSlider.getValue());
        radiusSlider.setMajorTickSpacing(50);
        radiusSlider.setMinorTickSpacing(5);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);
        panel.add(radiusSlider);

        JLabel label3 = new JLabel("<html>Atoms<br>weight:</html>");
        label3.setBounds(Main.WIDTH + 10, 100, 80, 50);
        panel.add(label3);
        JSlider surfaceAtomWeightSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, this.surfaceAtomWeight);
        surfaceAtomWeightSlider.setBounds(Main.WIDTH + 80, 100, WIDTH - 80, 50);
        surfaceAtomWeightSlider.addChangeListener(e -> surfaceAtomWeight = surfaceAtomWeightSlider.getValue());
        surfaceAtomWeightSlider.setMajorTickSpacing(10);
        surfaceAtomWeightSlider.setMinorTickSpacing(5);
        surfaceAtomWeightSlider.setPaintTicks(true);
        surfaceAtomWeightSlider.setPaintLabels(true);
        panel.add(surfaceAtomWeightSlider);

        JLabel label4 = new JLabel("<html>Air<br>weight:</html>");
        label4.setBounds(Main.WIDTH + 10, 150, 80, 50);
        panel.add(label4);
        JSlider centerAtomWeightSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, this.centerAtomWeight);
        centerAtomWeightSlider.setBounds(Main.WIDTH + 80, 150, WIDTH - 80, 50);
        centerAtomWeightSlider.addChangeListener(e -> centerAtomWeight = centerAtomWeightSlider.getValue());
        centerAtomWeightSlider.setMajorTickSpacing(10);
        centerAtomWeightSlider.setMinorTickSpacing(5);
        centerAtomWeightSlider.setPaintTicks(true);
        centerAtomWeightSlider.setPaintLabels(true);
        panel.add(centerAtomWeightSlider);

        JLabel label5 = new JLabel("<html>Surface<br>elasticity:</html>");
        label5.setBounds(Main.WIDTH + 10, 200, 80, 50);
        panel.add(label5);
        JSlider surfaceElasticySlider = new JSlider(JSlider.HORIZONTAL, 0, 50, this.surfaceElasticity);
        surfaceElasticySlider.setBounds(Main.WIDTH + 80, 200, WIDTH - 80, 50);
        surfaceElasticySlider.addChangeListener(e -> surfaceElasticity = surfaceElasticySlider.getValue());
        surfaceElasticySlider.setMajorTickSpacing(10);
        surfaceElasticySlider.setMinorTickSpacing(5);
        surfaceElasticySlider.setPaintTicks(true);
        surfaceElasticySlider.setPaintLabels(true);
        panel.add(surfaceElasticySlider);

        JLabel label6 = new JLabel("<html>Pressure:</html>");
        label6.setBounds(Main.WIDTH + 10, 250, 80, 50);
        panel.add(label6);
        JSlider preasureSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, this.pressure);
        preasureSlider.setBounds(Main.WIDTH + 80, 250, WIDTH - 80, 50);
        preasureSlider.addChangeListener(e -> pressure = preasureSlider.getValue());
        preasureSlider.setMajorTickSpacing(20);
        preasureSlider.setMinorTickSpacing(5);
        preasureSlider.setPaintTicks(true);
        preasureSlider.setPaintLabels(true);
        panel.add(preasureSlider);

        JLabel label7 = new JLabel("<html>Height:</html>");
        label7.setBounds(Main.WIDTH + 10, 300, 80, 50);
        panel.add(label7);
        JSlider heightSlider = new JSlider(JSlider.HORIZONTAL, 0, 400, this.height);
        heightSlider.setBounds(Main.WIDTH + 80, 300, WIDTH - 80, 50);
        heightSlider.addChangeListener(e -> height = heightSlider.getValue());
        heightSlider.setMajorTickSpacing(100);
        heightSlider.setMinorTickSpacing(20);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        panel.add(heightSlider);

        generate = new JButton("Generate");
        generate.setBounds(Main.WIDTH + 50, Main.HEIGHT - 40, WIDTH - 100, 20);
        generate.setActionCommand("generate");
        generate.addActionListener(this);
        panel.add(generate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("generate".equals(e.getActionCommand())){
            ball = new Ball(Main.WIDTH / 2, 400 - radius - height, atomAmounts, radius, surfaceAtomWeight, centerAtomWeight, surfaceElasticity, pressure);
            //ball = new Ball();
            gc.addPhysicComponent(ball);
            frame.clear();
            frame.addDrawableElement(ball);
            panel.repaint();
        }
    }
}
