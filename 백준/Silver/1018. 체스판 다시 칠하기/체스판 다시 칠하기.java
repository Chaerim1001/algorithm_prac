import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board; // W는 true, B는 false
    static int min = 64; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                if(str.charAt(j) == 'W') board[i][j] = true;
                else board[i][j] = false;
            }
        }
        
        for(int i=0; i<N-7; i++) {
            for(int j=0; j<M-7; j++) {
                find(i, j);
            }
        }
        
        System.out.println(min);
        br.close();
    }
    
    private static void find(int start_x, int start_y) {
        int end_x = start_x+8;
        int end_y = start_y+8;
        int count = 0;
        
        boolean target = board[start_x][start_y];
        
        for(int i=start_x; i<end_x; i++) {
            for(int j=start_y; j<end_y; j++) {
                if(board[i][j] != target) count++;
                target = (!target);
            }
            target = (!target);
        }
       
        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}
