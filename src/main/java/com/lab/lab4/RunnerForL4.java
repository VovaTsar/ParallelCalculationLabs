package com.lab.lab4;

import com.lab.lab4.thread.impl.MyThreadFirstL4;
import com.lab.lab4.thread.impl.MyThreadFourthL4;
import com.lab.lab4.thread.impl.MyThreadSecondL4;
import com.lab.lab4.thread.impl.MyThreadThirdL4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class RunnerForL4 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        ShowInformationL4 show = new ShowInformationL4(semaphore);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable task1= new MyThreadFirstL4(5453, show)::executeComputing;
        Runnable task2=(new MyThreadSecondL4(3000, show)::executeComputing);
        Runnable task3=(new MyThreadThirdL4(700,show)::executeComputing);
        Runnable task4=(new MyThreadFourthL4(5999,show)::executeComputing);

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.submit(task4);

        executorService.shutdown();
    }

}
