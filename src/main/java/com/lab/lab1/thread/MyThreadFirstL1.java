package com.lab.lab1.thread;


import static com.lab.util.Operation.*;

public class MyThreadFirstL1 implements Runnable {
    private int n;

    public MyThreadFirstL1(int n) {
        this.n = n;
    }

    public void run() {
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
