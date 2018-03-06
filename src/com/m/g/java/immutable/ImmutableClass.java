package com.m.g.java.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Whenever we have user/mutable objects in an immutable class.
 * common sense points are:
 *
 * Two ways the immutability concept cna be violated.
 *
 * 1) if we change the list externally it may  violate this immutability nature if we directly
 * assign the external object to our class object in the constructor.
 *
 * Solution : In our constructor we are creating a new object .Copy all the contents of external object to our class
 * and intialize this new object to our class object.
 *
 * 2) another way to violate is get the list and can make changes on the list
 *
 * Solution: Create a new object in getter and copy all contents of the list to the new object and return the object.
 */

public final class ImmutableClass {
    private final int id;
    private final String name;
    private final List<String> alist;

    ImmutableClass(int id, String name, List<String> extList) {
        this.id = id;
        this.name = name;
        List<String> tempAlist = new ArrayList();
        for (String s : extList) {
            tempAlist.add(s);
        }
        this.alist = tempAlist;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<String> getAlist() {
        List<String> al = new ArrayList<>();
        for (String s : this.alist) {
            al.add(s);
        }
        return al;
    }
}

