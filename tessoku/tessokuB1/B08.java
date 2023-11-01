package tessoku.tessokuB1;

import java.util.Scanner;

public class B08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n+1];
		int[] y = new int[n+1];
		for(int i=1;i<=n;i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		int q = sc.nextInt();
		
		int[] a = new int[q+1];
		int[] b = new int[q+1];
		int[] c = new int[q+1];
		int[] d = new int[q+1];
		
		for(int i=1;i<=q;i++) {
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
			c[i]=sc.nextInt();
			d[i]=sc.nextInt();
		}
		
		int max = 1500;
		int[][] dem = new int[max+1][max+1];
		for(int i=1;i<=n;i++) {
			dem[x[i]][y[i]]++;
		}
		
		int[][] sum = new int[max+1][max+1];
		for(int i=1;i<=max;i++) {
			for(int j=1;j<=max;j++) {
				sum[i][j]=sum[i][j-1]+dem[i][j];
			}
		}
		for(int j=1;j<=max;j++) {
			for(int i=1;i<=max;i++) {
				sum[i][j]+=sum[i-1][j];
			}
		}
		for(int i=1;i<=q;i++) {
			System.out.println(sum[c[i]][d[i]]+sum[a[i]-1][b[i]-1]-sum[a[i]-1][d[i]]-sum[c[i]][b[i]-1]);
		}
		

	}

}
