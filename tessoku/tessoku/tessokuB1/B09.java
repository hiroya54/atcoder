package tessoku.tessokuB1;

import java.util.Scanner;

public class B09 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] a = new int[n+1];
		int[] b = new int[n+1];
		int[] c = new int[n+1];
		int[] d = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
			b[i]=scanner.nextInt();
			c[i]=scanner.nextInt();
			d[i]=scanner.nextInt();
		}
		int max = 1500;
		int[][] z = new int[max+2][max+2];
		
		for(int i=1;i<=n;i++) {
			z[a[i]][b[i]]++;
			z[a[i]][d[i]]--;
			z[c[i]][b[i]]--;
			z[c[i]][d[i]]++;
		}
		for(int i=0;i<=max;i++) {
			for(int j=1;j<=max;j++) {
				z[i][j]+=z[i][j-1];
			}
		}
		for(int j=0;j<=max;j++) {
			for(int i=1;i<=max;i++) {
				z[i][j]+=z[i-1][j];
			}
		}
		int res=0;
		for(int i=0;i<=max;i++) {
			for(int j=0;j<=max;j++) {
				if(z[i][j]>=1) res++;
			}
		}
		System.out.println(res);

	}

}
