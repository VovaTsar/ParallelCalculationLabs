package com.lab.lab1.thread;

import com.lab.lab1.util.FillingMatrixFromFile;
import com.lab.lab1.util.FillingVectorFromFile;

import java.io.IOException;

import static com.lab.lab1.util.Operation.*;

public class MyThreadThird implements Runnable {
    private int n;

    public MyThreadThird(int n) {
        this.n = n;
    }

    public void run() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultD[] = calculate();

        long third = System.currentTimeMillis() - time;
        showVector(vectorResultD, "Thread Second finished. Time: " + third +" Millis"+ " Result:");
    }

    private double[] calculate() {

        double[] vectorE = randomVector(n);
        double[][] matrixZ = randomMatrix(n);
        double[][] matrixM = randomMatrix(n);
        double[][] matrixX = randomMatrix(n);
        double[] vectorB = new double[0];
        double[][] matrixC = new double[0][0];
        try {
            vectorB = FillingVectorFromFile.fillingVector(n, "Filling VectorB from file. It is Third thread ");
            matrixC = FillingMatrixFromFile.fillingMatrix(n, "Filling VectorB from file. It is Third thread");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return subtractTwoVector(multiplyVectorToMatrix(vectorB, addTwoMatrix(matrixC, matrixZ)),
                multiplyVectorToMatrix(vectorE, addTwoMatrix(matrixM, matrixX)));
    }
}
