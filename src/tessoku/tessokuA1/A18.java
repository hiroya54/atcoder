package tessoku.tessokuA1;

import java.util.Scanner;

public class A18 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		int[] a = new int [n+1];
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		
		boolean[][] dp = new boolean[n+1][s+1];
		//境界条件
		dp[0][0] = true;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=s;j++) {
				if(dp[i-1][j]) dp[i][j]=true;
				if(j-a[i]>=0 && dp[i-1][j-a[i]]) dp[i][j]=true;
			}
		}
		for(int i=0;i<=n;i++) {
			if(dp[i][s]) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}

}
