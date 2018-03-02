package com.m.g.java.basics;

/**
 * If a class has private constructor then to get
 * the instance of the class we can write a static method
 * which returns the instance of the class to outer world.
 */

public class ClassNotInheritableWithoutFinal {
    public static void main(String[] args) {
        NonInheritable instance = NonInheritable.getInstance();
        String data = instance.getData();
        System.out.println("Data "+data);
    }
}
class NonInheritable
{
    private NonInheritable()
    {

    }
    public static NonInheritable getInstance()
    {
        return  new NonInheritable();
    }
    public String getData()
    {
        return "Gayi";
    }
}