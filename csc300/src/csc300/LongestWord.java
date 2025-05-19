package csc300;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestWord {

    // Method to find the longest word in a given array of strings
    public static String findLongest(String[] array) {
        int longestLength = 0; // Variable to track the length of the longest word found
        String longestWord = " "; // Variable to store the longest word (initially empty space)
        
        // Loop through each word in the array
        for (String word : array) {
            // Check if the current word is longer than the previously found longest word
            if (word.length() > longestLength) {
                longestLength = word.length(); // Update the length of the longest word
                longestWord = word; // Update the longest word
            }
        }
        
        // Return the longest word found
        return longestWord;
    }
    
    public static void main(String[] args) {
        // Path to the text file
        String fileName = "data/origin.txt";
        
        // Create an ArrayList to store the words from the file
        ArrayList<String> list = new ArrayList<>();
        
        try {
            // Open the file using a Scanner to read its contents
            Scanner input = new Scanner(new File(fileName));
            
            // Read each word in the file and add it to the ArrayList
            while (input.hasNext()) {
                String word = input.next();
                list.add(word); // Add each word to the list
            }
            
            // Convert the ArrayList to an array
            String[] array = list.toArray(new String[0]);
            
            // Find the longest word from the array
            String longestWord = findLongest(array);
            
            // Print out the longest word found
            System.out.println("The longest word is: " + longestWord);
            
        } catch(FileNotFoundException e) {
            // If the file is not found, print an error message and exit the program
            System.out.println("File not found");
            System.exit(0); // Terminate the program if the file is missing
        }
    }
}
