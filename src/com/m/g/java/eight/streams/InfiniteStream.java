package com.m.g.java.eight.streams;

import java.util.stream.Stream;

public class InfiniteStream {


    public static void main(String[] args) {

        /**
         * Generates infinite amount of data based on the code specified in the generate function.
         *
         * generate function takes Supplier(FunctionalInterface) as an argument.
         */
        Stream<String> echos = Stream.generate(() -> "Echo");
        echos.forEach(echo -> System.out.print("Echo " + echo));
    }
}
