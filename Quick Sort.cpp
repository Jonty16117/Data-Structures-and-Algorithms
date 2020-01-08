// Quick Sort
#include <iostream>
using namespace std;

int partition(int *arr, int start, int end){
	int pivot = arr[end]; //sets last element in the array as pivot 
	int pivot_index = start; //we are assuming that index of the leftmost greatest number in the array is at start initially
	
	for (int i = start; i < end; i++){
		if (arr[i] <= pivot){
			swap(arr[i], arr[pivot_index]);
			pivot_index++;
		}
	}
	
	swap (arr[pivot_index], arr[end]);
	return pivot_index;
}

void quicksort (int *arr, int start, int end){
	if (start < end){
		int pivot_index = partition(arr, start, end); //this partition function places the pivot according to its size in the array and returns its position
		
		quicksort(arr, start, pivot_index - 1);
		quicksort(arr, pivot_index + 1, end);
	}
}

int main (){
	int size;
	cin >> size;
	int array[size];
	
	for (int i = 0; i < size; i++)
		cin >> array[i];
		
	quicksort(array, 0, size-1);
	cout << "Sorted Array is: ";
	
	for (int i = 0; i < size; i++)
		cout << array[i] << "\t";
		
	cout << endl;
	return 0;
}
