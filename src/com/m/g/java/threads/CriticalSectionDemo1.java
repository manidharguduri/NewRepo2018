package com.m.g.java.threads;

public class CriticalSectionDemo1 {

	static CriticalSectionDemo1SharedResource sr = new CriticalSectionDemo1SharedResource();

	public static void main(String[] args) {

		Thread t1 = new CriticalSectionDemo1Thread1(sr);
		Thread t2 = new CriticalSectionDemo1Thread2(sr);
		t1.start();
		t2.start();

	}
}

class CriticalSectionDemo1SharedResource {
	int sum = 0;

	public void getSum() {

		for (int index = 0; index < 10; index++) {
			sum = sum + index;
		}
		System.out.println(sum);
	}

}

class CriticalSectionDemo1Thread1 extends Thread {
	CriticalSectionDemo1SharedResource sr;

	public CriticalSectionDemo1Thread1(CriticalSectionDemo1SharedResource sr) {
		this.sr = sr;
	}

	public void run() {
		sr.getSum();

	}

}

class CriticalSectionDemo1Thread2 extends Thread {

	CriticalSectionDemo1SharedResource sr;

	public CriticalSectionDemo1Thread2(CriticalSectionDemo1SharedResource sr) {
		this.sr = sr;

	}

	public void run() {
		sr.getSum();
	}

}