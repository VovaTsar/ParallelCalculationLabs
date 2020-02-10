package com.lab.lab1.thread;

import static com.lab.util.Operation.*;

public class MyThreadSecondL1 implements Runnable {
    private int n;

    public MyThreadSecondL1(int n) {
        this.n = n;
    }

    public void run() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultB[] = calculate();

        long second = System.currentTimeMillis() - time;
        showVector(vectorResultB, "Thread Second finished. Time: " + second + " Millis" + " Result:");

    }

    private double[] calculate() {
        double[] vectorD = randomVector(n);
        double[] vectorC = randomVector(n);
        double[][] matrixT = randomMatrix(n);

        return subtractTwoVector(multiplyVectorToMatrix(vectorD, matrixT),
                multiplyNumberToVector(searchMinVector(vectorD), vectorC));
    }
}
