import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(str.substring(j-1, j));
            }
        }
        
        BFS(1,1);
        System.out.print(map[N][M]);
        
        br.close();
    }
    
    static void BFS(int s, int e) {
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = {s, e};
        queue.add(arr); 
        visited[s][e] = true;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];
                if(x > 0 && y > 0 && x < N+1 && y < M+1) {
                    if(!visited[x][y] && map[x][y] != 0) {
                        int[] a = {x, y};
                        queue.add(a);
                        visited[x][y] = true;
                        map[x][y] = map[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
    }
}