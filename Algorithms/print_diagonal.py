n = 4
m = 5
matrix = [[i for i in range(m)] for i in range(n)]

def print_matrix():
    for i in matrix:
        for j in i:
            print(j, end=' ')
        print()

def print_diagonal():
    # print all columns
    for i in range(m - 1):
        pass

def diag():
    for i in range(2*n-1):
        z = 0 if (i < n) else (i - n + 1)
        for j in range(z, (i - z + 1)):
            print(matrix[j][i - j], end=' ')
        print()

print_matrix()
#print_diagonal()
diag()

#include <stdio.h>

#define M 3
#define N 4

main(){
         int a[M][N] = {{1, 2, 3, 4}, 
                        {5, 6, 7, 8}, 
                        {9,10,11,12}};

         int i, j, t;
         for( t = 0; t<M+N; ++t)
              for( i=t, j=0; i>=0 ; --i, ++j)
                     if( (i<M) && (j<N) )
                             printf("%d ", a[i][j]);
         return 0;
}