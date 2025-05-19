package csc300;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * lillian hunt
 * section 502
 */


public class FileStats {
	//read a list of int from a file 
	
	public static void main(String[] args) {
		String fileName = "data/ints.txt";
		ArrayList<Integer> list = new ArrayList<>();
		
		try {
			Scanner input = new Scanner(new File(fileName));
			while (input.hasNext()) {
				int number = input.nextInt();
				list.add(number);
			}	
		
		} catch(FileNotFoundException e){
		System.out.println("File not found");
		System.exit(0);
		
	}
	int sum = 0;
	for (int i: list) {
		System.out.println(sum += i);
	
	}
}

}
