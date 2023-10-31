package tessoku.tessokuA1;

import java.util.Scanner;

public class A07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int d = scanner.nextInt();
		int n = scanner.nextInt();
		int[] l = new int[n+1];
		int[] r = new int[n+1];
		for(int i=1;i<=n;i++) {
			l[i]=scanner.nextInt();
			r[i]=scanner.nextInt();
		}
		
		int[] updown = new int[d+2];
		for(int i=1;i<=n;i++) {
			updown[l[i]]++;
			updown[r[i]+1]--;
		}
		
		int[] sum = new int[d+1];
		for(int i=1;i<=d;i++) {
			sum[i]=sum[i-1]+updown[i];
		}
		
		for(int i=1;i<=d;i++) {
			System.out.println(sum[i]);
		}
	}

}
