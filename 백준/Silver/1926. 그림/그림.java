import java.io.*;
import java.util.*;

public class Main {
    static int N, M, area;
    static int[][] painting;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        painting = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                painting[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        int max = 0;
        area = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(painting[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                    if(max < area) max = area;
                    area = 0;
                }
            }
        }
        
        System.out.println(count);
        System.out.println(max);
    }
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        area++;
        int nx, ny;
        for(int i=0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(!visited[nx][ny] && painting[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}