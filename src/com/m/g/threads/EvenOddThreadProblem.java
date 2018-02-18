package com.m.g.threads;

/**
 * This EvenOddThreadProblem has two threads where one thread produce even number
 * and another thread produce odd number alternatively.
 */

public class EvenOddThreadProblem {
    /**
     * This class has two methods evenGenerator and oddGenerator.
     * evenGenerator to generate even numbers and oddGenerator to generate odd Numbers.
     */

    static class EvenAndOddNumberGenerator {
        //flag acts as a threshold for threads on when to call wait and notify
        int flag = 1;
        int evenIndex = 2;
        int oddIndex = 1;
        int n = 10;

        //This method generated odd number and dec
        public void evenGenerator() throws InterruptedException {
            synchronized (this) {
                //if capacity is zero wait for odd thread to generate odd number
                while (evenIndex <= n) {
                    if (flag == 1) {
                        wait();
                    }
                    System.out.println(evenIndex);
                    evenIndex = evenIndex + 2;
                    flag = flag + 1;
                    this.notify();
                }

            }

        }

        //This method generates odd number.
        public void oddGenerator() throws InterruptedException {
            synchronized (this) { //if capacity is zero wait for even thread to generate odd number
                while (oddIndex < n) {
                    if (flag == 0) {
                        wait();
                    }
                    System.out.println(oddIndex);
                    oddIndex = oddIndex + 2;
                    flag = flag - 1;
                    this.notify();
                }
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        EvenAndOddNumberGenerator eo = new EvenAndOddNumberGenerator();

        //Thread  1
        Thread t1 = new Thread(() ->
        {
            try {
                //Thread 1 calls ProduceAndConsume produce method handling it within try and catch.
                eo.oddGenerator();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //Thread t2
        Thread t2 = new Thread(() ->
        {
            try {
                //Thread 2 calls ProduceAndConsume consume method Handling it within try and catch.
                eo.evenGenerator();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        //We require odd thread to start first .so, t1.joi() can help.
        t1.join();
        t2.join();

        /**
         * Output :
         *
         1
         2
         3
         4
         5
         6
         7
         8
         9
         10

         Process finished with exit code 0
         */


    }


}
