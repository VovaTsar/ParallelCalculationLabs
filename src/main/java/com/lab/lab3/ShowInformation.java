package com.lab.lab3;

import java.util.concurrent.Semaphore;

public class ShowInformation {
    private final Semaphore semaphore;

    public ShowInformation(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public synchronized void showVector(double vector[], String message) {
        try {
            semaphore.acquire();
            System.out.println("Lock showVector ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
        for (double aVector : vector) {
            System.out.print(aVector + " ");
        }
        System.out.println();
        System.out.println("UnLock  showVector ");
        semaphore.release();

    }
}
