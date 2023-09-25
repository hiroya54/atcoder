import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
		int[] p = new int[n];
		int[] q = new int[n];
		
		for(int i=0;i<n;i++) {
			if(i==0) p[i]=a[i];
			else p[i]=Math.max(p[i-1], a[i]);
		}
		for(int i=n-1;i>=0;i--) {
			if(i==n-1) q[i]=a[i];
			else q[i]=Math.max(q[i+1], a[i]);
		}
		
		int d =sc.nextInt();
		
		for(int i=0;i<d;i++) {
			int l = sc.nextInt()-1;
			int r = sc.nextInt()-1;
			System.out.println(Math.max(p[l-1], q[r+1]));
		}
	}
}
