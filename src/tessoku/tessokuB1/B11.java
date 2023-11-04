package tessoku.tessokuB1;

import java.util.Arrays;
import java.util.Scanner;

public class B11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scanner.nextInt();
		}
		int q = scanner.nextInt();
		
		int[] x = new int[q];
		for(int i=0;i<q;i++) {
			x[i]=scanner.nextInt();
		}
		//配列aを昇順にソート
		Arrays.sort(a);
		
		for(int i=0;i<q;i++) {
			System.out.println(lower_bound(a, x[i]));
		}

	}
	
	public static int lower_bound(int[] a,int key) {
		int left = -1;
		int right = a.length;
		while(right-left>1) {
			int mid = left + (right-left)/2;
			if(key<=a[mid]) right=mid;
			else left = mid;
		}
		return right;
	}

}
