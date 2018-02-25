package com.m.g.java.eight;

import java.util.Map;
import java.util.Optional;

public class CompleteNullCheck {

    public static void main(String[] args) {

        Map<String,Object> input = null;

        Optional<Map<String, Object>> optionalVar = Optional.ofNullable(input);


        Optional<Map<String, Object>> optionalMap = optionalVar.filter(inputVal -> inputVal.containsKey("ACTION"));

        Map<String, Object> fieldVal = optionalMap.get();

       System.out.println("Value :: "+fieldVal);


    }
}
