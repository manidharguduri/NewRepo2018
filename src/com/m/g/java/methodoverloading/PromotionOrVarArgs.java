package com.m.g.java.methodoverloading;

/**
 * vararg will be last option if we have overloaded methods.
 *
 */
public class PromotionOrVarArgs {

    public void method(double value)
    {
        System.out.println("Double value :"+value);
    }

    public void method(int... value)
    {
        System.out.println("Int vararg value :"+value);
    }

    public static void main(String[] args) {

        PromotionOrVarArgs object = new PromotionOrVarArgs();
        object.method(20);
    }


    // Promotion has more priority than widening...
}

