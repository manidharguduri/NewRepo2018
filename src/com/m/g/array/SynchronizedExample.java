package com.m.g.array;

/**
 *
 * Source : Wissen Technology written testq
 *
 * Problem : Static and Object Synchronization.
 */

public class SynchronizedExample {
    private String name;

    public SynchronizedExample(String name) {
        this.name = name;
    }

    public static synchronized void m1() {

        System.out.println("SM1");
        System.out.println("SM2");
    }

    public synchronized void m2() {
        System.out.println(name + "M1");
        System.out.println(name + "M2");
    }

    public static void main(String[] args) throws InterruptedException {


        SynchronizedExample sync = new SynchronizedExample("OM");

        Thread t1 = new Thread(() ->
        {
            sync.m2();
        });

        Thread t2 = new Thread(() ->
        {
            m1();
        });

        Thread t3 = new Thread(() ->
        {
            m1();
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Output will varies due to the OS thread scheduler behavior.

    }
}