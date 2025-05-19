package csc300;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	/**
	 * Partitions the array for the quicksort algorithm.
	 * parameter: a The array to be sorted.
	 * parameter: left The starting index of the partition.
	 * parameter: right The ending index of the partition.
	 * @return The index of the pivot after partitioning.
	 */
	public static <T extends Comparable<T>> int partition(T[] a, int left, int right) {
		T pivot = a[left];
		int i = left+1; // The index i will increment to the right in the array.
		int j = right;  // The index j will decrement to the left in the array.
		
		while (true) {
			// Scan right with index i to find an element in the array
			// greater than the pivot.
			while (i < right && a[i].compareTo(pivot) < 0) {
				i++;
			}
			
			// Scan left with index j to find an element in the array
			// less than the pivot.
			while(j > left && a[j].compareTo(pivot) > 0) {
				j--;
			}
			
			// When i and j meet, the partitioning is complete.
			if (i >= j) {
				break;
			}
			
			// Otherwise, swap the elements at index i, which is
			// greater than the pivot, and at index j, which is 
			// less than the pivot.
			T temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		// Swap the pivot element to where i and j met.
		T temp = a[left];
		a[left] = a[j];
		a[j] = temp;
		return j;
	}
	
	/**
	 * Sorts an array using the quicksort algorithm.
	 * parameter: a The array to be sorted.
	 * parameter: left The starting index.
	 * parameter: right The ending index.
	 */
	public static <T extends Comparable<T>> void quickSort(T[] a, int left, int right) {
		if (left >= right) return;
		int pivotIndex = partition(a, left, right);
		quickSort(a, left, pivotIndex-1);
		quickSort(a, pivotIndex+1, right);
	}
	
	/**
	 * Main method to test quicksort on a randomly generated array.
	 * parameter: args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Random r = new Random();
		Integer[] a = new Integer[16];
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(100);
		}
		System.out.println("Before sorting: " + Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println("After sorting:  " + Arrays.toString(a));
	}
}
