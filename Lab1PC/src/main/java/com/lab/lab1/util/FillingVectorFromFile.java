package com.lab.lab1.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class FillingVectorFromFile {

    public static synchronized double[] fillingVector(int n, String message) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("numbers.txt"));

        String numbers = "";
        while (br.ready()) {
            numbers = br.readLine();
        }

        double[] vector = new double[n];

        for (int i = 0; i < vector.length; i++) {
            String[] line = numbers.split(" ");
            vector[i] = Double.parseDouble(line[i]);
        }

        Operation.showVector(vector, message);
        return vector;
    }
}
