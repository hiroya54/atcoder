package abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	//重みなしグラフ作成メソッド
	public static ArrayList<ArrayList<Integer>> makeGraph(int n){
	ArrayList<ArrayList<Integer>> g = new ArrayList<>();
	for(int i=0;i<n;i++) {
		g.add(new ArrayList<Integer>());
	}
	return g;

	}
	public static void main(String[] args) throws IOException{
		//入力
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(buff.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(buff.readLine());
		ArrayList<ArrayList<Integer>> g = makeGraph(n);
		for(int i=1;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken())-1;
			g.get(a[i]).add(i);
		}
		
		//動的計画法
		int[] dp = new int[n];
		for(int i=n-1;i>=0;i--) {
			dp[i]=0;
			for(int buka: g.get(i)) {
				dp[i]+=(dp[buka]+1);
			}
		}
		PrintWriter out = new PrintWriter(System.out);
		for(int i=0;i<n;i++) {
			if(i>0) out.print(" ");
			out.print(dp[i]);
		}
		out.flush();
	}
}