package csc300;

import java.util.Random;

/* 
 * Lillian Hunt
 * Section 502
 */

public class TournamentMax {
	
    // Recursive method to find the maximum value in an array using the tournament method
	public static int tournamentMax(int [] a, int left, int right) {
        // Base case: if left index is greater than right, return 0 (empty segment)
		if (left > right) {
			return 0;
		}
		
        // Base case: if the segment has only one element, return that element
		if (left == right) {
			return a[left];
		}
		
        // Find the middle point of the array segment
		int middle =  (left + right) / 2;
		
        // Recursively find the maximum in the left and right halves
		int leftmax = tournamentMax(a, left, middle);
		int rightmax = tournamentMax(a, middle + 1, right);
		
        // Return the maximum of the two halves
		int max = Math.max(leftmax, rightmax);
		return max;
	}

    // Main method to test the tournamentMax function
	public static void main(String[] args) {
		Random r = new Random(); // Random number generator
		int[] array = new int[128]; // Create an array of 128 integers
		
        // Fill the array with random integers between 0 and 1023
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1024); // Random number between 0 and 1023
		}
		
        // Call tournamentMax to find the maximum value in the array
		int maxValue = tournamentMax(array, 0, array.length - 1);
		
        // Output the maximum value found
        System.out.println("Maximum Value: " + maxValue);
	}
}
