package abc;

import java.util.Scanner;

public class Main {
	static int[] a;
	
	//メモ化再帰
	//スタックオーバーフローを起こすので使えない
	static int fibo(int n) {
		if(n==0|n==1) return a[n]=1;
		if(a[n]!=-1) return a[n];
		return a[n] = (fibo(n-1)+fibo(n-2))%1000000007;
	}
	public static void main(String[] args) {
		//入力
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		a = new int[n];
		/*
		Arrays.fill(a, -1);
		System.out.println(fibo(n-1));
		*/
		a[0]=1;
		a[1]=1;
		for(int i=2;i<n;i++) {
			a[i]=(a[i-1]+a[i-2])%1000000007;
		}
		System.out.println(a[n-1]);
	}
}