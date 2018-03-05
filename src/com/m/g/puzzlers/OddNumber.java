package com.m.g.puzzlers;

public class OddNumber {

    public static void main(String[] args) {

        System.out.println("Is this number :: -123 is Odd :: " + isOddUsingFunction(-123));
        System.out.println("Is this number :: -123 is Odd :: " + isOdd(-123));
    }

    public static boolean isOddUsingFunction(int number) {
        if (Math.abs(number) % 2 == 1) {
            return true;
        }
        return false;
    }

    /**
     * this can handle both positive and negative numbers in a efficient way...
     * @param number
     * @return
     */
    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
