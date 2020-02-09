package com.lab.lab1.thread;

import static com.lab.lab1.util.Operation.*;

public class MyThreadFourth implements Runnable {
    private int n;

    public MyThreadFourth(int n) {
        this.n = n;
    }

    public void run() {
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
