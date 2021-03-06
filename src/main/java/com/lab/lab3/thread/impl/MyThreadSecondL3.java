package com.lab.lab3.thread.impl;

import com.lab.lab3.ShowInformationL3;
import com.lab.lab3.thread.Calculate;

import static com.lab.lab3.OperationForL3.*;

public class MyThreadSecondL3 implements Calculate {
    private final int n;
    private final ShowInformationL3 showInformationL3;

    public MyThreadSecondL3(int n, ShowInformationL3 showInformationL3) {
        this.n = n;
        this.showInformationL3 = showInformationL3;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultB[] = calculate();

        long second = System.currentTimeMillis() - time;
        showInformationL3.showVector(vectorResultB, "Thread Second finished. Time: " + second + " Millis" + " Result:");

    }

    private double[] calculate() {
        double[] vectorD = randomVector(n);
        double[] vectorC = randomVector(n);
        double[][] matrixT = randomMatrix(n);

        return subtractTwoVector(multiplyVectorToMatrix(vectorD, matrixT),
                multiplyNumberToVector(searchMinVector(vectorD), vectorC));
    }
}
