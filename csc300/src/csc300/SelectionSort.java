package csc300;

/*
 * Lillian Hunt
 * Section 502
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class SelectionSort {
	
    // Method to perform selection sort on an array of strings
	public static String[] selectionSort(String[] array) {
        // Outer loop to iterate through each element in the array
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;  // Assume the current index is the smallest
            // Inner loop to compare current element with the rest of the array
			for (int j = i + 1; j < array.length - 1; j++) {
				// Compare strings lexicographically
				if (array[j].compareTo(array[minIndex]) < 0) {
                    // Swap if a smaller string is found
					String temp = array[j];
					array[j] = array[minIndex];
					array[minIndex] = temp;
				}
			}
		}
        // Return the sorted array
		return array;
	}
	
    // Method to read all strings from a scanner (used to read file content)
	public static String[] readAllStrings(Scanner scanner) {
        // If the scanner doesn't have any content, return an empty array
        if (!scanner.hasNextLine()) {
            return new String[0];
        }

        // Read the entire content as one string
        String text = scanner.useDelimiter("\\A").next();
        // Split the text into words by spaces and return as an array of strings
        String[] allStrings = text.split("\\s+");
        return allStrings;
    }
	
    // Main method that reads a file, sorts the words, and prints the last 20 sorted words
	public static void main(String[] args) {
        String[] words = null;
        String fileName = "data/xmltest1.txt"; // Path to the input file

        try {
            // Create a scanner to read from the file
            Scanner input = new Scanner(new File(fileName));
            // Read all strings from the file
            words = readAllStrings(input);
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("Error: The file " + fileName + " was not found.");
        } catch (Exception e) {
            // Handle general exceptions during file reading
            System.out.println("Error reading from file.");
        }

        // Sort the words using selection sort
        String[] sortedWords = selectionSort(words);
        // Start index for the last 20 sorted words
        int startIndex = sortedWords.length - 20;        

        // Print the last 20 words from the sorted array
        for (int i = startIndex; i < sortedWords.length; i++) {
            System.out.print(sortedWords[i] + " ");
        }
        System.out.println();  
	}
}
