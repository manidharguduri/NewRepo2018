package com.m.g.java.basics;

/**
 * Variables follow Static polymorphism.
 * Methods support Dynamic Polymorphism.
 * Whenever we have parent reference holding Child Object.
 * If a method is present in child class only but not in parent class.Then we need to get the parent referrence type Casted to Child class
 * reference and then call the child specific method.
 */

public class InheritanceOfVariablesAndMethods {

    public static void main(String[] args) {

        InheritanceParent p = new InheritanceChild();
        p.m1();
        //p.m2();
        System.out.println(p.i);
        InheritanceChild c = (InheritanceChild) p;
        System.out.println(c.i);
        c.m1();
        c.m2();

    }
}

class InheritanceParent {
    int i = 20;

    public void m1() {
        System.out.println("Parent m1 method");

    }

}

class InheritanceChild extends InheritanceParent {
    int i = 200;

    public void m1() {
        System.out.println("Child m1 method");

    }

    public void m2() {

        System.out.println("Child m2 method");
    }

}



