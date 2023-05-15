//package com.search;

public class BinarySearch {

	static int binarySearch(int array[], int target, int low, int high) {

		if (high >= low) {
			int mid = low + (high - low) / 2;

			if (array[mid] == target)
				return mid;

			if (array[mid] > target)
				return binarySearch(array, target, low, mid - 1);
			
			return binarySearch(array, target, mid + 1, high);
		}

		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = { 10, 45, 8, 56, 27, 1 };
		int length = array.length;
		int target = 56;
		
		System.out.println("Index of target : " +binarySearch(array, target, 0, length));

		
	}
}

