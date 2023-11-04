package tessoku.tessokuA1;

import java.util.Scanner;

public class A06 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		int[] a = new int[n+1];
		int[] l = new int[q+1];
		int[] r = new int[q+1];
		
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		for(int i=1;i<=q;i++) {
			l[i]=scanner.nextInt();
			r[i]=scanner.nextInt();
		}
		
		//累積和の作成
		int[] sum = new int[n+1];
		for(int i=1;i<=n;i++) {
			if(i==0) sum[i]=0;
			else sum[i]=sum[i-1]+a[i];
		}

		for(int i=1;i<=q;i++) {
			System.out.println(sum[r[i]]-sum[l[i]-1]);
		}
	}

}
