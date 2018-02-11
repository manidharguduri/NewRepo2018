package com.m.g.util;

public class ArrayUtil {

    public static void reverseArray(int[] arr, int from, int to) {

        int firstIndex1 = from;
        int lastIndex1 = to;
        while (firstIndex1 < lastIndex1) {
            int temp = arr[firstIndex1];
            arr[firstIndex1] = arr[lastIndex1];
            arr[lastIndex1] = temp;
            firstIndex1++;
            lastIndex1--;

        }

    }



    public static void printArray(int[] arr) {

        System.out.print("[");
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index]+",");
        }
        System.out.print("]");
    }

}
