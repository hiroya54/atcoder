package tessoku.tessokuA1;

import java.util.Scanner;

public class A05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int c=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(k-i-j<=n && k-i-j>=1) {
					c++;
				}
			}
		}
		System.out.println(c);

	}

}
