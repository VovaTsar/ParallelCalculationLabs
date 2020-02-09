package com.lab.lab1;

import com.lab.lab1.thread.MyThreadFirst;
import com.lab.lab1.thread.MyThreadFourth;
import com.lab.lab1.thread.MyThreadSecond;
import com.lab.lab1.thread.MyThreadThird;

public class RunnerForFirsLab {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new MyThreadFirst(8800));
        Thread threadTwo = new Thread(new MyThreadSecond(700));
        Thread threadThree = new Thread(new MyThreadThird(500));
        Thread threadFour = new Thread(new MyThreadFourth(1000));

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

    }
}
