package tessoku.tessokuA1;

import java.util.Scanner;

public class A02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = scanner.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scanner.nextInt();			
		}
		
		for(int i=0;i<n;i++) {
			if(a[i]==x) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}

}
