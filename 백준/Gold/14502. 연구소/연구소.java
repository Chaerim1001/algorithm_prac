import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int maximumArea = Integer.MIN_VALUE;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());;
            }
        }
        
        dfs(0);
        
        System.out.println(maximumArea);
        br.close();
    }
    
    static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1; // 벽 세우기
                    dfs(wall+1);
                    map[i][j] = 0;
                }
            }
        }
    } 
    
    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }
        
        int[][] temp = new int[N][M];
        
        for(int i=0; i<N; i++) {
            temp[i] = map[i].clone();
        }
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0|| nx>=N || ny>=M) continue;
                else if(temp[nx][ny] == 0) {
                    queue.add(new Node(nx, ny));
                    temp[nx][ny] = 2;
                }
            }
        }
        
        findSafeArea(temp);
    }
    
    
    static void findSafeArea(int[][] targetMap) {
        int area = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(targetMap[i][j] == 0) {
                    area++;
                }
            }
        }
        
        if(maximumArea < area) maximumArea = area;
    }
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}