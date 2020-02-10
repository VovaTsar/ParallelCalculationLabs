package com.lab.lab3.thread.impl;

import com.lab.lab3.OperationForL3;
import com.lab.lab3.ShowInformation;
import com.lab.lab3.thread.Calculate;

import static com.lab.lab3.OperationForL3.*;

public class MyThreadFourthL3 implements Calculate {
    private final int n;
    private final ShowInformation showInformation;

    public MyThreadFourthL3(int n, ShowInformation showInformation) {
        this.n = n;
        this.showInformation = showInformation;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();

        System.out.println(this.getClass().getName() + " start");

        double vectorResultA[] = calculate();

        long fourth = System.currentTimeMillis() - time;
        showInformation.showVector(vectorResultA, "Thread Fourth  finished. Time: " + fourth + " Millis" + " Result:");
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
