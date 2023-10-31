import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//入力
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		long ans=0;
		
		
		
		for(int i=0;i<n;i++) {
			//入力
			String t =sc.next();
			int a = sc.nextInt();
			if(t.equals("+")) ans+=a;
			if(t.equals("*")) ans*=a;
			if(t.equals("-")) ans-=a;
			
			//引き算でansが負になった場合
			if(ans<0) ans+=10000;
			//好きなタイミングで余りをとっても答えは変わらない
			//オーバーフロー対策
			ans%=10000;
			System.out.println(ans);
		}
	}
}