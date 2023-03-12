import java.util.*;
import java.io.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    // 상하좌우 + 대각선
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        while(w != 0 && h != 0) {
            count = 0;
            map = new int[h][w];
            visited = new boolean[h][w];
            
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            
            System.out.println(count);
            
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<8; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(next_x >= 0 && next_y >= 0 && next_x < h && next_y < w) {
                if(!visited[next_x][next_y] && map[next_x][next_y] == 1) {
                    dfs(next_x, next_y);
                }
            }
        }
    }    
}