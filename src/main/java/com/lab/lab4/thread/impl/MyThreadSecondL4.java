package com.lab.lab4.thread.impl;

import com.lab.lab3.ShowInformationL3;
import com.lab.lab4.ShowInformationL4;
import com.lab.lab4.thread.Calculate;

import static com.lab.lab4.OperationForL4.*;

public class MyThreadSecondL4 implements Calculate {
    private final int n;
    private final ShowInformationL4 showInformationL4;

    public MyThreadSecondL4(int n, ShowInformationL4 showInformationL4) {
        this.n = n;
        this.showInformationL4 = showInformationL4;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultB[] = calculate();

        long second = System.currentTimeMillis() - time;
        showInformationL4.showVector(vectorResultB, "Thread Second finished. Time: " + second + " Millis" + " Result:");

    }

    private double[] calculate() {
        double[] vectorD = randomVector(n);
        double[] vectorC = randomVector(n);
        double[][] matrixT = randomMatrix(n);

        return subtractTwoVector(multiplyVectorToMatrix(vectorD, matrixT),
                multiplyNumberToVector(searchMinVector(vectorD), vectorC));
    }
}
