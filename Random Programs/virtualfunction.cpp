#include <iostream>
using namespace std;

class parent {
	
	public:
	virtual void function1() {
		cout << "This is the first function of parent class." << endl;
	}
	void function2() {
		cout << "This is the second function of parent class." << endl;
	}
};

class child : public parent {
	
	public:
	void function1() {
		cout << "This is the first function of child class." << endl;
	}
	void function2() {
		cout << "This is the second function of child class." << endl;
	}
};

int main() {
	parent *pptr, obj1;
	child *cptr, obj2;
	pptr = &obj1;
	pptr -> function1(); //dynaminc binding will be done in runtime (because the function is declared as virtual)
	pptr -> function2(); /*static binding will be done in compile time (because in compile time, compiler knows 
						 only data type of the pptr and not what's inside it(pptr)) */
	
	pptr = &obj2;
	pptr -> function1(); //dynaminc binding will be done in runtime (because the function is declared as virtual)
	pptr -> function2(); /*static binding will be done in compile time (because in compile time, compiler knows 
						 only data type of the pptr and not what's inside it(pptr)) */
	
	/*cptr = &obj1;      //will show error because child class pointer cannot point to the parent class object(obj1)
	cptr -> function1(); 
	cptr -> function2(); 
	*/
	
	cptr = &obj2;
	cptr -> function1();
	cptr -> function2(); 
	
	return 0;
}
