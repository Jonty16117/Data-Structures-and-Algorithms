package Data_Structures;

class priorityQueue {
	private int capacity;
	private int size;
	private arrHeap heap;
	private boolean setPriorityToMax = true;

	priorityQueue() {
		capacity = 50;
		heap = new arrHeap(capacity);
		heap.reverseHeap();
	}

	priorityQueue(int capacity) {
		this.capacity = capacity;
		heap = new arrHeap(capacity);
		heap.reverseHeap();
	}

	public void setPriorityToMax() {
		if(!setPriorityToMax) {
			setPriorityToMax = true;
			heap.reverseHeap();
		}
	}

	public void setPriorityToMin() {
		if(setPriorityToMax) {
			setPriorityToMax = false;
			heap.reverseHeap();
		}
	}

	public boolean enqueue(int data) {
		if(size == capacity)
			return false;
		else {
			heap.insert(data);
			size++;
			return true;
		}
	}

	public String dequeue() {
		if(size == 0)
			return ("Queue empty!");
		else {
			int item = heap.itemAt(0);
			heap.removeAt(0);
			size--;
			return ("Removed: " + item);
		}
	}

	public void show() {
		heap.show();
	}
}