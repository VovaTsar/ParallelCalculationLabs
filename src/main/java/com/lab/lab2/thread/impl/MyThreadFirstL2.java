package com.lab.lab2.thread.impl;

import com.lab.lab2.thread.Calculate;

import static com.lab.util.Operation.*;

public class MyThreadFirstL2 implements Calculate {
    private  int n;

    public MyThreadFirstL2(int n) {
        this.n = n;

    }


    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultA[] = calculate();

        long first = System.currentTimeMillis() - time;
        showVector(vectorResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
    }

    private double[] calculate() {
        double[] vectorB = randomVector(n);
        double[] vectorE = randomVector(n);
        double[][] matrixC = randomMatrix(n);
        double[][] matrixZ = randomMatrix(n);
        double[][] matrixM = randomMatrix(n);

        return addTwoVector(multiplyVectorToMatrix(vectorB, addTwoMatrix(matrixC, matrixZ)),
                multiplyVectorToMatrix(vectorE, matrixM));
    }
}
