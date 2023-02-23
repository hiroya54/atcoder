package shortest_path.code14_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//重みと頂点
class Edge{
	private int to; //辺を結ぶ頂点
	private int w; //重み
	Edge(int to,int w){ //辺を結ぶ頂点と重みが格納
		this.to=to;
		this.w=w;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}	
}

public class Main {
	final static int INF = 999999999;
	static int[] dist;
	static boolean[] used;
	
	//重み付きグラフ
	public static ArrayList<ArrayList<Edge>> graph_edge(int n) { //頂点nの重み付きグラフ作成
		ArrayList<ArrayList<Edge>> g = new ArrayList<>(); //重み付きなので、結ぶ頂点と重みの情報
		for(int i=0;i<n;i++) {
			ArrayList<Edge> v = new ArrayList<>();
			g.add(v);
		}
		return g;
	}
	//緩和を実施する関数
	public static boolean chmin(int a,int b) {
		if(a>b) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		//インプット
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //頂点の数
		int m = sc.nextInt(); //辺の数
		//int s = sc.nextInt(); //始点
		
		//グラフ作成
		ArrayList<ArrayList<Edge>> g = graph_edge(n);
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			Edge e = new Edge(b,w);
			g.get(a).add(e);
		}
		
		//ダイクストラ法
		used = new boolean[n];
		Arrays.fill(used, false);
		dist = new int[n];
		Arrays.fill(dist,INF);
		dist[0]=0;
		//O(V^2)
		for(int i=0;i<n;i++) { //O(V)
			//使用済みでない頂点のうち、dist値が最小の頂点を探す
			int min_dist=INF;
			int min_v =-1;
			for(int v=0;v<n;v++) { // O(V)
				if(!used[v] && dist[v]<min_dist) {
					min_dist=dist[v];
					min_v=v;
				}
			}
			//もしそのような頂点が見つからなければ終了する
			if(min_v==-1) break;
			
			//minを始点とした各辺を緩和する
			for(Edge e:g.get(min_v)) {
				dist[e.getTo()] = Math.min(dist[e.getTo()], dist[min_v]+e.getW());
			}
			used[min_v]=true; //min_vを使用済みとする
		}
		//結果出力
				for(int i=0;i<n;i++) {
					if(dist[i]==INF) System.out.println(-1);
					else System.out.println(dist[i]);
				}
	}
}