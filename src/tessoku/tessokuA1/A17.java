package tessoku.tessokuA1;

import java.util.ArrayList;
import java.util.Scanner;

public class A17 {

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
		
		//答えの復元
		int place = n;
		ArrayList<Integer> route = new ArrayList<>();
		while(true) {
			route.add(place);
			if(place==1) break;
			
			if(dp[place]==dp[place-1]+a[place]) place--;
			else place-=2;
			
		}
		System.out.println(route.size());
		for(int i=route.size()-1;i>=0;i--) {
			System.out.print(route.get(i));
			if(i==0) break;
			System.out.print(" ");
		}

	}

}
