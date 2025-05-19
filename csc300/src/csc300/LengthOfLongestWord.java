package csc300;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LengthOfLongestWord {

	public static String findLongest(String[] array) {
		int longestLength = 0;
		String longestWord =" ";
			for (String word : array) {
				if (word.length() > longestLength) {
					longestLength = word.length();
					longestWord = word;
				}
			}
		return longestWord;

		
	}
	
	public static void main(String[] args) {
		String fileName = "data/origin.txt";
		ArrayList<String> list = new ArrayList<>();
		
		
		try {
			Scanner input = new Scanner(new File(fileName));
			while (input.hasNext()) {
				String word = input.next();
				list.add(word);
			}	
			
			String[] array = list.toArray(new String[0]);
			
			String longestWord = findLongest(array);
			System.out.println("The longest word is: " + longestWord);
		} catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
	
		
	}
}
}
