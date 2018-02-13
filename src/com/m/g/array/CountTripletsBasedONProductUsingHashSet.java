package com.m.g.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * This Problem either takes o(n3) using naive method or O(n2) using hashmap.
 * Efficeient way is by usin hashmap which takes O(n2).
 * 
 * @author lbhallamudi
 *
 */

public class CountTripletsBasedONProductUsingHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 6, 2, 3, 8 };

		int resCount = CountTripletsBasedONProductUsingHashSet.CountNumberOfTripletsOfAProductUsingHashSet(arr, 24);
		System.out.println(resCount);

		int[] arr1 = { 0, 4, 6, 2, 3, 8 };

		int res1Count = CountTripletsBasedONProductUsingHashSet.CountNumberOfTripletsOfAProductUsingHashSet(arr1, 18);
		System.out.println(res1Count);

	}

	public static int CountNumberOfTripletsOfAProductUsingHashSet(int[] arr, int product) {

		int count = 0;

		Map<Integer, Integer> hs = new TreeMap<>();
		// Adding elements to a hash Set
		for (int index = 0; index < arr.length; index++) {
			hs.put(arr[index], index);
		}

		// Run two loops.Outer loop make a element constant.
		// Run through all the remaining elements in an array Using Inner Loop.

		for (int index = 0; index < arr.length - 1; index++) {
			for (int innerIndex = index + 1; innerIndex < arr.length; innerIndex++) {

				// Check if the two elements of triplet is less than or equal to
				// the given product and
				// Product should be exactly divisible by these two elemnts i.e
				// product % (arr[index] * arr[innerIndex]) ==0
				// and the product of arr[index] * arr[innerIndex] should be
				// equal to zero.

				if (arr[index] * arr[innerIndex] != 0 && product % (arr[index] * arr[innerIndex]) == 0
						&& arr[index] * arr[innerIndex] <= product) {
					int thirdElementInaTriplet = product / (arr[index] * arr[innerIndex]);

					// Here check the first element and second elemnt not equal
					// to the thirdElementInaTriplet
					// and triplet is a not previously used triplet by using
					// their indexes i.e index and innerIndex is less than
					// the thirdElemntIndwex

					if (thirdElementInaTriplet != arr[index] && thirdElementInaTriplet != arr[innerIndex]
							&& hs.containsKey(thirdElementInaTriplet) && hs.get(thirdElementInaTriplet) > index
							&& hs.get(thirdElementInaTriplet) > innerIndex) {

						count = count + 1;

					}

				}

			}

		}

		return count;

	}

}
