import java.io.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        
        int direction = 2;
        int nowR = 49;
        int nowC = 49;
      
        int[][] map = new int[100][100];
        
        int max_r = 49;
        int min_r = 49;
        int max_c = 49;
        int min_c = 49;

        map[49][49] = 1;
        for(char c: arr) {
            if(c == 'F') { // 현재 방향에서 앞으로 전진
                nowR += dr[direction];
                nowC += dc[direction];

                max_r = Math.max(max_r, nowR);
                max_c = Math.max(max_c, nowC);

                min_r = Math.min(min_r, nowR);
                min_c = Math.min(min_c, nowC);
                
                map[nowR][nowC] = 1;
            } else if(c == 'L') { // 시계 반대 방향으로 회전
                direction = (direction+3)%4;
            } else if(c == 'R') { // 시계 방향으로 회전
                direction = (direction+1)%4;
            }
        }
       
      
        for(int i=min_r; i<=max_r; i++) {
            for(int j=min_c; j<=max_c; j++) {
                if(map[i][j] == 0) {
                    bw.append("#");
                } else {
                    bw.append(".");
                }
            }
            bw.append("\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static class Point {
        int r;
        int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}