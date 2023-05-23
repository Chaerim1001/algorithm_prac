import java.io.*;
import java.util.*;
 
public class Main {
	static int[][] dp;
	static int[] W; 
	static int[] V; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		W = new int[N];
		V = new int[N];
 
		dp = new int[N][K + 1];
 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
 
		System.out.println(backpack(N - 1, K));
        br.close();
	}
 
	static int backpack(int i, int k) {
		if (i < 0) return 0;
		
		if (dp[i][k] == 0) {
			if(W[i] > k) dp[i][k] = backpack(i - 1, k);
			else dp[i][k] = Math.max(backpack(i - 1, k), backpack(i - 1, k - W[i]) + V[i]);
		}
        
		return dp[i][k];
	}
}