package com.lab.lab4;

import java.util.concurrent.Semaphore;

public class ShowInformationL4 {
    private final Semaphore semaphore;

    public ShowInformationL4(Semaphore semaphore) {
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
