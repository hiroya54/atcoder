import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] sum = new int[h+2][w+2];
		
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			sum[a][b]++;
			sum[a][d+1]--;
			sum[c+1][b]--;
			sum[c+1][d+1]++;
		}
		
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				sum[i][j]+=sum[i][j-1];
			}
		}
		
		for(int j=1;j<=w;j++) {
			for(int i=1;i<=h;i++) {
				sum[i][j]+=sum[i-1][j];
			}
		}
		
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}
	}
}
