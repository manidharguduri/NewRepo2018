package com.m.g.java.basics;


public class AbstractConstructorTesting {

	public static void main(String[] args) {
		
		 new ImplMyClass();
	}
}


abstract class MyClass
{
	public MyClass(int i)
	{
		System.out.println("Abstract Constructor with args....");
	}
	
	public MyClass()
	{
		System.out.println("Abstract Constructor....");
	}
}

class ImplMyClass extends MyClass
{
	public ImplMyClass()
	{
		System.out.println("ImplMyClass Constructor....");
	}
	
	public ImplMyClass(int i)
	{
		super(10);
		System.out.println("ImplMyClass Constructor with args....");
	}
	
	
}