package com.lab.lab1.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class FillingMatrixFromFile {

    public static synchronized double[][] fillingMatrix(int n, String message) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("numbers.txt"));
        String numbers = "";
        while (br.ready()) {
            numbers = br.readLine();
        }

        double[][] matrix = new double[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String[] line = numbers.split(" ");
                matrix[i][j] = Double.parseDouble(line[j]);
            }
        }

        Operation.showMatrix(matrix, message);
        return matrix;
    }
}
