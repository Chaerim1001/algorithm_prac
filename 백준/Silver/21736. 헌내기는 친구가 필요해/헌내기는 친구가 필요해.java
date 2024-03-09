import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        int startX = -1;
        int startY = -1;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        if(count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
        
        br.close();
    }

    static void bfs(int startX, int startY) {
        Queue<Spot> queue = new LinkedList<>();
        queue.add(new Spot(startX, startY, 'I'));
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            Spot spot = queue.poll();
            if(spot.value == 'P') {
                count++;
            }

            for(int i=0; i<4; i++) {
                int nx = spot.x + dx[i];
                int ny = spot.y + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.add(new Spot(nx, ny, map[nx][ny]));
                }
            }
        }
    }

    static class Spot {
        int x;
        int y;
        char value;

        public Spot(int x, int y, char value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
