package Data_Structures;

public class binarySearchTree {
	Node root;
	
	public boolean insert(int data) {
		//gets new tree (with new node inserted under it) assinged to this root through getNewNode
		root = getNewNode(root, data);
		return true;
	}
	public void show() {
		showInorder(root);
	}
	public boolean deleteItem(int data) {
		root = delete(root, data);
		return true;
	}

	/*
	Utility functions used in other functions above
	*/
	//gets new tree with the new node inserted under it
	private Node getNewNode(Node root, int data) {
		if(root == null) {
			root = new Node();
			root.data = data;
			return root;
		}
		else if(data < root.data) 
			root.lchild = getNewNode(root.lchild, data);
		else if(data >= root.data)
			root.rchild = getNewNode(root.rchild, data);
		return root;
	}
	//deletes the node with where node.data = data, in the tree whose root = root
	private Node delete(Node root, int data) {
		//if the tree is empty
		if(root == null) return root;

		else if(data < root.data) {
			root.lchild = delete(root.lchild, data);
		}
		else if(data > root.data) {
			root.rchild = delete(root.rchild, data);
		}

		//match found
		else {

			//if the node to be deleted is a leaf node(or it does not have any children)
			if(root.lchild == null && root.rchild == null) {
				root = null;
			}
			//if the node to be deleted has a right child and no left child
			else if(root.lchild == null) {
				root = root.rchild;
			}
			//if the node to be deleted has a left child and no right child
			else if(root.rchild == null) {
				root = root.lchild;
			}
			//if the node to be deleted has two nodes under it(i.e. both left and right child)
			else {
				//copy the min value from right child to the node to be deleted(current node)
				root.data = findMinVal(root.rchild);
				//delete the right of the current node, whose value has already been copied above
				root.rchild = delete(root.rchild, data);
			}
		}
		return root;
	}
	//finds the minimum data value in the tree
	private int findMinVal(Node root) {
		int data = root.data;
		while(root.lchild != null) {
			data = root.lchild.data;
			root = root.lchild;
		}
		return data;
	}
	//Inorder traversal of the tree(DFS)(Recursive method)
	private void showInorder(Node pointer) {
		if(pointer != null) {
			showInorder(pointer.lchild);
			System.out.println(pointer.data);
			showInorder(pointer.rchild);
		}
	}
}

class Node {
	public Node rchild;
	public int data;
	public Node lchild;
}
