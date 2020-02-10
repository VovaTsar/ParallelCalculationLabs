package com.lab.lab2.thread.impl;

import com.lab.lab2.thread.Calculate;

import static com.lab.util.Operation.*;

public class MyThreadFourthL2 implements Calculate {
    private int n;

    public MyThreadFourthL2(int n) {
        this.n = n;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();

        System.out.println(this.getClass().getName() + " start");

        double vectorResultA[] = calculate();

        long fourth = System.currentTimeMillis() - time;
        showVector(vectorResultA, "Thread Fourth  finished. Time: " + fourth + " Millis" + " Result:");
    }

    private double[] calculate() {

        double[] vectorD = randomVector(n);
        double[] vectorC = randomVector(n);
        double[] vectorB = randomVector(n);
        double[][] matrixT = randomMatrix(n);

        return subtractTwoVector(multiplyVectorToMatrix(vectorD, matrixT),
                multiplyNumberToVector(searchMinVector(vectorC), vectorB));

    }
}
