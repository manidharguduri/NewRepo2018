package com.m.g.java.annotations;

import java.util.ArrayList;

public class SupressWarningProgram {


    public static void main(String[] args) {

        methodWithoutUsingSupressWarning();
        methodUsingSupressWarning();
    }

    public static void methodWithoutUsingSupressWarning()
    {
        ArrayList list = new ArrayList();
        list.add("Hi");
        list.add("Hello");
        System.out.println(list);

        /** Warning:
         *  Unchecked call to 'add(E)' as a member of raw type 'java.util.ArrayList' less... (⌘F1)
         */
    }

    @SuppressWarnings("unchecked")
    public static void methodUsingSupressWarning()
    {
        ArrayList list = new ArrayList();
        list.add("Hi");
        list.add("Hello");
        System.out.println(list);

        /**
         * No Warnings
         */
    }
}
