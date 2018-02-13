package com.m.g.array;

import java.util.Arrays;

public class BinarySearchOperationUsingJavaApi {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9, 24, 7, 6};
        int resIndex = Arrays.binarySearch(arr, 3);
        System.out.println(resIndex);
    }

}
