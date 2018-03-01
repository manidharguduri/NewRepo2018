package com.m.g.java.basics.methodhiding;

/**
 * Even In methodHiding The scope of the child class method(static method) should be increasing.
 */

public class MethodHidingVisibilty {

// Each class can have its own static methods which are public...

}
class StaticParent
{
    private static void method1()
    {
        System.out.println("Static method in Parent");
    }
    public static void method2()
    {
        System.out.println("Static method in Parent");
    }
}
class StaticChild extends StaticParent{

    private static void method1()
    {

    }
    //	protected static void method2()
//	{
//		System.out.println("Static method in Parent");
//		Compilation error... we cannot narrow the scope even if it static method .
//	}
}
