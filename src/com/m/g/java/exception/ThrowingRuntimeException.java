package com.m.g.java.exception;

public class ThrowingRuntimeException {

	public static void main(String[] args) {
		ThrowingRuntimeException t = new ThrowingRuntimeException();
		// t.simpleMethod("This is thrown from custom run time exception");
		t.simpleMethod(null);
	}

	public void simpleMethod(String s) {
		if (s == null || s == "")
			throw new StringNotFoundRuntimeException(s);
		else {
			System.out.println(s);
		}
	}

}

class StringNotFoundRuntimeException extends RuntimeException {

	StringNotFoundRuntimeException(String s) {
		// System.out.println(s);
	}
}
