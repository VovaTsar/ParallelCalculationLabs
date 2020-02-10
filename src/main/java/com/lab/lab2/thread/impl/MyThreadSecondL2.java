package com.lab.lab2.thread.impl;

import com.lab.lab2.thread.Calculate;

import static com.lab.util.Operation.*;

public class MyThreadSecondL2 implements Calculate {
    private final  int n;

    public MyThreadSecondL2(int n) {
        this.n = n;
    }

    @Override
    public void executeComputing() {
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
