package tessoku.tessokuA1;

import java.util.Scanner;

public class A12 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		//kの範囲
		long left = 1;
		long right=1000000000;
		
		while(left<right) {
			long mid = left + (right-left)/2;
			long sum = 0;
			//mid秒のときプリンタiで出力済みの枚数はmid/a[i]で求められる
			for(int i=1;i<=n;i++) {
				sum+=mid/(long)a[i];
			}
			
			if(k<=sum) right=mid;
			else left=mid+1;
		}
		
		System.out.println(left);

	}

}
