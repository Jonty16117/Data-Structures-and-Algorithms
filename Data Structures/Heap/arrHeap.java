package Data_Structures;

class arrHeap {
	private int size;
	private int heapArr[];
	private int capacity;
	private int heapPointer;
	private boolean heapTypeIsMin = true;

	arrHeap(int capacity) {
		this.capacity = capacity;
		heapArr = new int[capacity];
	}

	arrHeap() {
		this.capacity = 50;
		heapArr = new int[capacity];
	}

	private int returnParent(int i) {
		return ((i - 1) / 2);
	}

	private int returnLeftChild(int parent) {
		return ((parent * 2) + 1);
	}

	private int returnRightChild(int parent) {
		return ((parent * 2) + 2);
	}

	private void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private void maxheapify(int arr[], int root, int size) {
		int left = returnLeftChild(root);
		int right = returnRightChild(root);
		int biggest = root;

		if(left < size && arr[left] > arr[root]) 
			biggest = left;
		if(right < size && arr[right] > arr[biggest]) 
			biggest = right;
		if(biggest != root) {
			swap(arr, biggest, root);
			maxheapify(arr, biggest, size);
		}
	}

	private void minheapify(int arr[], int root, int size) {
		int left = returnLeftChild(root);
		int right = returnRightChild(root);
		int smallest = root;

		if(left < size && arr[left] < arr[root]) 
			smallest = left;
		if(right < size && arr[right] < arr[smallest]) 
			smallest = right;
		if(smallest != root) {
			swap(arr, smallest, root);
			minheapify(arr, smallest, size);
		}
	}
	
	public boolean insert(int data) {
		if(size == capacity) {
			System.out.println("Maximum capacity reached couldn't add more items!");
			return false;
		}
		else {
			int temp;
			heapArr[size] = data;
			heapPointer = size;
			size++;

			if(heapTypeIsMin) { 
				while(heapPointer != 0 && heapArr[returnParent(heapPointer)] > heapArr[heapPointer]) {
					swap(heapArr, returnParent(heapPointer), heapPointer);
					heapPointer = returnParent(heapPointer);
				}
			}
			else { 
				while(heapPointer != 0 && heapArr[returnParent(heapPointer)] < heapArr[heapPointer]) {
					swap(heapArr, returnParent(heapPointer), heapPointer);
					heapPointer = returnParent(heapPointer);
				}
			}
			return true;
		}
	}

	public void removeAt(int index) {
		if(heapTypeIsMin) {
			//copying the last element into this index location 
			heapPointer = index;
			heapArr[heapPointer] = heapArr[size - 1];
			size--;
			
			//heapifying
			int temp;
			while (returnRightChild(heapPointer) < size) {
				if (heapArr[heapPointer] < heapArr[returnLeftChild(heapPointer)] && heapArr[heapPointer] < heapArr[returnRightChild(heapPointer)]) { 
					break;
				}
				
				else if (heapArr[returnLeftChild(heapPointer)] < heapArr[returnRightChild(heapPointer)]) {
					swap(heapArr, returnLeftChild(heapPointer), heapPointer);
					heapPointer = returnLeftChild(heapPointer);
				}
				
				else {
					swap(heapArr, returnRightChild(heapPointer), heapPointer);
					heapPointer = returnRightChild(heapPointer);
				}
			}
		}

		else {
			//copying the last element into this index location 
			heapPointer = index;
			heapArr[heapPointer] = heapArr[size - 1];
			size--;
			
			//heapifying
			int temp;
			while (returnRightChild(heapPointer) < size) {
				if (heapArr[heapPointer] > heapArr[returnLeftChild(heapPointer)] && heapArr[heapPointer] > heapArr[returnRightChild(heapPointer)]) { 
					break;
				}
				
				else if (heapArr[returnLeftChild(heapPointer)] > heapArr[returnRightChild(heapPointer)]) {
					temp = heapArr[returnLeftChild(heapPointer)];
					heapArr[returnLeftChild(heapPointer)] = heapArr[heapPointer];
					heapArr[heapPointer] = temp;
					heapPointer = returnLeftChild(heapPointer);
				}
				
				else {
					temp = heapArr[returnRightChild(heapPointer)];
					heapArr[returnRightChild(heapPointer)] = heapArr[heapPointer];
					heapArr[heapPointer] = temp;
					heapPointer = returnRightChild(heapPointer);
				}
			}
		}
	}

	public int itemAt(int index) {
		return (heapArr[index]);
	}

	public void reverseHeap() {
		int lastRoot = returnParent(size - 1);
		
		if(heapTypeIsMin) {
			while(lastRoot >= 0) {
				maxheapify(heapArr, lastRoot, size);
				lastRoot--;
			}
		}
		else {
			while(lastRoot >= 0) {
				minheapify(heapArr, lastRoot, size);
				lastRoot--;
			}
		}
		heapTypeIsMin = !heapTypeIsMin;
	}

	public void show() {
		heapPointer = 0;
		while(heapPointer < size) {
			System.out.print(heapArr[heapPointer] + " ");
			heapPointer++;
		}
		System.out.println();
	}
}


