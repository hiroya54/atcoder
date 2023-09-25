package abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//重み付きグラフの辺
class Edge{
	int to; //隣接頂点番号
	int w; //重み
	//コンストラクタ
	Edge(int to,int w){
		this.to = to;
		this.w = w;
	}
}
//頂点と頂点のペア
class Pair implements Comparable<Pair>{
	int v;
	int dist;
	Pair(int v,int dist) {
		this.v=v;
		this.dist=dist;
	}
	public int compareTo(Pair p) {
		// State 型同士の比較をする関数
		if (this.dist < p.dist) {
			return -1;
		}
		if (this.dist > p.dist) {
			return 1;
		}
		return 0;
	}

}

public class Main {
	static int INF = 999999999;
	//重み付きグラフ作成メソッド
	public static ArrayList<ArrayList<Edge>> makeWGraph(int n){
		ArrayList<ArrayList<Edge>> g = new ArrayList<>();
		for(int i=0;i<n;i++) {
			g.add(new ArrayList<Edge>());
		}
		return g;
	
	}
	public static void main(String[] args) throws IOException{
		//入力
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(buff.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//頂点nの重み付きグラフ作成
		ArrayList<ArrayList<Edge>> g = makeWGraph(n);
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(buff.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			g.get(a).add(new Edge(b,c));
			g.get(b).add(new Edge(a,c));
		}
		
		//配列の初期化
		boolean[] seen = new boolean[n];
		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		
		//スタート地点をキューに追加
		dist[0]=0;
		Queue<Pair> q = new PriorityQueue<>();
		q.add(new Pair(0,dist[0]));
		
		//ダイクストラ法
		while(q.size()>=1) {
			int v = q.remove().v;
			if (seen[v]) continue;
			//vを始点とした各辺を緩和する
			for(Edge e:g.get(v)) {
				if(dist[e.to]>dist[v]+e.w) {
					dist[e.to]=dist[v]+e.w;
					q.add(new Pair(e.to,dist[e.to]));
				}
			}
			//探索済み
			seen[v]=true;
		}
		//結果出力
		PrintWriter out = new PrintWriter(System.out);
		for(int i=0;i<n;i++) {
			if(dist[i]==INF) out.println("-1");
			else out.println(dist[i]);
		}
		out.flush();
	}
}