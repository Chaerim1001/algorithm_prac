import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = true;
                solution(i, j, 1, board[i][j]);
                other(i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
        br.close();
    }

    static void solution(int startX, int startY, int count, int sum) {
        if(count == 4) {
            result = Math.max(result, sum);
            return;
        }
        
        for(int i=0; i<4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(!visited[nx][ny]) {
                visited[nx][ny] = true;
                solution(nx, ny, count+1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    static void other(int x, int y) {
        // ㅓ
        if(x+2<N && y-1>=0) result = Math.max(result, board[x][y] + board[x+1][y] + board[x+2][y] + board[x+1][y-1]);

        // ㅏ
        if(x+2<N && y+1<M) result = Math.max(result, board[x][y] + board[x+1][y] + board[x+2][y] + board[x+1][y+1]);

        // ㅗ
        if(y+2<M && x-1>=0) result = Math.max(result, board[x][y] + board[x][y+1] + board[x][y+2] + board[x-1][y+1]);

        // ㅜ
        if(y+2<M && x+1<N) result = Math.max(result, board[x][y] + board[x][y+1] + board[x][y+2] + board[x+1][y+1]);
    }
}
