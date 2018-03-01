package com.m.g.java.threads.advanced;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        App msfApp = new MsfApp();
        App wmApp = new WmApp();
        Thread msfThread = new Thread(new serviceStartUpImpl(msfApp, countDownLatch));
        Thread wmThread = new Thread(new serviceStartUpImpl(wmApp, countDownLatch));
        msfThread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wmThread.start();
    }
}

interface App {
    public void start();


}

class serviceStartUpImpl implements Runnable {
    App app;
    CountDownLatch countDownLatch;

    public serviceStartUpImpl(App app, CountDownLatch countDownLatch) {
        this.app = app;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        app.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}

class WmApp implements App {
    @Override
    public void start() {
        System.out.println(" Wmapp is started .... ");
    }
}

class MsfApp implements App {
    @Override
    public void start() {
        System.out.println(" MsfApp is started ..... ");
    }
}