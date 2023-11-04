package tessoku.tessokuB1;

import java.util.Scanner;

public class B04 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n = scanner.next();
		int len = n.length();
		
		int c = 0;
		for(int i=0;i<len;i++) {
			int val = Character.getNumericValue(n.charAt(len-1-i));
			c+=val*Math.pow(2, i);
			
		}
		System.out.println(c);
	}

}
