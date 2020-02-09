import java.util.Vector;
import java.util.Scanner;

class FindPrime {
	public static Vector<Integer> findprime(int upto_n) {
		Vector<Integer> arrayOfPrime = new Vector<Integer>();
		
		if(upto_n == 0)
			return arrayOfPrime;
		
		else if(upto_n == 1) {
			arrayOfPrime.add(1);
			return arrayOfPrime;
		}
		
		else {
			//Sieve of heratosthenes
			int[] check = new int[upto_n+1];
			
			for(int i = 2; i*i <= upto_n; i++) {
				//'0' means the number is prime
				if(check[i] == 0) {
					//marking all the multiples of ith number '1'(or non prime)
					for(int j = i*i; j <= upto_n; j+=i)
						check[j] = 1;
				}
			}

			arrayOfPrime.add(1);
			for(int k = 2; k <= upto_n; k++) {
				if(check[k] == 0)
					arrayOfPrime.add(k);
			}

			return arrayOfPrime;
		}
	}

	public static void printTriangle(int levels) {
		for(int i = 1; i <= levels; i++) {
			
			//for printing spaces
			for(int j = levels - i; j >= 1; j--)
				System.out.print(" ");
			
			//for printing star symbol
			for(int j = 1; j <= i; j++)
				System.out.print("* ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		System.out.println("Enter the number of levels you need in Pascals triangle: ");
		n = in.nextInt();
		printTriangle(n);
		//System.out.println(findprime(n));
	}
}
