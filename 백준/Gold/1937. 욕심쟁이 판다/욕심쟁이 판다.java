import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] forest;
    static int[][] dp;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        dp = new int[N][N];
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer);
        
        br.close();
    }
    
    static int dfs(int x, int y) {
        if(dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;
        int nx, ny;
        for(int i=0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            
            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
            if(forest[nx][ny]>forest[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
                dfs(nx, ny);
            }
        }
        
        return dp[x][y];
    }   
}