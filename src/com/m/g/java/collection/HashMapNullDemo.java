package com.m.g.java.collection;
/***
 * Whenever a key is null. HashMap places
 * the key in '0'index.HashMap allows only one
 * key and whenever another null key wants to be placed
 * It replaces the value of earlier null.
 * This is as per the HashMap properties.
 */

import java.util.HashMap;
import java.util.Map;

public class HashMapNullDemo {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "gayi");
        map.put(2, "mani");
        map.put(null, "family");
        map.put(null,"Love");
        System.out.println(map);

    }


}
