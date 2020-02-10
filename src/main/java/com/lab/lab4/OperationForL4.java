package com.lab.lab4;

public class OperationForL4 {
    public static double[] addTwoVector(double vectorFirst[], double vectorSecond[]) {
        for (int i = 0; i < vectorSecond.length; i++) {
            vectorFirst[i] += vectorSecond[i];
        }

        return vectorFirst;
    }

    public static double[] subtractTwoVector(double vectorFirst[], double vectorSecond[]) {
        for (int i = 0; i < vectorSecond.length; i++) {
            vectorFirst[i] -= vectorSecond[i];
        }

        return vectorFirst;
    }


    public static double[][] multiplyMatrix(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] resultMatrix = new double[firstMatrix.length][firstMatrix[1].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                for (int k = 0; k < secondMatrix.length; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }

            }
        }

        return resultMatrix;
    }

    public static double[][] addTwoMatrix(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] resultMatrix = new double[firstMatrix.length][firstMatrix[1].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];

            }
        }

        return resultMatrix;
    }

    public static double[] multiplyVectorToMatrix(double vectorFirst[], double matrixSecond[][]) {
        double resultVector[] = new double[vectorFirst.length];

        for (int i = 0; i < matrixSecond.length; i++) {
            for (int j = 0; j < resultVector.length; j++) {
                resultVector[i] += vectorFirst[j] * matrixSecond[j][i];
            }
        }

        return resultVector;
    }

    public static double[][] randomMatrix(int n) {
        double matrix[][] = new double[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 1;
            }
        }

        return matrix;
    }

    public static double[] randomVector(int n) {
        double vector[] = new double[n];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 1;
        }

        return vector;
    }


    public static synchronized void showMatrix(double matrix[][], String message) {
        System.out.println(message);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double searchMinVector(double[] vector) {
        double value = vector[0];
        for (double aVector : vector) {
            if (aVector < value) {
                value = aVector;
            }
        }

        return value;
    }

    public static double[] multiplyNumberToVector(double number, double vector[]) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * number;
        }

        return vector;
    }
}
