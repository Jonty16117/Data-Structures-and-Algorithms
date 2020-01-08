#include <iostream>
using namespace std;

void merge (int *arr, int low, int high, int mid)
{
	int p = low, q = (mid + 1); //array references for left and right parts respectively
	int temp[(high - low) + 1], k = 0; /*temporary array for storing sorted values for current left and right parts 
	and k is the array reference for array temp (and also it will be used to know the size of temp array)*/
	
	for (int i = low; i <= high; i++)
	{
		if (p > mid) //if p(left part) is over then copy the remaining(right part) elements in temp array
		{
			temp[k++] = arr[q++]; 
		}
		
		else if (q > high) //if q(right part) is over then copy the remaining(left part) elements in temp array
		{
			temp[k++] = arr[p++];
		}
		
		else if (p < q)
		{
			temp[k++] = arr[p++];
		}
		
		else
		{
			temp[k++] = arr[q++];
		}
	}
	
	for (int i = 0; i < k; i++)
	{
		arr[low++] = temp[i]; //putting temp array(sorted) data into original array arr[]
	}
	
}

void merge_sort (int *arr,int low, int high)
{
	if (low < high)
	{
		int mid = (low + high) / 2;
		merge_sort(arr, low, mid);
		merge_sort(arr, mid + 1, high);		
		merge (arr, low, high, mid);
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
		
	merge_sort (arr, 0, n - 1);

	cout << "Sorted elements are: " << endl;
	for (int i = 0; i < n; i++)
	{
		cout << arr[i] << "\t";
	}
	return 0;
}
