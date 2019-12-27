package com.gmail.aspoka1.molecularphisic.graphics;

import com.gmail.aspoka1.molecularphisic.Main;
import com.gmail.aspoka1.molecularphisic.phisic.Ball;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateBallPanel implements ActionListener{
    JButton generate;
    //JButton start;
    //JButton end;

    DrawFrame frame;
    JPanel panel;
    GameContainer gc;

    Ball ball;
    int atomAmounts;
    int radius;
    int surfaceAtomWeight;
    int centerAtomWeight;
    int surfaceElasticy;
    int preasure;
    int height;

    GenerateBallPanel(int width, int height, int widthOffset, int heightOffset, JPanel panel, DrawFrame frame, GameContainer gc) {
        this.gc = gc;
        this.panel = panel;
        this.frame = frame;

        this.atomAmounts = 20;
        this.radius = 100;
        this.surfaceAtomWeight = 1;
        this.centerAtomWeight = 20;
        this.surfaceElasticy = 10;
        this.preasure = 30;
        this.height = 0;

        JLabel label1 = new JLabel("<html>Atoms<br>Amount:</html>");
        label1.setBounds(widthOffset + 10, 0, 80, 50);
        panel.add(label1);
        JSlider atomsAmountSlider = new JSlider(JSlider.HORIZONTAL, 10, 50, this.atomAmounts);
        atomsAmountSlider.setBounds(widthOffset + 80, 0, width - 80, 50);
        atomsAmountSlider.addChangeListener(e -> atomAmounts = atomsAmountSlider.getValue());
        atomsAmountSlider.setMajorTickSpacing(20);
        atomsAmountSlider.setMinorTickSpacing(5);
        atomsAmountSlider.setPaintTicks(true);
        atomsAmountSlider.setPaintLabels(true);
        panel.add(atomsAmountSlider);

        JLabel label2 = new JLabel("<html>Ball<br>radius:</html>");
        label2.setBounds(widthOffset + 10, 50, 80, 50);
        panel.add(label2);
        JSlider radiusSlider = new JSlider(JSlider.HORIZONTAL, 50, 150, this.radius);
        radiusSlider.setBounds(widthOffset + 80, 50, width - 80, 50);
        radiusSlider.addChangeListener(e -> radius = radiusSlider.getValue());
        radiusSlider.setMajorTickSpacing(50);
        radiusSlider.setMinorTickSpacing(5);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);
        panel.add(radiusSlider);

        JLabel label3 = new JLabel("<html>Atoms<br>weight:</html>");
        label3.setBounds(widthOffset + 10, 100, 80, 50);
        panel.add(label3);
        JSlider surfaceAtomWeightSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, this.surfaceAtomWeight);
        surfaceAtomWeightSlider.setBounds(widthOffset + 80, 100, width - 80, 50);
        surfaceAtomWeightSlider.addChangeListener(e -> surfaceAtomWeight = surfaceAtomWeightSlider.getValue());
        surfaceAtomWeightSlider.setMajorTickSpacing(10);
        surfaceAtomWeightSlider.setMinorTickSpacing(5);
        surfaceAtomWeightSlider.setPaintTicks(true);
        surfaceAtomWeightSlider.setPaintLabels(true);
        panel.add(surfaceAtomWeightSlider);

        JLabel label4 = new JLabel("<html>Air<br>weight:</html>");
        label4.setBounds(widthOffset + 10, 150, 80, 50);
        panel.add(label4);
        JSlider centerAtomWeightSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, this.centerAtomWeight);
        centerAtomWeightSlider.setBounds(widthOffset + 80, 150, width - 80, 50);
        centerAtomWeightSlider.addChangeListener(e -> centerAtomWeight = centerAtomWeightSlider.getValue());
        centerAtomWeightSlider.setMajorTickSpacing(10);
        centerAtomWeightSlider.setMinorTickSpacing(5);
        centerAtomWeightSlider.setPaintTicks(true);
        centerAtomWeightSlider.setPaintLabels(true);
        panel.add(centerAtomWeightSlider);

        JLabel label5 = new JLabel("<html>Surface<br>elasticity:</html>");
        label5.setBounds(widthOffset + 10, 200, 80, 50);
        panel.add(label5);
        JSlider surfaceElasticySlider = new JSlider(JSlider.HORIZONTAL, 0, 50, this.surfaceElasticy);
        surfaceElasticySlider.setBounds(widthOffset + 80, 200, width - 80, 50);
        surfaceElasticySlider.addChangeListener(e -> surfaceElasticy = surfaceElasticySlider.getValue());
        surfaceElasticySlider.setMajorTickSpacing(10);
        surfaceElasticySlider.setMinorTickSpacing(5);
        surfaceElasticySlider.setPaintTicks(true);
        surfaceElasticySlider.setPaintLabels(true);
        panel.add(surfaceElasticySlider);

        JLabel label6 = new JLabel("<html>Pressure:</html>");
        label6.setBounds(widthOffset + 10, 250, 80, 50);
        panel.add(label6);
        JSlider preasureSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, this.preasure);
        preasureSlider.setBounds(widthOffset + 80, 250, width - 80, 50);
        preasureSlider.addChangeListener(e -> preasure = preasureSlider.getValue());
        preasureSlider.setMajorTickSpacing(20);
        preasureSlider.setMinorTickSpacing(5);
        preasureSlider.setPaintTicks(true);
        preasureSlider.setPaintLabels(true);
        panel.add(preasureSlider);

        JLabel label7 = new JLabel("<html>Height:</html>");
        label7.setBounds(widthOffset + 10, 300, 80, 50);
        panel.add(label7);
        JSlider heightSlider = new JSlider(JSlider.HORIZONTAL, 0, 400, this.height);
        heightSlider.setBounds(widthOffset + 80, 300, width - 80, 50);
        heightSlider.addChangeListener(e -> this.height = heightSlider.getValue());
        heightSlider.setMajorTickSpacing(100);
        heightSlider.setMinorTickSpacing(20);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        panel.add(heightSlider);

        generate = new JButton("Generate");
        generate.setBounds(widthOffset + 50, height - 40, width - 100, 20);
        generate.setActionCommand("generate");
        generate.addActionListener(this);
        panel.add(generate);

        /*
        start = new JButton("Start");
        start.setBounds(widthOffset + 50, height - 80, width - 100, 20);
        start.setActionCommand("start");
        start.addActionListener(this);
        panel.add(start);

        end = new JButton("End");
        end.setBounds(widthOffset + 50, height - 40, width - 100, 20);
        end.setActionCommand("end");
        end.addActionListener(this);
        panel.add(end);
        */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("end".equals(e.getActionCommand())){
            try {
                gc.stop();
            } catch (InterruptedException ex) {
                System.out.println("Can not stop thread");
                ex.printStackTrace();
            }
        } else if("start".equals(e.getActionCommand())) {
            gc.start();
        } else  if("generate".equals(e.getActionCommand())){
            ball = new Ball(Main.WIDTH / 2, 400 - radius - height, atomAmounts, radius, surfaceAtomWeight, centerAtomWeight, surfaceElasticy, preasure);
            gc.addPhisicComponent(ball);
            gc.addDynamicCollisionableComponent(ball);
            frame.clear();
            frame.addDrawableElement(ball);
            panel.repaint();
        }
    }
}
