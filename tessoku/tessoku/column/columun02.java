package tessoku.column;

import java.util.Scanner;

public class columun02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
		//ビット全探索
		boolean ans = false;
		for(int i=0;i<(1<<n);i++) {
			int sum = 0;
			for(int j=0;j<n;j++) {
				int wari = (1<<j);
				if((i/wari)%2==1) sum+=a[j];
			}
			if(sum==k) ans = true;
		}
		if(ans) System.out.println("Yes");
		else System.out.println("No");
	}

}
