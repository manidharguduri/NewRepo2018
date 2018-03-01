package com.m.g.java.methodhiding;
import java.io.IOException;
/**
 * If the child class throws a checked exception .The super class should throw either same exception
 * or the super class exception.
 *
 */

public class MethodHidingThrowsClauseChecked {
    public static void main(String[] args) {
        MethodHidingThrowsClauseParent mchecked = new MethodHidingThrowsClauseChild();
        try {
            mchecked.method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class MethodHidingThrowsClauseParent  {
    public static Number method1() throws Exception {
        System.out.println("Parent static Method 1 ");
        return null;
    }
}

class MethodHidingThrowsClauseChild extends MethodHidingThrowsClauseParent {
    public static Integer method1() throws IOException {
        System.out.println("Child static method 1");
        return null;
    }

    // Suppose if i dont use covariant return type we will get the following compile error:
    //The return type is incompatible with SEParent.method1()
}