package com.m.g.java.methodoverloading;

public class ParentChildObjectsOverloaded {


    public void method(Parent p)
    {
        System.out.println("Parent Argument method is called...");
    }

    public void method(Child p)
    {
        System.out.println("Child Argument method is called...");
    }

    public static void main(String[] args) {

        ParentChildObjectsOverloaded pcoo = new ParentChildObjectsOverloaded();

        pcoo.method(new Child()); // Child argument method will be called.

        Parent p = new Child();
        pcoo.method(p); // parent argument method will be called.
    }
}


class Parent
{

}

class Child extends Parent
{

}
