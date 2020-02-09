package Data_Structures;;

public class intQueue {
	private int[] q;
	private int size;
	private int totalItems = 0;
	private int front;
	private int rear;
	
	intQueue() {
		size = 10;
		q = new int[size];
		front = 0;
		rear = 0;
	}
	intQueue(int size) {
		this.size = size;
		q = new int[this.size];
	}
	
	public boolean enQueue(int item) {
		if(isFull())
			return false;
		else {
			totalItems++;
			q[rear] = item;
			rear = (rear + 1) % size;
			return true;
		}
			
	}
	public boolean isFull() {
		if(size == totalItems)
			return true;
		else
			return false;
	}
	public String deQueue() {
		int item = q[front];
		totalItems--;
		front = (front + 1) % size;
		return ("Removed: " + item);
	}

	public void show() {
		System.out.println();
		for(int i = 0; i < totalItems; i++) {
			System.out.print(q[(front + i) % size] + " ");
		}
		System.out.println();
	}
}
