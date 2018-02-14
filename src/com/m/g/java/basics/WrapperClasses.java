package com.m.g.java.basics;

public class WrapperClasses {

	public static void main(String[] args) {
		// If the wrapper classes are created using valueOf method
		// and the integral data types are in the range of -127 to 128.
		// Then both will point to same object

		// Wrapper classes using value of method checks if there is a existing
		// object with same content .If yes, will point to the same object.
		Integer i = 10;
		Integer i1 = 10;
		System.out.println(i == i1);

		// Both are different Objects .So it returns false.
		Integer i3 = 10;
		Integer i4 = 20;
		System.out.println(i3 == i4);

		// for all the wrapper classes the equals method is overridden.
		Integer i5 = 30;
		Integer i6 = 30;
		System.out.println(i5.equals(i6));

		// Wrapper classes using only value of method checks if there is a
		// existing object with same content .If yes, will point to the same
		// object.
		Integer i7 = new Integer(10);
		Integer i8 = 10;
		System.out.println(i7 == i8);

		// Wrapper classes see the elemnets only in buffre range i.e -127 to 128
		// .Count of this range if two objects are compared then it
		// creates new object.

		Integer i9 = 129;
		Integer i10 = 129;
		System.out.println(i9 == i10);

	}

}
