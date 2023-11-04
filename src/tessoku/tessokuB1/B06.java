package tessoku.tessokuB1;

import java.util.Scanner;

public class B06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i]=scanner.nextInt();
		}
		
		int q = scanner.nextInt();
		int[] l = new int[q+1];
		int[] r = new int[q+1];
		
		for(int i=1;i<=q;i++) {
			l[i]=scanner.nextInt();
			r[i]=scanner.nextInt();
		}
		
		int[] sum = new int[n+1];
		for(int i=1;i<=n;i++) {
			sum[i]=sum[i-1]+a[i];
		}
	
		
		for(int i=1;i<=q;i++) {
			int atari = sum[r[i]]-sum[l[i]-1];
			int count = r[i]-l[i]+1;
			int hazure = count-atari;
			if(atari==hazure) System.out.println("draw");
			else if(atari>hazure) System.out.println("win");
			else System.out.println("lose");
		}

	}

}
