import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int N, M, K, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        int x, y;
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 1;
        }
        
        count = 0;
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 1 || visited[i][j]) continue;
                else {
                    dfs(i, j);
                    if(count > max) max = count;
                    count = 0;
                }
            }
        }
        
        System.out.println(max);
    }
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(!visited[nx][ny] && map[nx][ny] == 1) dfs(nx, ny);
        }
    }
}