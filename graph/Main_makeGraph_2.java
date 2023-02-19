package graph.code10_4;

import java.util.ArrayList;
import java.util.Scanner;

class Edge{
	int to; //辺を結ぶ頂点
	long w; //重み
	Edge(int to,long w){ //辺を結ぶ頂点と重みが格納
		this.to=to;
		this.w=w;
	}
}
public class Main {
	public static ArrayList<ArrayList<Integer>> graph(int n) { //頂点nの重みなしグラフ作成
		ArrayList<ArrayList<Integer>> g = new ArrayList<>(); //重みなしなので、辺を結ぶ頂点の情報のみ
		for(int i=0;i<n;i++) {
			ArrayList<Integer> v = new ArrayList<>();
			g.add(v);
		}
		return g;
	}
	public static ArrayList<ArrayList<Edge>> graph_edge(int n) { //頂点nの重み付きグラフ作成
		ArrayList<ArrayList<Edge>> g = new ArrayList<>(); //重み付きなので、結ぶ頂点と重みの情報
		for(int i=0;i<n;i++) {
			ArrayList<Edge> v = new ArrayList<>();
			g.add(v);
		}
		return g;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		
		ArrayList<ArrayList<Edge>> g = graph_edge(n);
		for(int i=0;i<m;i++) {
			int v_a=Integer.parseInt(sc.next());
			int v_b=Integer.parseInt(sc.next());
			long v_w=Integer.parseInt(sc.next());
			Edge e = new Edge(v_b,v_w);
			g.get(v_a).add(e);
			
		}

	}

}
