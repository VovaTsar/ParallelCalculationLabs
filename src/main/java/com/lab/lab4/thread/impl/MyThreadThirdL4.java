package com.lab.lab4.thread.impl;

import com.lab.exception.FillingRuntimeException;
import com.lab.lab3.ShowInformationL3;
import com.lab.lab4.ShowInformationL4;
import com.lab.lab4.thread.Calculate;
import com.lab.util.FillingMatrixFromFile;
import com.lab.util.FillingVectorFromFile;

import java.io.IOException;

import static com.lab.lab4.OperationForL4.*;
import static com.lab.lab4.OperationForL4.addTwoMatrix;
import static com.lab.lab4.OperationForL4.multiplyVectorToMatrix;

public class MyThreadThirdL4  implements Calculate {
    private final int n;
    private final ShowInformationL4 showInformationL4;

    public MyThreadThirdL4(int n, ShowInformationL4 showInformationL4) {
        this.n = n;
        this.showInformationL4 = showInformationL4;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double vectorResultD[] = calculate();

        long third = System.currentTimeMillis() - time;
        showInformationL4.showVector(vectorResultD, "Thread Second finished. Time: " + third + " Millis" + " Result:");
    }

    private double[] calculate() {
        double[] vectorE = randomVector(n);
        double[][] matrixZ = randomMatrix(n);
        double[][] matrixM = randomMatrix(n);
        double[][] matrixX = randomMatrix(n);
        double[] vectorB;
        double[][] matrixC;
        try {
            vectorB = FillingVectorFromFile.fillingVector(n, "Filling VectorB from file. It is Third thread ");
            matrixC = FillingMatrixFromFile.fillingMatrix(n, "Filling VectorB from file. It is Third thread");
        } catch (IOException e) {
            throw new FillingRuntimeException("Exception with Filling data!!!");
        }

        return subtractTwoVector(multiplyVectorToMatrix(vectorB, addTwoMatrix(matrixC, matrixZ)),
                multiplyVectorToMatrix(vectorE, addTwoMatrix(matrixM, matrixX)));
    }
}
