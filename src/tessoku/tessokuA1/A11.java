package tessoku.tessokuA1;

import java.util.Scanner;

public class A11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = scanner.nextInt();
		
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		
		int start = 1;
		int end = n;
		int mid = 0;
		while(start<=end) {
			mid = (int)Math.floor((start+end)/2);
			
			if(a[mid]==x) break;
			
			if(a[mid]<x) start=mid+1;
			else end = mid-1;
		}
		System.out.println(mid);

	}

}
