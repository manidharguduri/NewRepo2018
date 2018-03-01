package com.m.g.java.methodoverloading;

public class CharacterArrayExample {

    public void method(char[] value)
    {
        System.out.println("Value "+value);
    }

    public void method(String value)
    {
        System.out.println("Value "+value);
    }

    public void method(Object value)
    {
        System.out.println("Value "+value);
    }

    public static void main(String[] args) {

        CharacterArrayExample cae = new CharacterArrayExample();
        //cae.method(null);

        // Compilation Error:
        // The method method(char[]) is ambiguous for the type CharacterArrayExample

        // reason:

        // String and char[] exists in same level...


    }
}
