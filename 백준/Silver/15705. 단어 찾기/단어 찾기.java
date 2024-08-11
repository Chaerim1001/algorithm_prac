import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1}; // 상하좌우 + 대각선 시계방향
    static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
    static char[] target;
    static char[][] board;
    static boolean check = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine().toCharArray();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        for(int i=0; i<N; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j=0; j<M; j++) {
                board[i][j] = temp[j];
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(check) break;
                
                if(board[i][j] == target[0]) {
                    for(int k=0; k<8; k++) {
                        dfs(i, j, 0, k);
                        if(check) break;
                    }
                }
            }
        }
        
        if(check) System.out.println("1");
        else System.out.println("0");
        
        br.close();
    }
    
    static void dfs(int r, int c, int number, int dir) { 
        if(number == target.length) {
            check = true;
            return;
        }
        
        if(board[r][c] == target[number]) {
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            if(nr<0 || nc<0 || nr>=N || nc>=M) return;
            dfs(nr, nc, number+1, dir);
        }
    }
}