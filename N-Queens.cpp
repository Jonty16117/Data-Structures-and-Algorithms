#include <bits/stdc++.h>
using namespace std;

#define noOfQueens 4

static int solCount = 0;

void printBoard(int board[noOfQueens][noOfQueens]) {
	for(int i = 0; i < noOfQueens; i++) {
		for(int j = 0; j < noOfQueens; j++)
			cout << board[i][j];
		cout << '\n';
	}
}

bool isSafe(int board[noOfQueens][noOfQueens], int currentRow, int currentColumn) {
	//cout << "isSafe() function ran with board: \n";
	//printBoard(board);

	int i = currentRow;
	int j = currentColumn;
	
	while(j >= 0){
		if(board[i][j]) return false;
		j--;
	}

	j = currentColumn;
	while((i >= 0) && (j >= 0)){
		if(board[i][j]) return false;
		i--;
		j--;
	}

	i = currentRow;
	j = currentColumn;
	while((i < noOfQueens) && (j >= 0)){
		if(board[i][j]) return false;
		i++;
		j--;
	}

	return true;
}

//to get one first solution, use this function
/*bool getPossibleSolution(int board[noOfQueens][noOfQueens], int currentColumn) {
	if(currentColumn >= noOfQueens){
		printBoard(board);
		return true;
	}
	else{
		for(int i = 0; i < noOfQueens; i++) {
			if(isSafe(board, i, currentColumn)){
				board[i][currentColumn] = 1;
				if(getPossibleSolution(board, currentColumn + 1))
					return true;
				board[i][currentColumn] = 0;
			}
		}
		return false;
	}
}*/

//to get all the solutions, use this function
void getPossibleSolution(int board[noOfQueens][noOfQueens], int currentColumn) {
	if(currentColumn >= noOfQueens){
		solCount++;
		cout << "Solution no. " << solCount << ":\n";
		printBoard(board);
		cout << '\n';
		return;
	}
	else{
		for(int i = 0; i < noOfQueens; i++) {
			if(isSafe(board, i, currentColumn)){
				board[i][currentColumn] = 1;
				getPossibleSolution(board, currentColumn + 1);
				board[i][currentColumn] = 0;
			}
		}
		return;
	}
}

int main() {
	int board[noOfQueens][noOfQueens];
	for(int i = 0; i < noOfQueens; i++) {
		for (int j = 0; j < noOfQueens; j++) {
			board[i][j] = 0;
		}
	}
	//printBoard(board);

	getPossibleSolution(board, 0);

	//cout << "Total no. of solutions for " << noOfQueens << " Queens: " << solCount << '\n';

	return 0;
}
