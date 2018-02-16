package com.m.g.array;

import java.util.Arrays;

public class FindTheNextHighestElementFromAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindTheNextHighestElementFromAnArray fe = new FindTheNextHighestElementFromAnArray();
		/*
		 * int[] arr = { 3, 2, 8, 4, 1 }; int[] a =
		 * fe.findNextHighestElementInAnArray(arr); for (int index = 0; index <
		 * arr.length; index++) { System.out.println(a[index]); }
		 * System.out.println("second test case"); int[] arr1={6,9,3,8,6,5,2};
		 * int[] a1 = fe.findNextHighestElementInAnArray(arr1); for (int index =
		 * 0; index < arr.length; index++) { System.out.println(a1[index]); }
		 * System.out.println("third test case"); int[] arr2={5,3,4,9,7,6};
		 * int[] a2 = fe.findNextHighestElementInAnArray(arr2); for (int index =
		 * 0; index < arr.length; index++) { System.out.println(a2[index]); }
		 */
		System.out.println("fourth test case");
		int[] arr3 = { 4, 3, 2, 1 };
		int[] a3 = fe.findNextHighestElementInAnArray(arr3);
		for (int index = 0; index < a3.length; index++) {
			System.out.println(a3[index]);
		}

	}

	int priorIndex = 0;
	int index = 0;

	public int[] findNextHighestElementInAnArray(int[] arr) {

		index = arr.length - 1;
		priorIndex = index - 1;
		if (priorIndex > 0 && index > 0) {
			while (arr[index] < arr[priorIndex] && index > 0 && priorIndex > 0) {
				index--;
				priorIndex = index - 1;
			}
		} else {
			System.out.println("No highest element formed");
		}

		getThePriorIndexReplaced(arr, priorIndex);

		Arrays.sort(arr, priorIndex + 1, arr.length);
		return arr;

	}

	private void getThePriorIndexReplaced(int[] arr, int priorIndex) {
		// TODO Auto-generated method stub
		int index = priorIndex + 1;
		int leastLarge = Integer.MAX_VALUE;
		int temp = -1;

		while (index < arr.length) {
			if (arr[index] > arr[priorIndex] && arr[index] < leastLarge) {
				temp = index;
				leastLarge = arr[index];
			}
			index++;
		}
		swap(arr, priorIndex, temp);
	}

	private void swap(int[] arr, int priorIndex, int temp) {
		// TODO Auto-generated method stub
		if (priorIndex > 0 && temp > 0) {
			int tmp = arr[priorIndex];
			arr[priorIndex] = arr[temp];
			arr[temp] = tmp;
		}
	}

}
