package com.m.g.threads;

public class CriticalSectionDemo {

	static SharedResource sr = new SharedResource();

	static Thread t1 = new Thread() {
		public void run() {
			sr.getSum(10);
		}

	};

	static Thread t2 = new Thread() {
		public void run() {
			sr.getSum(10);
		}

	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		t1.start();
		t2.start();
		/*
		 * try { t1.join(); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

}

class SharedResource {
	int sum = 0;

	public void getSum(int n) {

		for (int index = 0; index < n; index++) {

			sum = sum + index;
		}
		System.out.println(Thread.currentThread().getName() + "sum:: " + sum);
	}

}
