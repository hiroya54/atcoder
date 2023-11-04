package tessoku.tessokuB1;

import java.util.Scanner;

public class B16 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] h = new int[n+1];
		for(int i=1;i<=n;i++) {
			h[i]=scanner.nextInt();
		}
		int[] dp = new int[n+1];
		
		//境界条件
		dp[1]=0;
		dp[2]=dp[1]+Math.abs(h[2]-h[1]);
		
		for(int i=3;i<=n;i++) {
			dp[i] = Math.min(dp[i-1]+Math.abs(h[i]-h[i-1]), dp[i-2]+Math.abs(h[i]-h[i-2]));
		}
		
		System.out.println(dp[n]);

	}

}
