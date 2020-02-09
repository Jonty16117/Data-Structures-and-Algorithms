package Data_Structures;

public class doublyLinkedList {
	Node head;
	int size;
	
	public boolean insertAtEnd(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		if(head == null) {
			head = newNode;
			newNode.prev = null;
			size++;
		}
		else {
			Node pointer = head;
			while(pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = newNode;
			newNode.prev = pointer;
			size++;
		}
		return true;
	}
	public void show() {
		Node pointer = head;
		System.out.print("Head");
		while(pointer.next != null) {
			System.out.print(" -> " + pointer.data);
			pointer = pointer.next;
		}
		System.out.print(" -> " + pointer.data);
	}
}

class Node {
	public Node prev;
	public int data;
	public Node next;
}
