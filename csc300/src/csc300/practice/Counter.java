package csc300.practice;

public class Counter {
	private int count;  /* instance varaible
						* private meaning variable can only be modified by methods within the class
						*/
	 
	public Counter(){
		count = 0;
		/* constructor creates variables in class. 
		 * names of constructor and class must be the same
		 */
	}
	public void increment() {
		count++;
		/*instance method. methods that allow you to access variables in class (count)
		 * 
		 */
	}
	public int value() {
		return count;
		/*instance method. methods that allow you to access variables in class (count)
		 * 
		 */
	}
	
}
