package csc300;

/*
 * Lillian Hunt
 * CSC300 Section 502
 * 
 * This program reads an XML file, tokenizes it using XMLToken,
 * and checks for proper nesting of XML tags using a stack.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Stack;

public class ParseXML {

    /**
     * Reads all strings from a Scanner and returns them as an array of words.
     * @param scanner The Scanner object reading the file.
     * @return An array of strings representing all words in the file.
     */
    public static String[] readAllStrings(Scanner scanner) {
        if (!scanner.hasNextLine()) return new String[0]; // Return empty array if file is empty

        String text = scanner.useDelimiter("\\A").next(); // Read entire file content
        return text.split("\\s+"); // Split content into words based on whitespace
    }

    public static void main(String[] args) throws Exception {
        String fileName = args[0]; // Get the file name from command line arguments
        ArrayList<XMLToken> tokens = new ArrayList<>(); // List to store XML tokens
   
        try (Scanner input = new Scanner(new File(fileName))) {
            String[] words = readAllStrings(input); // Read words from file

            // Convert each word into an XMLToken object and store it in the list
            for (String word : words) {
                tokens.add(new XMLToken(word));
            }
            
            Stack<String> tagStack = new Stack<>(); // Stack of Strings to track opening tags
            
            // Process each token and check XML tag nesting
            for (XMLToken token : tokens) {
                
                if (token.isOpeningTag()) { // If it's an opening tag
                    System.out.println("Opening tag: " + token);
                    String tag = token.getTagName();
                    tagStack.push(tag); // Push tag onto stack
                    
                } else if (token.isClosingTag()) { // If it's a closing tag
                    System.out.println("Closing tag: " + token);
                    
                    if (tagStack.isEmpty()) { // If there's no matching opening tag
                        throw new Exception("Found a closing tag with no matching opening tag.");
                    }
                    
                    String tag = token.getTagName(); // Get closing tag name
                    String lastOpeningTag = tagStack.pop(); // Pop last opening tag from stack
                    
                    if (!tag.equals(lastOpeningTag)) { // If tags don't match, throw an error
                        throw new Exception("Found a closing tag that does not match its opening tag");
                    }
                }
            }
            
            if (!tagStack.isEmpty()) { // If there are unmatched opening tags left
                throw new Exception("There are opening tags with no matching closing tags");
            }
             
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file " + fileName + " was not found.");
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
