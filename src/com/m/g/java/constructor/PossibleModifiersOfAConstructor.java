package com.m.g.java.constructor;

/**
 * The allowed Modifiers of a constructor are public,protected,private,Default
 * final,static,abstract and remaining modifiers except above four are not
 * allowed modifiers for constructor.If we try to use final/static/abstract it
 * will throw compile time error.
 * 
 * Usually class modifier will be constructor modifier. If we  specify the modifiers for constructor it will be considered
 * 
 * @author lbhallamudi
 *
 */

public class PossibleModifiersOfAConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PossibleModifiersOfAConstructor pf = new PossibleModifiersOfAConstructor(6);

	}

	public PossibleModifiersOfAConstructor() {
		System.out.println("no arg Constructor");
	}

	public PossibleModifiersOfAConstructor(int i) {
		System.out.println("arg constructor");
	}

}
