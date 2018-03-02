package com.m.g.java.basics;

public class MathematicalUnaryOperator {

    public static void main(String[] args) {

    int diffentValue  = 10 + + 11 - - 12 + + 13 - - 14 + + 15;
    System.out.println("Different value : "+diffentValue);

        /**
         * Explanation : we can use urary operators in the above way which will finally appear like this in the following way:
         *
         * = 10 + (+ 11) - (-12) + (+13) - (-14) + (+15)
         *
         * so the final calculation will be :
         *
         * = 10 + 11 +12 + 13 + 14 + 15
         */
    }
}

/**
 * Output:
 * =======
 * Different value : 75
 */