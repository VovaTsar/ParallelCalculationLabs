package com.lab.lab3.thread.impl;

import com.lab.lab3.ShowInformationL3;
import com.lab.lab3.thread.Calculate;

import static com.lab.lab3.OperationForL3.*;

public class MyThreadFourthL3 implements Calculate {
    private final int n;
    private final ShowInformationL3 showInformationL3;

    public MyThreadFourthL3(int n, ShowInformationL3 showInformationL3) {
        this.n = n;
        this.showInformationL3 = showInformationL3;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();

        System.out.println(this.getClass().getName() + " start");

        double vectorResultA[] = calculate();

        long fourth = System.currentTimeMillis() - time;
        showInformationL3.showVector(vectorResultA, "Thread Fourth  finished. Time: " + fourth + " Millis" + " Result:");
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
