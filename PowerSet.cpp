#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> generatePowerSets(vector<int> s) {
	int c = s.size();
	int n = pow(2, c);

	vector<vector<int>> ps;

	for (int i = 0; i < n; i++)	{
		vector<int> subset;
		for (int j = 0; j < c; j++) {
			if(i & (1<<j))
				subset.push_back(s[j]);
		}
		ps.push_back(subset);
	}

	return ps;
}

void printPowerSets(vector<vector<int>> p) {
	cout << "{\n";
	for(auto i: p){
		cout << "{";
		for(auto j: i)
			cout << j;
		cout << "}\n";
	}
	cout << "}" << '\n';
}

int main() {

	vector<int> s;
	s.push_back(3);
	s.push_back(5);
	s.push_back(6);
	s.push_back(7);

	printPowerSets(generatePowerSets(s));

	return 0;
}