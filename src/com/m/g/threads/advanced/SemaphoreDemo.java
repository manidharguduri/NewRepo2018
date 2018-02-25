package com.m.g.threads.advanced;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String... args) {
        Semaphore semaphore = new Semaphore(1);
        SemaphoreDemoShared s1 = new SemaphoreDemoShared(semaphore);
        SemaphoreDemoThread1 t1 = new SemaphoreDemoThread1(s1);          
        SemaphoreDemoThread2 t2 = new SemaphoreDemoThread2(s1);
        t1.start();t2.start();
        t1.setName("First Thread");
        t2.setName("Second Thread");

    }
}

class SemaphoreDemoShared {
    Semaphore semaphore;
    int sum = 0;

    SemaphoreDemoShared(Semaphore semaphore) {
        this.semaphore = semaphore;

    }
    public void getSum() throws InterruptedException {
      semaphore.acquire();
        System.out.println(Thread.currentThread().getName()+ " acquired a permit ");
        for (int index = 0; index < 10; index++) {
            sum = sum + index;

        }
        System.out.println("Result of " + Thread.currentThread().getName() +  sum);
        sum=0;
        System.out.println(Thread.currentThread().getName()+ " released permit ");
        semaphore.release();
    }
}

class SemaphoreDemoThread1 extends Thread {
    SemaphoreDemoShared semaphoreDemoShared;

    SemaphoreDemoThread1(SemaphoreDemoShared semaphoreDemoShared) {
        this.semaphoreDemoShared = semaphoreDemoShared;
    }

    public void run() {

        try {
            semaphoreDemoShared.getSum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SemaphoreDemoThread2 extends Thread {
    SemaphoreDemoShared semaphoreDemoShared;

    SemaphoreDemoThread2(SemaphoreDemoShared semaphoreDemoShared) {
        this.semaphoreDemoShared = semaphoreDemoShared;
    }

    public void run() {
        try {
            semaphoreDemoShared.getSum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}