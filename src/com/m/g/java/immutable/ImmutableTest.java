package com.m.g.java.immutable;

import java.util.ArrayList;
import java.util.List;

public class ImmutableTest {
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();
        al.add("anil");
        al.add("mom");
        al.add("dad");
        ImmutableClass im1 = new ImmutableClass(1, "gayi", al);
        System.out.println("Before Porting the changes :: "+al.get(1));
        im1.getAlist().set(1,"mani");
        System.out.println("After replacing the changes :: "+al.get(1));

    }
}
