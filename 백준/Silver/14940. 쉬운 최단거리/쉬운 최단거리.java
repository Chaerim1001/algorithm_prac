import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Point> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if(map[i][j] == 1) map[i][j] = -1;
                else if(map[i][j] == 2) {
                    map[i][j] = 0;
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                if(map[nx][ny] == -1 && !visited[nx][ny]) {
                    map[nx][ny] = map[p.x][p.y] + 1;
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                bw.append(map[i][j] + " ");
            }
            bw.append("\n");
        }
 
        bw.flush();
        br.close();
        bw.close();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
