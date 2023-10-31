package tessoku.tessokuB1;

import java.util.Scanner;

public class B02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		for(int i=a;i<=b;i++) {
			if(100%i==0) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");

	}

}
