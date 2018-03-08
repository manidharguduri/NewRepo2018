package com.m.g.java;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {

    public static void main(String[] args) {

        /**
         * Math.random() - which internally creates an instance of java.util.Random on first invocation.
         */
        double r1 = Math.random();
        System.out.println("Printing the Math random value : " + r1);


        /**
         * Random is thread safe for use by multiple threads.
         * But if multiple threads use the same instance of Random, the same seed is shared by multiple threads.
         * It leads to contention between multiple threads and so to performance degradation.
         */
        Random rand = new Random();
        int r2 = rand.nextInt(10);
        System.out.println("Printing the Random class value : " + r2);

        /**
         * ThreadLocalRandom has a Random instance per thread and safeguards against contention.
         */
        int r3 = ThreadLocalRandom.current().nextInt(99999);
        System.out.println("Printing the Math random value using ThreadLocal : " + r3);

    }


}
