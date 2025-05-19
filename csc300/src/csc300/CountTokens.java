package csc300;

/* 
 * Lillian Hunt
 * Section 502
 * 
 * This program reads an XML file, processes its tokens, and counts the number of words,
 * opening tags, and closing tags using the XMLToken class.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountTokens {
    
    /**
     * Reads all strings from a given Scanner and returns them as an array of words.
     * This method uses a delimiter to read the entire file content as a single string
     * and then splits it into individual words using whitespace.
     *
     * @param scanner The Scanner object reading the file.
     * @return An array of strings representing all words in the file.
     */
    public static String[] readAllStrings(Scanner scanner) {
        if (!scanner.hasNextLine()) // If there's no content in the file, return an empty array
            return new String[0];

        String text = scanner.useDelimiter("\\A").next(); // Read entire file content
        String[] allStrings = text.split("\\s+"); // Split by whitespace to get words
        return allStrings;
    }
    
    public static void main(String[] args) {
        // Retrieves the file name from command line arguments
        String fileName = args[0];
        
        ArrayList<String> list = new ArrayList<>(); // List to store words from the file
        int wordCounter = 0; // Counter for words (non-tag tokens)
        int openingTagCounter = 0; // Counter for opening tags
        int closingTagCounter = 0; // Counter for closing tags
        
        try {
            Scanner input = new Scanner(new File(fileName)); // Open the file for reading

            // Read all words from the file and store them in a list
            while (input.hasNext()) {
                list.add(input.next());
            }
            input.close(); // Close the scanner

            // Convert list to an array for processing
            String[] array = list.toArray(new String[0]);

            // Process each token to determine if it's a word, opening tag, or closing tag
            for (String word : array) {
                XMLToken token = new XMLToken(word); // Create an XMLToken object
                
                if (!token.isTag()) { // If it's not a tag, it's a regular word
                    wordCounter++;
                }
                
                if (token.isOpeningTag()) { // If it's an opening tag, increment counter
                    openingTagCounter++;
                }
                
                if (token.isClosingTag()) { // If it's a closing tag, increment counter
                    closingTagCounter++;
                }
            }

            // Print the final counts
            System.out.println("There are " + wordCounter + " words, " + openingTagCounter + " opening tags, and " + closingTagCounter + " closing tags.");
        
        } catch (FileNotFoundException e) {
            // If the file is not found, print an error message
            System.out.println("Error: The file " + fileName + " was not found.");
        } catch (Exception e) {
            // Handle any other unexpected errors
            System.out.println("Error reading from file.");
        }
    }
}
