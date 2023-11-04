package tessoku.tessokuB1;

import java.util.ArrayList;
import java.util.Scanner;

public class B18 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		
		boolean[][] dp = new boolean[n+1][s+1];
		
		//境界条件
		dp[0][0]=true;
		//動的計画法
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=s;j++) {
				if(dp[i-1][j]) dp[i][j]=true;
				if(j-a[i]>=0 && dp[i-1][j-a[i]])  dp[i][j]=true;
			}
		}
		if(!dp[n][s]) {
			System.out.println("-1");
			return;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		int place=s;
		for(int i=n;i>=1;i--) {
			if(place-a[i]>=0 && dp[i-1][place-a[i]]) {
				list.add(i);
				place-=a[i];
			}
		}
		System.out.println(list.size());
		for(int i = list.size()-1;i>=0;i--) {
			System.out.print(list.get(i));
			if(i>0) System.out.print(" ");
		}
		

	}

}
