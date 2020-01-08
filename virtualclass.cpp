#include <iostream>
using namespace std;

class grandparent {
	public:
	int basevalue;
	void function1(int a) {
		//cin >> basevalue;
		basevalue = a;
	}
};

class parent1 : virtual public grandparent {
	
};

class parent2 : virtual public grandparent{

};

class child : public parent1, public parent2 {
	public:
	/*void function2() {
		cin >> basevalue;
		//b = basevalue;
	}*/
};

int main () {
	child object;
	object.function1(10);
	//object.function2();
	cout << object.basevalue << endl;
	return 0;
}
