#include <string>
#include <bits/stdc++.h>
using namespace std;

void permute(string s, string p, vector<bool> b) {

	if(p.length() == s.length()) 
			cout << p << '\n';

	else{ 
		for(int i = 0; i < s.length(); i++) {
			if(b[i]) continue;
			
			b[i] = true;

			p.push_back(s[i]);
			permute(s, p, b);
			p = p.substr(0, p.size()-1);
			
			b[i] = false;
		}
	}	
}

int main() {

	string s = "abc";
	string p;
	vector<bool> b(s.length(), false);

	//using my own function defined above(permute())
	permute(s, p, b);


	//using stl algorithm
	string toPermute = "abc";
	
	do {
		cout << toPermute << '\n';
	}while(next_permutation(toPermute.begin(), toPermute.end()));

	return 0;
}

