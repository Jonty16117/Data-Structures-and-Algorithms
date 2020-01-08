#include <iostream>
using namespace std;

int max_range (int* arr, int start, int end)
{
	int rmax = arr[start];
	for (int i = start; i = end; i++)
	{
		if (rmax > arr[i])
		{
			rmax = arr[i];
		}
	}
	return rmax;
}

int min_range (int* arr, int start, int end)
{
	int rmin = arr[start];
	for (int i = start; i = end; i++)
	{
		if (rmin < arr[i])
		{
			rmin = arr[i];
		}
	}
	return rmin;
}

void counting_sort (int* arr, int start, int end)
{	
	int rmin = min_range (arr, start, end);
	int rmax = max_range (arr, start, end);
	int size = (rmax - rmin) + 1;
	int count_arr[size];
	for (int i = 0; i < size; i++)
	{
		count_arr[i] = 0;
	}
	int inc = 0;
	
	for (int i = start; i < end; i++)
	{
		for (int j = rmin; j < rmax; j++)
		{
			if (j = arr[i])
			{
				inc = count_arr[j-1];
				inc++;
				count_arr[j-1] = inc; 
			}
		}
	}
	
	for (int j = rmin; j < rmax; j++)
	{
		count_arr[j] = count _arr[j] + count _arr[j - 1];
	}
	
	for (int i = start; i < end; i++)
	{
		arr[start] = count_arr[]
	}
	
}



int main ()
{
	int n;
	cout << "Enter the no. of element you want to sort: ";
	cin >> n;
	
	int arr[n];
	
	cout << "Enter the elements to sorted in ascending order: " << endl;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
		
	counting_sort (arr, 0, n -1);

	cout << "Sorted elements are: " << endl;
	for (int i = 0; i < n; i++)
	{
		cout << arr[i] << "\t";
	}
	return 0;
}
