import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		
		//ダイクストラ法
		boolean[] seen = new boolean[n];
		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[0]=0;
		
		for(int i=0;i<n;i++) {
			//seen=falseのうち、distが最小の頂点を探す
			int min_dist = INF;
			int min_v = -1;
			for(int v=0;v<n;v++) {
				if(!seen[v] && dist[v]<min_dist) {
					min_dist=dist[v];
					min_v=v;
				}
			}
			//終了条件
			if(min_v==-1) break;
			//min_vを始点とした各辺を緩和する
			for(Edge e:g.get(min_v)) {
				dist[e.to]=Math.min(dist[e.to], dist[min_v]+e.w);
			}
			//探索済み
			seen[min_v]=true;
		}
		//結果出力
		for(int i=0;i<n;i++) {
			if(dist[i]==INF) System.out.println(-1);
			else System.out.println(dist[i]);
		}
	}
}