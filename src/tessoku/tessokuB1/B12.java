package tessoku.tessokuB1;

import java.util.Scanner;

public class B12 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		double left = 0;
		double  right = n;
		double mid =0;
		while(right-left>0.001) {
			mid = left + (right-left)/2;
			double val = Math.pow(mid,3)+mid;
			
			if(1.0*n<val) right=mid;
			else left=mid;
			
		}
		System.out.println(mid);

	}


}
