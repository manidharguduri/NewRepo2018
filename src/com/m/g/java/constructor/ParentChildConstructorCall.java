package com.m.g.java.constructor;

/***
 *f our parent class contains a only custom constructor wiht no default
 * constructor then we should call from our child class constructor.
 *
 */

public class ParentChildConstructorCall {
    public static void main(String[] args) {

        FatherChild fc = new FatherChild(10);
        }
}
class Father {

    public Father(int i) {
        System.out.println("I am Father");
    }
}

class FatherChild extends Father {

    public FatherChild(int i) {
        super(i);
        //System.out.println("Hi"); //Implicit super constructor Father() is undefined. Must explicitly invoke another constructor
        // TODO Auto-generated constructor stub
    }

    int age = 10;

    // The below code will give compile error:
    // public FatherChild(int i)
    // {
    // System.out.println("I am Child");
    // }
    // Implicit super constructor Father() is undefined. Must explicitly invoke
    // another constructor

    // Why because?
    // if our parent class contains a only custom constructor with no default
    // constructor then we should call from our child class constructor.
}