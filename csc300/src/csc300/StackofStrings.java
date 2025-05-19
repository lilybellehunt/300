package csc300;

import java.util.Stack;

public class StackofStrings {
	
	
	public static void reverseStringArray(String[] array) {
		Stack<String> stack = new Stack<>();
		for (String s : array) {
			stack.push(s);
		}
		
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}
	public static void main(String[] args){
		String[] array = {"Gandalf", "Bilbo", "Frodo", "Aragon"};
		reverseStringArray(array);
		for (String s : array) {
			System.out.print(s + " ");
		}
		System.out.println();
	
	}
	
}
