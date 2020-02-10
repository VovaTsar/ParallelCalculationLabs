package com.lab.lab1;

import com.lab.lab1.thread.MyThreadFirstL1;
import com.lab.lab1.thread.MyThreadFourthL1;
import com.lab.lab1.thread.MyThreadSecondL1;
import com.lab.lab1.thread.MyThreadThirdL1;

public class RunnerForL1 {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new MyThreadFirstL1(8800));
        Thread threadTwo = new Thread(new MyThreadSecondL1(700));
        Thread threadThree = new Thread(new MyThreadThirdL1(500));
        Thread threadFour = new Thread(new MyThreadFourthL1(1000));

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

    }
}
