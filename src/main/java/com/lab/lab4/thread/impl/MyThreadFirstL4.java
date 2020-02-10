package com.lab.lab4.thread.impl;

import com.lab.lab4.ShowInformationL4;
import com.lab.lab4.thread.Calculate;

import static com.lab.lab4.OperationForL4.*;
import static com.lab.lab4.OperationForL4.addTwoMatrix;
import static com.lab.lab4.OperationForL4.multiplyVectorToMatrix;

public class MyThreadFirstL4  implements Calculate {
    private final int n;
    private final ShowInformationL4 showInformationL4;

    public MyThreadFirstL4(int n, ShowInformationL4 showInformationL4) {
        this.n = n;
        this.showInformationL4 = showInformationL4;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultA[] = calculate();

        long first = System.currentTimeMillis() - time;
        showInformationL4.showVector(vectorResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
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
