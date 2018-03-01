package com.m.g.java.methodhiding;

/**
 * Method hiding supports only covariant return type similar to method overriding.
 */

public class MethodHidingReturnType {
    public static void main(String[] args) {
        MethodHidingReturnTypeParent mp = new MethodHidingReturnTypeChild();
        mp.method1();

    }
}

class MethodHidingReturnTypeParent {
    //raises error if the return types are not covariant
    public static Number method1() {
        System.out.println("Parent static Method 1 ");
        return null;
    }
}

class MethodHidingReturnTypeChild extends MethodHidingReturnTypeParent {
    public static Integer method1() {
        System.out.println("Child static method 1");
        return null;
    }

    // Suppose if i dont use covariant return type we will get the following compile error:
    //The return type is incompatible with SEParent.method1()
}