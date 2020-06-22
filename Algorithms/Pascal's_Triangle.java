import java.util.Vector;
import java.util.Scanner;

class PascalsTriangle {
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