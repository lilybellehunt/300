package csc300;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random r = new Random();
		int[] array = new int[10];
		
		for (int i = 0; i < array.length; i ++) {
			array[i] = r.nextInt(50);
			
		}
		for (int value: array) {
			System.out.print(value+" ");
		}
		System.out.println();
	}
}
