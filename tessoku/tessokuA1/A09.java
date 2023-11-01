package tessoku.tessokuA1;

import java.util.Scanner;

public class A09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		int[] c = new int[n+1];
		int[] d = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
			c[i]=sc.nextInt();
			d[i]=sc.nextInt();
		}
		int[][] z = new int[h+2][w+2];
		
		for(int i=1;i<=n;i++) {
			z[a[i]][b[i]]++;
			z[a[i]][d[i]+1]--;
			z[c[i]+1][b[i]]--;
			z[c[i]+1][d[i]+1]++;
		}
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				z[i][j]+=z[i][j-1];
			}
		}
		for(int j=1;j<=w;j++) {
			for(int i=1;i<=h;i++) {
				z[i][j]+=z[i-1][j];
			}
		}
		
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				System.out.print(z[i][j]+" ");
			}
			System.out.println();
		}
	}

}
