package com.m.g.java.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilterElseException {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();

        Optional.ofNullable(strings).filter(input ->!input.isEmpty()).orElseThrow(RuntimeException::new);

    }
}
