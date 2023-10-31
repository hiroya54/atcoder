package tessoku.tessokuB1;

import java.util.Scanner;

public class B07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int n = scanner.nextInt();
		int[] l = new int[n+1];
		int[] r = new int[n+1];
		for(int i=1;i<=n;i++) {
			l[i]=scanner.nextInt();
			r[i]=scanner.nextInt();
		}
		
		int[] updown = new int[t+1];
		for(int i=1;i<=n;i++) {
			updown[l[i]]++;
			updown[r[i]]--;
		}
		
		
		int[] sum = new int[t+1];
		for(int i=0;i<=t;i++) {
			if(i==0) sum[i]=updown[i];
			else sum[i]=sum[i-1]+updown[i];
		}
		
		for(int i=0;i<t;i++) {
			System.out.println(sum[i]);
		}
	}

}
