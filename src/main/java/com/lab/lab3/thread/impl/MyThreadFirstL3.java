package com.lab.lab3.thread.impl;


import com.lab.lab3.ShowInformationL3;
import com.lab.lab3.thread.Calculate;

import static com.lab.lab3.OperationForL3.*;

public class MyThreadFirstL3 implements Calculate {
    private final int n;
    private final ShowInformationL3 showInformationL3;

    public MyThreadFirstL3(int n, ShowInformationL3 showInformationL3) {
        this.n = n;
        this.showInformationL3 = showInformationL3;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultA[] = calculate();

        long first = System.currentTimeMillis() - time;
        showInformationL3.showVector(vectorResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
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
