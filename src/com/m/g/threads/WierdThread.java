package com.m.g.threads;

/**
 * To Learn from this program :
 * <p>
 * Whenever the start method is overridden in a thread.
 * when we call thread.start() method it calls overridden method in the thread.
 * and from the overridden method if  the start method is called on the thread on the thread.
 * it calls the run method.
 * <p>
 * so, overriden start method>run method.
 */

public class WierdThread extends Thread {
    private volatile Thread stopIndicator;

    public void start() {
        stopIndicator = new Thread(this);
        System.out.println("Entered Overridden start");
        stopIndicator.start();
    }

    @Override
    public void run() {
        System.out.println("Run method is called.");
        Thread thisThread = Thread.currentThread();
        while (thisThread == stopIndicator) {
            try {
                System.out.println(" matched the condition ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {

        new WierdThread().start();
    }

    /** Output:
     * Entered Overridden start
     Run method is called.
     matched the condition
     matched the condition
     matched the condition
     matched the condition
     matched the condition
     matched the condition
     matched the condition

     Process finished with exit code 130 (interrupted by signal 2: SIGINT)
     */
}
