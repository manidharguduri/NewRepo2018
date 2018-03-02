package com.m.g.java.constructor;

import java.io.IOException;

/**
 * If a base class constructor throws a checked Exception what should the child
 * class constructor throw?
 * 
 * Lets see..
 * 
 * If a base class Constructor throws a Checked Exception .Compulsory the child
 * Class Constructor should throw either same Exception or the Parent
 * Checked Exceptions.
 * 
 * If a base class constructor throws an unChecked
 * exception then there are no rules.
 * 
 * If both parent and child class throws same exception then no problem.
 * 
 * Here I have mentioned three cases
 * 
 * 1.Base class constructor throws checked exception
 * 2.Base class constructor and sub class constructor throws same checked exception. 
 * 3.Base class Constructor throws Unchecked Exception.
 * 
 * 
 * @author lbhallamudi
 *
 */

public class ThrowsClauseExceptionInConstructors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// Checked Exception in base class constructor

// This is valid since sub class constructor throws Parent exception of
// super class Checked Exception of the constructor.
// The sub class constructor can raise either same exception or Parent Exception
// of super class constructor
// when the base class constructor is checked Exception.

class A {
	A() throws IOException {

	}

}

class B extends A {

	B() throws Exception {

	}

}

// The below case is also valid Since base and sub class throws same exception

class C {
	C() throws Exception {

	}

}

class D extends C {

	D() throws Exception {
		super();

	}
}

// The below case is valid since the base class constructor throws unchecked
// exception
// No rule for sub class constructor.

class E {
	E() throws NullPointerException {

	}

}

class F extends E {

	F() throws Exception {
		super();

	}
}