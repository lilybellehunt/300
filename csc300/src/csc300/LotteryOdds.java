package csc300;

import java.util.Scanner;

/* 
 * Lillian Hunt 
 * Section 502
 */
public class LotteryOdds {
	
	
	public static long factorial(long i){
		if (i == 0) return 1;
		return i * factorial(i-1); 
	}
	
	
	public static long chances(long n, long k) {
		long numerator = 1;
		for (long i = n-k+1; i <= n; i++) {
			 numerator = numerator * i; 
			
		}
		long denominator = factorial(k);
		return numerator / denominator; 
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in );
		System.out.print("please enter a value for n");
		long n = input.nextLong();
		System.out.print("please enter a value for k");
		long k = input.nextLong();
		long odds = chances(n, k);
		System.out.print("There are "+ odds + "possible combinations");
		
		
	}

}
