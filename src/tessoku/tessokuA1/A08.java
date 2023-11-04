package tessoku.tessokuA1;

import java.util.Scanner;

public class A08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] x = new int[h+1][w+1];
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				x[i][j]=sc.nextInt();
			}
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
		
		int[][] sum = new int[h+1][w+1];
		
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				sum[i][j] = sum[i][j-1]+x[i][j];
			}
		}
		for(int j=1;j<=w;j++) {
			for(int i=1;i<=h;i++) {
				sum[i][j]+=sum[i-1][j];
			}
		}
		
		for(int i=1;i<=q;i++) {
			System.out.println(sum[c[i]][d[i]]+sum[a[i]-1][b[i]-1]-sum[a[i]-1][d[i]]-sum[c[i]][b[i]-1]);
		}

	}

}
