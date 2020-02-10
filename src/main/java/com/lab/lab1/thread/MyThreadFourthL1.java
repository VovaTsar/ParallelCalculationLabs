package com.lab.lab1.thread;

import static com.lab.util.Operation.*;

public class MyThreadFourthL1 implements Runnable {
    private final  int n;

    public MyThreadFourthL1(int n) {
        this.n = n;
    }

    @Override
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
