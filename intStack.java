package Data_Structures;

public class intStack {
	private int[] stack;
	private int top = -1;
	
	intStack() {
		stack = new int[50];
	}
	intStack(int size) {
		stack = new int[size];
	}
	
	public boolean push(int item) {
		if(!isFull()) {
			top++;
			stack[top] = item;
			return true;
		}
		else
		return false;
	}
	public String pop() {
		if(!isEmpty()) {
			top--;
			return ("Removed: " + stack[top+1]);
		}
		else
			return ("Pop failed");
	}
	public boolean isFull() {
		return (top == stack.length - 1);
	} 
	public boolean isEmpty() {
		return (top == -1);
	}
	public void showStack() {
		for(int i = 0; i <= top; i++) {
			System.out.println("Element at " + i + " = " + stack[i]);
		}
	}
}

