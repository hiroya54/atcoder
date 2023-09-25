import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int[][] grid = new int[h][w];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				grid[i][j]=sc.nextInt();
			}
		}
		
		int[][] sum = new int[h+1][w+1];
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				sum[i][j]=sum[i][j-1]+grid[i-1][j-1];
			}
		}
		for(int j=1;j<=w;j++) {
			for(int i=1;i<=h;i++) {
				sum[i][j]+=sum[i-1][j];
			}
		}
		int q = sc.nextInt();
		for(int i=0;i<q;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			int res = sum[c][d]+sum[a-1][b-1]-sum[a-1][d]-sum[c][b-1];
			
			System.out.println(res);
		}
		
	}
}
