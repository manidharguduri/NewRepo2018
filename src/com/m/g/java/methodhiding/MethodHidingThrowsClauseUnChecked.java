package com.m.g.java.methodhiding;

/**
 * If the child class throws a Unchecked exception .The super class can throw any  exception
 * no constraints for super class.
 */

public class MethodHidingThrowsClauseUnChecked {
    public static void main(String[] args) {
        MethodHidingThrowsClauseUnCheckedParent v = new MethodHidingThrowsClauseUnCheckedChild();
        try {
         Object o= v.method1();
         System.out.println(o.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MethodHidingThrowsClauseUnCheckedParent {
    public static Number method1() throws Exception {
        System.out.println("Parent static Method 1 ");
        return null;
    }
}

class MethodHidingThrowsClauseUnCheckedChild extends MethodHidingThrowsClauseUnCheckedParent {
    public static Integer method1() throws RuntimeException{
        System.out.println("Child static method 1");
        return null;
    }

    // Suppose if i dont use covariant return type we will get the following compile error:
    //The return type is incompatible with SEParent.method1()
}