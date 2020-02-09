#include <iostream>
using namespace std;

struct node 
{
	int data;
	node *next;
};

class list
{
	node *head, *tail;
	
	public:
	list ()
	{
		head = NULL;
		tail = NULL;
	}
	
	void create_node (int data);
	void display_list();
};

void list::create_node (int no_of_nodes)
{
	int data;
	
	for (int i = 0; i < no_of_nodes; i++)
	{
		node *temp = new node;
		cout << "Enter data for node " << (i + 1) << endl;
		cin >> data;
		temp->data = data;
		temp->next = NULL;
	
		if (head == NULL)
		{
			head = temp;
			tail = temp;
			temp = NULL;
		}
		else
		{
			tail->next = temp;
			tail = temp;		
		}
	}
}

void list::display_list()
{
	node *temp = new node;
	temp = head;
	
	while(temp != NULL)
	{
		cout << temp->data << "\t";
		temp = temp->next;
	}
}

int main ()
{
	int no_of_nodes;
	list list1;
	cout << "Enter the no of nodes you want to create: ";
	cin >> no_of_nodes;
	list1.create_node(no_of_nodes);
	cout << "Your list is show below..." << endl;
	list1.display_list();
	return 0;
}




















