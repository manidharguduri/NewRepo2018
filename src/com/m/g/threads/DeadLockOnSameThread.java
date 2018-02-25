package com.m.g.threads;

public class DeadLockOnSameThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main thread is executing..");
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Never executes this since dead lock occured");
	}

}
