#public size
#protected _size
#private __size

class Stack:
    def __init__(self):
        self._stack = []
        self._size = 0
   
    def push(self, x):
        self._stack.append(x)
        self._size += 1

    def pop(self):
        self._stack.pop()
        self._size -= 1

    def top(self):
        if self._size == 0:
            return -1
        else:
            return self._stack[self._size-1]

class Node:
	def __init__(self, d):
		self.data = d
		self.next = None
	
class LinkedList(Node):
	def __init__(self):
		self.head = None
		self.size = 0
	
	def insert(self, value):
		new_node = Node(value)
		print("inserted {}".format(value))
		if self.size == 0:
			self.head = new_node
			self.size += 1
		else:
			temp = self.head
			while temp.next is not None:
				temp = temp.next
			temp.next = new_node
			self.size += 1
	
	def delete(self, value):
		if self.size == 0:
			print("list is already empty!")
		elif self.head.data == value:
			if self.size != 1:
				self.head = self.head.next
				print("removed {}".format(value))
			else:
				self.head = None
				print("removed {}".format(value))
			self.size -= 1
		else:
			temp = self.head
			prev = None
			while temp.data != value:
				prev = temp
				temp = temp.next
			prev.next = temp.next
			print("removed {}".format(value))
			self.size -= 1
			
	def printlist(self):
		if self.size == 0:
			print("head -> ")
			return
		temp = self.head
		print("head ", end='')
		while temp.next is not None:
			print("-> {} ".format(temp.data), end="")
			temp = temp.next
		print("-> {} ".format(temp.data))

#head -> none
#head -> <- node1 -> none
#head -> node1 -> node2	-> none
#head -> node1 -> node2 -> node3 -> none

ll = LinkedList()
ll.insert(9)
ll.insert(8)
ll.insert(7)
ll.insert(6)
ll.insert(5)
ll.insert(4)
ll.insert(3)
ll.printlist()
ll.delete(8)
ll.printlist()
ll.delete(3)
ll.printlist()
ll.delete(5)
ll.printlist()
ll.delete(9)
ll.printlist()
ll.delete(7)
ll.printlist()
ll.delete(6)
ll.printlist()
ll.delete(4)
ll.printlist()       
     
 
 
 
 
 
 



 






