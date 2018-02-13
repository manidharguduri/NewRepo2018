package com.m.g.array;

/*
 * Problem Statement:
 * =================
 * Count number of triplets with product equal to given number
   Given an array of distinct integers(considering only positive numbers) and a number
   find the number of triplets with product equal.

	Examples:

	Input : arr[] = { 1, 4, 6, 2, 3, 8}
	            m = 24
	Output : 3
	{1, 4, 6} {1, 3, 8} {4, 2, 3}

	Input : arr[] = { 0, 4, 6, 2, 3, 8}
	            m = 18
	Output : 0
 *
 * **/

public class CountTripletsBasedOnProductNavie {
    int count = 0;

    public int findProductTriplets(int[] arr, int product) {
        for (int index = 0; index < arr.length - 2; index++) {
            for (int index1 = index + 1; index1 < arr.length - 1; index1++) {
                for (int index2 = index1 + 1; index2 < arr.length; index2++) {

                    if (arr[index] * arr[index1] * arr[index2] == product) {
                        count = count + 1;
                    }
                }
            }
        }

        return count;

    }


    public static void main(String[] args) {

        CountTripletsBasedOnProductNavie c = new CountTripletsBasedOnProductNavie();

        int[] arr = {1, 4, 6, 2, 3, 8};
        int product = 24;
        //  c.findProductTriplets(arr, product);

        int[] arr1 = {0, 4, 6, 2, 3, 8};
        int product1 = 18;
        int res = c.findProductTriplets(arr1, product1);
        System.out.println(res);

        int[] arr2 = {0, 4, 6, 2, 3, 8, 1, 5};
        int product2 = 10;
        //    c.findProductTriplets(arr2, product2);


    }


}
