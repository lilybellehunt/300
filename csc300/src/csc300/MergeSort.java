package csc300;

import java.util.*;

public class MergeSort {
	
	/**
	 * Merges two sorted halves of an array into a single sorted segment.
	 * parameter: a The array to be sorted.
	 * parameter: left The starting index of the left half.
	 * parameter: mid The ending index of the left half.
	 * parameter: right The ending index of the right half.
	 */
	public static <T extends Comparable<T>> void merge(T[] a, int left, int mid, int right) {
		@SuppressWarnings("unchecked")
		T[] copy = (T[]) new Comparable[a.length]; // Temporary array for merging
		int leftIndex = left; // Start of left half
		int rightIndex = mid+1; // Start of right half
		int copyIndex = left; // Start index for merged elements
		
		/*
		 * Merge elements from the left half and right half
		 * until one of the two halves is fully copied.
		 */
		while (leftIndex <= mid && rightIndex <= right) {
			if (a[leftIndex].compareTo(a[rightIndex]) < 0) {
				copy[copyIndex] = a[leftIndex];
				leftIndex++;
			} else {
				copy[copyIndex] = a[rightIndex];
				rightIndex++;
			}
			copyIndex++;
		}
		
		/* Copy any remaining elements from the left half */
		while (leftIndex <= mid) {
			copy[copyIndex] = a[leftIndex];
			leftIndex++;
			copyIndex++;
		}
		
		/* Copy any remaining elements from the right half */
		while (rightIndex <= right) {
			copy[copyIndex] = a[rightIndex];
			rightIndex++;
			copyIndex++;
		}
		
		/* Copy elements back to the original array */
		for (int index = left; index <= right; index++) {
			a[index] = copy[index];
		}
	}
	
	/**
	 * Recursively sorts an array using the merge sort algorithm.
	 * parameter: a The array to be sorted.
	 * parameter: left The starting index.
	 * parameter: right The ending index.
	 */
	public static <T extends Comparable<T>> void mergeSort(T[] a, int left, int right) {
		int n = right - left + 1;
		// Base case: if the segment contains 1 or no elements, it is already sorted
		if (n <= 1) return;
      
		// Find the midpoint of the current segment
		int mid = (left + right) / 2;
		// Recursively sort the left half
		mergeSort(a, left, mid);
		// Recursively sort the right half
		mergeSort(a, mid+1, right);
		// Merge the sorted halves
		merge(a, left, mid, right);
	}
	
	/**
	 * Main method to test merge sort on a randomly generated array.
	 * parameter: args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Random r = new Random();
		Integer[] a = new Integer[16]; // Create an array of 16 random integers
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(100); // Fill the array with random numbers from 0 to 99
		}

		System.out.println("Before sorting: " + Arrays.toString(a)); // Print unsorted array
		mergeSort(a, 0, a.length-1); // Perform merge sort
		System.out.println("After sorting:  " + Arrays.toString(a)); // Print sorted array
	}
}
