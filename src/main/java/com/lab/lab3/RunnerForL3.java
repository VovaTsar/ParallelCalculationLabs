package com.lab.lab3;


import com.lab.lab3.thread.impl.MyThreadFirstL3;
import com.lab.lab3.thread.impl.MyThreadFourthL3;
import com.lab.lab3.thread.impl.MyThreadSecondL3;
import com.lab.lab3.thread.impl.MyThreadThirdL3;

import java.util.concurrent.Semaphore;

public class RunnerForL3 {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);
        ShowInformation show = new ShowInformation(semaphore);

        Runnable thread1 = new MyThreadFirstL3(8999, show)::executeComputing;

        Runnable thread2 = new MyThreadSecondL3(990, show)::executeComputing;

        Runnable thread3 = new MyThreadThirdL3(499, show)::executeComputing;

        Runnable thread4 = new MyThreadFourthL3(5335, show)::executeComputing;

        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
        new Thread(thread4).start();
    }
}
