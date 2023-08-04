import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
        arr = new int[n + 1][n + 1];
        
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) arr[i][j] = 0;
				else arr[i][j] = 5001;
			}
		}
        
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		floyd();
		
		int minCnt = Integer.MAX_VALUE;
		int min = 0;
		
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				cnt += arr[i][j];
			}
			if (minCnt > cnt) {
				min = i;
				minCnt=cnt;
			} else if (minCnt == cnt) {
				min = Math.min(i, min);
			}
		}
        
		System.out.println(min);
        br.close();
	}

	private static void floyd() {
		for (int k = 1; k <= n; k++) { 
			for (int i = 1; i <= n; i++) { 
				for (int j = 1; j <= n; j++) { 
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]); // 최단경로 초기화
				}
			}
		}
	}
}