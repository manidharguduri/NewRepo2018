package com.m.g.java.methodoverloading;

public class DoesDoubleMethodCatchEveryThing {
    public void method1(double value)
    {
        System.out.println("Value : "+value);
    }
    public static void main(String[] args) {


        DoesDoubleMethodCatchEveryThing ddd = new DoesDoubleMethodCatchEveryThing();


        ddd.method1(10);//int argument  ==> Working
        ddd.method1(10l);//long argument  ==> Working
        ddd.method1(20.0f);//float argument  ==> Working
    }

}
