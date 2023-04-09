import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i][j-1] + arr[i][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			if(op == 1) {
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				
				int res = 0;
				for(int x=x1; x<=x2; x++) {
					res += dp[x][y2] - dp[x][y1-1];
				}
				sb.append(res+"\n");
			}else {
				int c = Integer.parseInt(st.nextToken());
				int dif = c - arr[x1][y1];
				for(int y=y1; y<=N; y++) {
					dp[x1][y] += dif; 
				}
				arr[x1][y1] = c;
			}
		}
		
		System.out.println(sb.toString());
        br.close();
	}
}