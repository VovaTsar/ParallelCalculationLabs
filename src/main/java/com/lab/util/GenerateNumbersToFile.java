package com.lab.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public final class GenerateNumbersToFile {

    public static void generateNumbers() {
        int[] array = new int[1000];
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i)
            array[i] = (random.nextInt(65536));

        try (final FileWriter writer = new FileWriter("numbers.txt", false)) {
            for (int i = 0; i < array.length; ++i) {
                final String s = Integer.toString(array[i]);
                writer.write(s);
                writer.write(" ");
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
