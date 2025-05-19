package csc300;
/*
 * Lillian Hunt
 * Section 502
 */
import java.util.Scanner;

public class EuclidMethod {
	
	public static int euclid(int i, int j) {
	    if (j == 0) {
	        return i;
	    }
	    return euclid(j, i % j);
	}

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			
			System.out.print("Please enter a value for i ");
			int i = input.nextInt();
			System.out.print("Please enter a value for j ");
			int j = input.nextInt();
			
			if (i <= 0 || j <= 0) {
					throw new IllegalArgumentException("Negative numbers or 0 are not allowed.");
			}
			
			int find_euclid = euclid(i, j);
			System.out.print("The euclid method for the given numbers results in "+ find_euclid); 
		
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			input.close();
		}
		
	}
	
}