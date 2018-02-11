package com.m.g.java.basics;

public class DynamicPolyMorphismMethodResolutionDemo {

	public static void main(String[] args) {
		
		CCParent obj = new CCChild();
		obj.m1();
		obj.m2();
		CCChild ccObj=(CCChild)obj;
		ccObj.m3();
	}	
}

class CCParent
{
	public void m1()
	{
		System.out.println("Parent M1 method is called");
		this.m2();
	}
	public void m2()
	{
		System.out.println("Parent M2method is called");
	}
	
}

class CCChild extends CCParent
{
	public void m2()
	{
		System.out.println("Child M2 method is called");
	}
	
	public void m3()
	{
		System.out.println("Only child method");
	}
}