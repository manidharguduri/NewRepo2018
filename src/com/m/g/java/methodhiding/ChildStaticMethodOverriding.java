package com.m.g.java.methodhiding;

/**
 * If the child method has static modifier and parent has no static modifier
 * then overriding the method in child class raises compilation error in child.
 * 
 * compilation error: This static method cannot hide the instance method from
 * ChildStaticMethodOverriding.StaticMethodOverridingParent
 *
 */
class ChildStaticMethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class StaticMethodOverridingParent {
		public void m1() {
			System.out.println("Parent class m1 method");
		}
	}

	class StaticMethodOverridingChild extends StaticMethodOverridingParent {

		// The below method raises compilation error since child overridden
		// method has static
		// modifier
		// and parent class method has no static modifier.

		// compilation error : This static method cannot hide the instance
		// method from
		// ChildStaticMethodOverriding.StaticMethodOverridingParent.

		/*
		 * public static void m1() { System.out.println("Child class m1 method "
		 * ); }
		 */

	}

}
