package csc300.practice;

public class PostFixEvaluator {
	
	public static int evaluator(String expression) {
		int answer = 0;
		
		String[] tokens = expression.split("\\s+");
		for (String token : tokens ) {
			int value  = Integer.parseInt(token);
			
		}
		
		return answer;
	}
	public static void main(String[] args) {
		
	}
}
