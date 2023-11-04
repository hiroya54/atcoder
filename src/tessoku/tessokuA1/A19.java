package tessoku.tessokuA1;

import java.util.Scanner;

public class A19 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int w = scanner.nextInt();
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			weight[i]=scanner.nextInt();
			value[i]=scanner.nextInt();
		}

		long[][] dp = new long[n+1][w+1];
		
		//境界条件
		for(int j=0;j<=w;j++) dp[0][j]=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=w;j++) {
				dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
				if(j-weight[i]>=0) dp[i][j]=Math.max(dp[i][j], dp[i-1][j-weight[i]]+value[i]);			
			}
		}
		System.out.println(dp[n][w]);
	}

}
