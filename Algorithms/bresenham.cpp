#include <iostream>

using namespace std;

/*void bresenham(int x0, int y0, int x1, int y1) {
	int dy = y1 - y0;
	int dx = x1 - x0;
	
	if(dx > dy) { 
		int slopeError = 2*dy - dx;
		
		for(int x = x0, y = y0; x <= x1; x++) {
			cout << "(" << x << ", " << y << ")\n";
			slopeError += 2*dy;
			
			if(slopeError >= 0) {
				y++;
				slopeError -= 2*dx;
			}
		}
	}
}*/

void bresenham(int x0, int y0, int x1, int y1) {
	int dy = y1 - y0; //change in y
	int dx = x1 - x0; //change in x
	
	if(dx > dy) { 
		float slopeError = (float)dy/(float)dx; //sloap (dy/dx)
		
		for(int x = x0, y = y0; x <= x1; x++) {
			cout << "(" << x << ", " << y << ")\n";
			//cout << "slopeError before: " << slopeError << endl;
			slopeError += dy;
			//cout << "slopeError after: " << slopeError << endl;

			if(slopeError >= 0.5) {
				y++;
				slopeError -= 1;
			}
		}
	}
}

int main()
{
	int x0, y0, x1, y1;
	cout << "Enter the starting co-ordinates: ";
	cin >> x0 >> y0;
	cout << "Enter the ending co-ordinates: ";
	cin >> x1 >> y1;
	cout << "The points to be selected are: \n";

	bresenham(x0, y0, x1, y1);
	return 0;
}
