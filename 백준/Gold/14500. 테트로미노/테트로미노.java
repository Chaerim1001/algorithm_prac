import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i,j,arr[i][j],1);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
        br.close();
    }
    
    static void dfs(int row, int col, int sum, int count) {
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}

		for(int i=0; i<4; i++) {
			int nowR = row + dx[i];
			int nowC = col + dy[i];

			if(nowR<0 || nowR>=N || nowC<0 || nowC>=M) continue;

			if(!visited[nowR][nowC]) {
				if(count == 2) {
					visited[nowR][nowC] = true;
					dfs(row, col, sum + arr[nowR][nowC], count + 1);
					visited[nowR][nowC] = false;
				}

				visited[nowR][nowC] = true;
				dfs(nowR, nowC, sum + arr[nowR][nowC], count + 1);
				visited[nowR][nowC] = false;
			}
		}
	}
}