package com.m.g.array;

import com.m.g.util.ArrayUtil;

import java.util.Optional;

public class RotateArrayLeftWithOutExtraSpaceInternal {

    public static void main(String args[]) {

        // test case : 1
        int[] arr1 = {11, 22, 33, 44, 56, 89, 92};
        System.out.println("arr before rotating");
        ArrayUtil.printArray(arr1);
        rotateArrayToLeftByDElements(arr1, 8 % arr1.length);
        System.out.println("arr after rotating");
        ArrayUtil.printArray(arr1);

        // test case : 2
        int[] arr2 = {11, 22, 33};
        System.out.println("arr before rotating");
        ArrayUtil.printArray(arr2);
        rotateArrayToLeftByDElements(arr2, 5 % arr2.length);
        System.out.println("arr after rotating");
        ArrayUtil.printArray(arr2);


        // test case : 1
        int[] arr3 = {11};
        System.out.println("arr before rotating");
        ArrayUtil.printArray(arr3);
        rotateArrayToLeftByDElements(arr3, 1 % arr3.length);
        System.out.println("arr after rotating");
        ArrayUtil.printArray(arr3);

    }

    private static void rotateArrayToLeftByDElements(int[] arr, int distance) {
        Optional.ofNullable(arr).filter(input -> input.length > 0).ifPresent(arr1 -> {
            ArrayUtil.reverseArray(arr1, 0, distance - 1);
            ArrayUtil.reverseArray(arr1, distance, arr.length - 1);
            ArrayUtil.reverseArray(arr1, 0, arr.length - 1);
        });
    }


}
