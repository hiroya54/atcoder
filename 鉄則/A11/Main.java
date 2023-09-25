import java.util.Scanner;

public class Main {
	static int[] a;
	static public int lower_bound(int x) {
		int left = -1;
		int right = a.length;
		int mid;
		while(right-left>1) {
			mid = left + (right-left)/2;
			if(x<=a[mid]) right=mid;
			else left=mid;
		}
		return right;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
		System.out.println(lower_bound(x)+1);
		
		
	}
}
