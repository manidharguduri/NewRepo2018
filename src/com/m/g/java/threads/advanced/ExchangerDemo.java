package com.m.g.java.threads.advanced;
/**
 * Exchanger allows exchanging of objects between two threads.
 * First thread reaches the exchange points and waits till the second thread
 * reaches the exchange point and then exchange the values.
 */

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        Thread t1 = new Thread(new ExchangerTask(exchanger, " Hi Mani "));
        Thread t2 = new Thread(new ExchangerTask(exchanger, " Hello Gayi"));
        t1.setName("First Thread");
        t2.setName("Second Thread");
        t1.start();
        t2.start();
    }
}

class ExchangerTask implements Runnable {
    Exchanger<String> exchanger;
    String name;

    ExchangerTask(Exchanger exchanger, String name) {
        this.exchanger = exchanger;
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Name before Exchange " + name);
        try {
            name = exchanger.exchange(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Name after Exchange  " + name);
    }

}






