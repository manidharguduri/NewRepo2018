package com.m.g.java.constructor;

/**
 * Super() must be the first statement in a constructor
 *
 */

public class ConstructorFistLine {
    public static void main(String[] args){
        ConstructorFistLineA ca=new ConstructorFistLineB();

    }}

class ConstructorFistLineA
{
    public ConstructorFistLineA()
    {

    }
}

class ConstructorFistLineB extends ConstructorFistLineA
{
    public ConstructorFistLineB()
    {
        System.out.println("Hello");
    }
}