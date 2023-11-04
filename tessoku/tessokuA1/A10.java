package git_atcoder;

import java.util.Scanner;

public class A10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = scanner.nextInt();
		}
		int d = scanner.nextInt();
		int[] l = new int[d+1];
		int[] r = new int[d+1];
		for(int i=1;i<=d;i++) {
			l[i] = scanner.nextInt();
			r[i] = scanner.nextInt();
		}
		int[] p = new int[n+2];
		int[] q = new int[n+2];
		
		for(int i=1;i<=n;i++) {
			p[i]=Math.max(p[i-1], a[i]);
		}
		for(int i=n;i>=1;i--) {
			q[i]=Math.max(q[i+1], a[i]);
		}
		
		for(int i=1;i<=d;i++) {
			System.out.println(Math.max(p[l[i]-1], q[r[i]+1]));
		}

	}

}
