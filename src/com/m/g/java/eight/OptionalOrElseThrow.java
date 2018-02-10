package com.m.g.java.eight;

import java.util.Optional;

public class OptionalOrElseThrow {

    public static void main(String[] args) {


        String shipAN = "";
        String shipAn2 = null;

        Optional.ofNullable(shipAN).ifPresent( input->
        {
            System.out.println("Empty Value ");
        });

        Optional.ofNullable(shipAN).orElseThrow(()->
        {
            System.out.println("Entered from first block");
           return new NullPointerException();

        });

        Optional.ofNullable(shipAn2).orElseThrow(()->
        {
            System.out.println("Entered from second block");
            return new NullPointerException();

        });

    }


}
