package com.m.g.java.threads;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Producer Consumer Problem where one thread
 */
public class ProducerAndConsumerProblem {

    /**
     * This is a shared class which has two synchronized methods
     * produce and consume.
     * Both methods have synchronized block and to execute requires this
     * class object lock.
     */
    static class ProduceAndConsume {
        int capacity = 3;
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        /**
         * Produce method can produce maximum of three elements in to queue and
         * waits if maximum capacity is reached.Else it adds data to the queue and notify the other
         * thread waiting for the resource lock after each add .
         */
        public void produce() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    if (q.size() == capacity) {
                        this.wait();
                    }
                    q.add(++count);
                    System.out.println("produced :: " + count);
                    this.notify();
                    Thread.sleep(1000);
                }
            }
        }

        /**
         * Consume method waits if the queue size is zero.
         * else remove element from queue and notify after each removal
         */

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    if (q.size() == 0) {

                        this.wait();
                    }
                    Integer temp = q.remove();
                    System.out.println("Consumed :: " + temp);
                    this.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceAndConsume p = new ProduceAndConsume();

        //Thread  1
        Thread t1 = new Thread(() ->
        {
            try {
                //Thread 1 calls ProduceAndConsume produce method handling it within try and catch.
                p.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //Thread t2
        Thread t2 = new Thread(() ->
        {
            try {
                //Thread 2 calls ProduceAndConsume consume method Handling it within try and catch.
                p.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

    }
}
