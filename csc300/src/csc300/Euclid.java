package csc300;

import java.util.Scanner;

public class Euclid {
	
    // Method to calculate the greatest common divisor (GCD) using Euclid's algorithm
	public static int euclid(int i, int j){
        // Base case: if j is 0, return i (since GCD(i, 0) = i)
		if (j == 0) return i;

        // Recursive step: call euclid with the second argument as the remainder of i divided by j
		return euclid(j, i % j);
	}
		
    // Main method to run the program
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);  // Scanner to take user input
		
		try {
			// Prompt the user to enter values for i and j
			System.out.print("Please enter a value for i ");
			int i = input.nextInt();  // Read the first number (i)
			System.out.print("Please enter a value for j ");
			int j = input.nextInt();  // Read the second number (j)
		
			// Check if either i or j are non-positive numbers, throw an exception if true
			if (i <= 0 || j <= 0) {
					throw new IllegalArgumentException("Negative numbers or 0 are not allowed.");
			}
		
			// Call the euclid method to find the GCD of i and j
			int find_euclid = euclid(i, j);
			// Print the result of the GCD calculation
			System.out.print("The euclid method for the given numbers results in " + find_euclid); 
	
		}catch (IllegalArgumentException e) {
			// Catch the IllegalArgumentException and print the error message
			System.out.println(e.getMessage());
		} finally {
			// Close the scanner to prevent memory leaks
			input.close();
		}	
	}

}

