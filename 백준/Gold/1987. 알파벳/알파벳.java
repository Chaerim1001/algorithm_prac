import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int R, C;
    static int[][] map;
    static boolean[] alpha;
    
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        alpha = new boolean[26];
        
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
 
        }
        
        dfs(0, 0, 1);
        System.out.println(answer);
        
        br.close();
    }
    
    static void dfs(int x, int y, int length) {
        alpha[map[x][y]] = true;
        answer = Math.max(length, answer);
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx<0 || ny<0 || nx>=R ||ny>=C) continue;
            
            if(!alpha[map[nx][ny]]) {
                dfs(nx, ny, length+1);
                alpha[map[nx][ny]] = false;
            }
        }
    }
}