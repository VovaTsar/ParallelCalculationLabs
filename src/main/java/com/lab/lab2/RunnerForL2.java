package com.lab.lab2;

import com.lab.lab2.thread.impl.MyThreadFirstL2;
import com.lab.lab2.thread.impl.MyThreadFourthL2;
import com.lab.lab2.thread.impl.MyThreadSecondL2;
import com.lab.lab2.thread.impl.MyThreadThirdL2;

public class RunnerForL2 {
    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
               new MyThreadFirstL2(6765).executeComputing();
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                 new MyThreadSecondL2(450).executeComputing();
            }
        });

        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                new MyThreadThirdL2(499).executeComputing();
            }
        });

        Runnable thread4= new MyThreadFourthL2(5335)::executeComputing;

        thread1.start();
        thread2.start();
        thread3.start();
        new Thread(thread4).start();

    }
}
