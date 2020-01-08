package Data_Structures;

public class linkedList {
	Node head = new Node();
	int size = 0;
	
	public boolean insertAtEnd(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		
		if(head == null)
			head.next = newNode;
		else {
			Node temp;
			temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		size++;
		return true;
	}
	public boolean insertAtStart(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(head == null) {
			head = newNode;
			newNode.next = null;
		}
		else {
			newNode.next = head.next;
			head.next = newNode;
		}
		size++;
		return true;
	}
	public boolean insertInOrder(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(head.next == null) {
			head.next = newNode;
			newNode.next = null;
		}
		else {
			Node nextP, prevP;
			nextP = head;
			prevP = head;
			int oldSize = size;
			while(nextP.next != null) {
				if(nextP.data > data && prevP.data <= data) {
					newNode.next = nextP;
					prevP.next = newNode;
					size++;
				}
				prevP = nextP;
				nextP = nextP.next;
			}
			if(nextP.data > data && prevP.data <= data) {
				newNode.next = nextP;
				prevP.next = newNode;
				size++;
			}
			if(oldSize == size){
				insertAtEnd(data);
				size++;
			}
		}
		return true;
	}
	public int removeLast() {
		Node nextP;
		Node prevP;
		nextP = head;
		prevP = head;
		while(nextP.next != null) {
			prevP = nextP;
			nextP = nextP.next;
		}
		int data = nextP.data;
		prevP.next = null;
		return data;
	}
	public boolean removeItem(int data) {
		Node nextP, prevP;
		nextP = head;
		prevP = nextP;
		
		while(nextP.next != null) {
			if(nextP.data == data)
				break;
			prevP = nextP;
			nextP = nextP.next;
		}
		prevP.next = nextP.next;
		return true;
	}
	public void show() {
		Node pointer;
		pointer = head;
		System.out.print("Head");
		while(pointer.next != null) {
				pointer = pointer.next;
				System.out.print(" -> " + pointer.data);
		}
		System.out.println();
	}	
}

class Node {
	public int data;
	public Node next;
}
