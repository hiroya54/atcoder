package tessoku.tessokuA1;

import java.util.Scanner;

public class A04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		//上の桁から順番に、「2進法に変換した値」を求める
		for(int x=9;x>=0;x--) {
			int wari = (1<<x); //左ビットシフト
			System.out.print((n/wari)%2);
		}

	}

}
