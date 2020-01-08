#include <iostream>
#include <string>
using namespace std;



class a {
	int a;
	
	public:
	void setvalue(int a) {
		this->a = a;
	}
	
	void display() {
	cout << "The entered data is: " << a << endl;
}

};

class b {
	string a;
	
	public:
	void setvalue(string a) {
		this->a = a;
	}
	
	void display() {
	cout << "The entered data is: " << a << endl;
	}
	
};




int main() {
	a objecta;
	b objectb;
	objecta.setvalue(16);
	objectb.setvalue("helloworld");
	objecta.display();
	objectb.display();
	return 0;
}
