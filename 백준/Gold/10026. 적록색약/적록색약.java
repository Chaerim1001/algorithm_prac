import java.io.*;

public class Main {
    static int N;
    static char[][] painting;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        painting = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            painting[i] = br.readLine().toCharArray();
        }

        // 적록색약이 아닌 사람이 봤을 때의 구역의 개수
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(new Color(i, j, painting[i][j]));
                    count++;
                }
            }
        }
        int nomal_count = count;
        
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(painting[i][j] == 'G') painting[i][j] = 'R';
            }
        }

        // 적록색약인 사람이 봤을 때의 구역의 개수
        count = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(new Color(i, j, painting[i][j]));
                    count++;
                }
            }
        }
        
        System.out.println(nomal_count + " " + count);

        br.close();
    }

    static void dfs(Color c) {
        visited[c.x][c.y] = true;

        for(int i=0; i<4; i++) {
            int nx = c.x + dx[i];
            int ny = c.y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;

            if(!visited[nx][ny] && painting[nx][ny] == c.color) {
                dfs(new Color(nx, ny, painting[nx][ny]));
            }
        }
    }

    static class Color {
        int x;
        int y;
        char color;

        public Color(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
