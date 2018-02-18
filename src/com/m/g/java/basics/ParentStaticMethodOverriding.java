package com.m.g.java.basics;

/**
 * If the parent method has static modifier and child has no static modifier
 * then overriding the method in child class raises compilation error in child.
 * 
 * compilation error: This instance method cannot override the static method
 * from StaticMethodOverridingParent
 *
 */

public class ParentStaticMethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticMethodOverridingParent s = new StaticMethodOverridingChild();

	}
}

class StaticMethodOverridingParent {
	public static void m1() {
		System.out.println("Parent class m1 method");
	}
}

class StaticMethodOverridingChild extends StaticMethodOverridingParent {

	// The below method raises compilation error since parent method has static
	// modifier
	// and child class overridden method has no static modifier.

	// compilation error : This instance method cannot override the static
	// method from StaticMethodOverridingParent.

	/*
	 * public void m1() { System.out.println("Child class m1 method "); }
	 */
}
