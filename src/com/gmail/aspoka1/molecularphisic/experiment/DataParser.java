package com.gmail.aspoka1.molecularphisic.experiment;

import com.gmail.aspoka1.molecularphisic.phisic.Ball;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DataParser {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "E2Result.txt";
        String targetName = "E2Best.txt";
        String line;
        String header;

        DataLine[] data = new DataLine[100];

        File in = new File("Results\\" + fileName);
        Scanner stream = new Scanner(in);

        header = stream.nextLine();

        for(int i = 0; i < data.length; i++) {
            line = stream.nextLine();
            data[i] = parseLine(line);
        }

        //Arrays.sort(data, ((DataLine o1, DataLine o2) -> {if(o1.result > o2.result) return 1; else return -1;}));
        Arrays.sort(data, Comparator.comparingDouble(DataLine::getResult));

        DataLine temp;

        try {
            while(true) {
                line = stream.nextLine();
                temp = parseLine(line);
                insertData(data, temp);
            }
        } catch (NoSuchElementException e) {

        } catch ( NumberFormatException e) {

        }

        for (DataLine t : data) {
            System.out.println(t);
        }

        try {
            File file = new File("Results\\" + targetName);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(header + "\n");
                for(DataLine t : data) {
                    bw.write(t.toString() + "\n");
                }

                bw.close();
            } else {
                System.out.println("File exist");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(DataLine[] data, DataLine line) {
        if(data[0].getResult() > line.getResult()){
            insertInto(data, line, 0);
            return;
        }

        if(data[data.length - 1].getResult() > line.getResult()) {
            int first = 0;
            int last = data.length - 1;
            while (first + 1 < last) {
                int mid = (first + last) / 2;
                if(data[mid].getResult() > line.getResult()) {
                    last = mid;
                } else {
                    first = mid;
                }
            }
            insertInto(data, line, last);
        }
    }

    private static void insertInto(DataLine[] data, DataLine d, int index) {
        DataLine temp1 = data[index], temp2;
        data[index] = d;
        for(int i = index + 1; i < data.length; i++) {
            temp2 = data[i];
            data[i] = temp1;
            temp1 = temp2;
        }
    }

    private static DataLine parseLine(String line) {
        Scanner stream = new Scanner(line);
        String temp;

        long number;
        double result;
        int pressure;
        int airWeight;
        int atomWeight;
        int elasticity;

        temp = stream.next();
        number = Integer.parseInt(temp);
        temp = stream.next();
        temp = temp.substring(7);
        result = Double.parseDouble(temp);
        temp = stream.next();
        temp = temp.substring(9);
        pressure = Integer.parseInt(temp);
        temp = stream.next();
        temp = temp.substring(10);
        airWeight = Integer.parseInt(temp);
        temp = stream.next();
        temp = temp.substring(11);
        atomWeight = Integer.parseInt(temp);
        temp = stream.next();
        temp = temp.substring(11);
        elasticity = Integer.parseInt(temp);

        return new DataLine(number, result, pressure, airWeight, atomWeight, elasticity);
    }

    static class DataLine {
        long number;
        double result;
        int pressure;
        int airWeight;
        int atomWeight;
        int elasticity;

        //int startHeight;
        //double percent;

        public DataLine(long number, double result, int pressure, int airWeight, int atomWeight, int elasticity/*, int startHeight*/) {
            this.number = number;
            this.result = result;
            this.pressure = pressure;
            this.airWeight = airWeight;
            this.atomWeight = atomWeight;
            this.elasticity = elasticity;
            //this.startHeight = startHeight;
        }

        public double getResult() {
            return result;
        }

        @Override
        public  String toString(){
            return number + " result:" + result + " pressure:" + pressure + " airWeight:" + airWeight + " atomWeight:" + atomWeight + " elasticity:" + elasticity;
        }
    }
}