package com.m.g.java.eight;

import java.util.Optional;

public class OptionalOfNullableCheck {

    public static void main(String[] args) throws Exception {

        String input = null;

        Optional.ofNullable(input).ifPresent(data ->
        {
            System.out.println("Entered the block:");
            try {
                Optional.ofNullable(input).filter(i -> i.length() > 6).orElseThrow(Exception::new);
            } catch (Exception e) {

                e.printStackTrace();
            }

            System.out.println("Data got " + data);
        });
        System.out.println("Completed");

    }
}
