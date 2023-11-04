package tessoku.tessokuA1;

import java.util.Scanner;

public class A16 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		
		for(int i=2;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		for(int i=3;i<=n;i++) {
			b[i]=scanner.nextInt();
		}
		
		int[] dp = new int[n+1];
		//境界条件
		dp[1]=0;
		dp[2]=a[2];
		//動的計画法
		for(int i=3;i<=n;i++) {
			dp[i]=Math.min(dp[i-1]+a[i], dp[i-2]+b[i]);
		}
		
		System.out.println(dp[n]);
	}

}
