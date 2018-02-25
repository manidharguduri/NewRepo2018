package com.m.g.threads;

public class ThreadLocalDemo {

    public static void main(String[] args) {

        SharedResource s = new SharedResource();
        Thread t1 = new Thread1(s);
        Thread t2 = new Thread2(s);
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();


    }


}

class SharedResource {
    String nonThreadLocalVariable = " ";
    ThreadLocal<String> threadLocalVariable = new ThreadLocal<String>();

    public void display() {
        System.out.println(Thread.currentThread().getName() + " thread local variable value ::" + threadLocalVariable.get());
        System.out.println(Thread.currentThread().getName() + " thread non local variable value ::" + nonThreadLocalVariable);

    }

}


class Thread1 extends Thread {

    SharedResource shared;

    Thread1(SharedResource shared) {
        this.shared = shared;
    }

    public void run() {
        shared.nonThreadLocalVariable = "Hello mani";
        shared.threadLocalVariable.set("Hi mani");
        shared.display();


    }

}

class Thread2 extends Thread {
    SharedResource shared;

    Thread2(SharedResource shared) {
        this.shared = shared;
    }

    public void run() {
        shared.nonThreadLocalVariable = "Hello gayi";
        shared.threadLocalVariable.set("Hi gayi");
        shared.display();


    }

}
