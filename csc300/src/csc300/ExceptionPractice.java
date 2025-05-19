package csc300;

import java.util.Scanner;

public class ExceptionPractice {
	
	
	public static int calculator(int t, int y) {
		
		int divide = t / y;
		
		return divide ;
		
		
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("please enter a value for t ");
			int t = input.nextInt();
			System.out.print("please enter a value for y ");
			int y = input.nextInt();
			
			if (t <= -1 || y <= -1) {
				throw new IllegalArgumentException("Only positive numbers allowed.");
				
			}
			if (y == 0) {
				throw new ArithmeticException("cannot divide by 0.");
		}
			int calc = calculator(t, y);
			System.out.println(calc);
			

		}catch(IllegalArgumentException | ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
	
	
	
}
}
