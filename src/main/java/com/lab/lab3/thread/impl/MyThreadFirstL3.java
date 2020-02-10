package com.lab.lab3.thread.impl;


import com.lab.lab3.ShowInformation;
import com.lab.lab3.thread.Calculate;

import static com.lab.lab3.OperationForL3.*;

public class MyThreadFirstL3 implements Calculate {
    private final int n;
    private final ShowInformation showInformation;

    public MyThreadFirstL3(int n, ShowInformation showInformation) {
        this.n = n;
        this.showInformation = showInformation;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultA[] = calculate();

        long first = System.currentTimeMillis() - time;
        showInformation.showVector(vectorResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
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
