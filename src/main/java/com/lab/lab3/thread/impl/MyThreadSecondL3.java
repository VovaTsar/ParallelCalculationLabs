package com.lab.lab3.thread.impl;

import com.lab.lab3.OperationForL3;
import com.lab.lab3.ShowInformation;
import com.lab.lab3.thread.Calculate;

import static com.lab.lab3.OperationForL3.*;

public class MyThreadSecondL3 implements Calculate {
    private final int n;
    private final ShowInformation showInformation;

    public MyThreadSecondL3(int n, ShowInformation showInformation) {
        this.n = n;
        this.showInformation = showInformation;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultB[] = calculate();

        long second = System.currentTimeMillis() - time;
        showInformation.showVector(vectorResultB, "Thread Second finished. Time: " + second + " Millis" + " Result:");

    }

    private double[] calculate() {
        double[] vectorD = randomVector(n);
        double[] vectorC = randomVector(n);
        double[][] matrixT = randomMatrix(n);

        return subtractTwoVector(multiplyVectorToMatrix(vectorD, matrixT),
                multiplyNumberToVector(searchMinVector(vectorD), vectorC));
    }
}
