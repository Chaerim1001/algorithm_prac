import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] map;
    static boolean[] visited = new boolean[26];
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        
        dfs(0,0,0);
        br.close();
        System.out.print(answer);
    }
    
    static void dfs(int x, int y, int count) {
        if(visited[map[x][y]]) {
            answer = Math.max(answer, count);
            return;
        } else {
            visited[map[x][y]] = true;
            for(int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                
                if(cx>=0 && cy>=00 && cx < R && cy < C) {
                    dfs(cx, cy, count+1);
                }
            }
            visited[map[x][y]] = false;
        }
    }
}