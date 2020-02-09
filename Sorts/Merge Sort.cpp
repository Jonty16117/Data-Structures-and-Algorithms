//Merge Sort 
#include <iostream>
using namespace std;

	void merge (int *arr, int start, int middle, int end){
		int i = start; // points to the index of the left part
		int j = middle + 1; //points to the index of the right part
		
		int temp_arr[end - start + 1];
		int k = 0; //points to the temporary array index
		
		while (i <= middle && j <= end){
			if (arr[i] <= arr[j]){
				temp_arr[k] = arr[i];
				i++;
				k++;
			}	
			else {
				temp_arr[k] = arr[j];
				j++;
				k++;
			}
		}	
		while (i <= middle){
			temp_arr[k] = arr[i];
			i++;
			k++;
		}	
		while (j <= end) {
			temp_arr[k] = arr[j];
			j++;
			k++;
		}
		for (int i = 0; i < k; i++){
			arr[start] = temp_arr[i];
			start++;
		}
	}
	
	void mergesort (int *arr, int start, int end) {
		if (start < end){
			int middle = (start + end) / 2;
			
			mergesort (arr, start, middle);
			mergesort (arr, middle + 1, end);
			merge (arr, start, middle, end);
		}
	}
	

int main (){
	int size;
	cin >> size;
	int array[size];
	
	for (int i = 0; i < size; i++)
		cin >> array[i];
		
	mergesort(array, 0, size-1);
	cout << "Sorted Array is: ";
	
	for (int i = 0; i < size; i++)
		cout << array[i] << "\t";
		
	cout << endl;

	return 0;
}

