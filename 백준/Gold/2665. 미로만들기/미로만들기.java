import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        
        for(int i=0; i<N; i++) {
            String temp = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = temp.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(dist[N-1][N-1]);
        br.close();
    }
    
    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        dist[0][0] = 0;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(dist[nx][ny] <= dist[now.x][now.y]) continue;
                if(map[nx][ny] == 1) dist[nx][ny] = dist[now.x][now.y];
                else dist[nx][ny] = dist[now.x][now.y] + 1;
                queue.offer(new Node(nx, ny));
            }
        }      
    }
}

class Node {
    int x, y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}