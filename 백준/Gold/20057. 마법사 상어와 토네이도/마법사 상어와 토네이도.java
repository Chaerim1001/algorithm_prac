import java.io.*;
import java.util.*;

public class Main {
    static int N, nowR, nowC; // N은 홀수
    static int[][] map;
    
    static int[] dr = {0, 1, 0, -1}; // 좌하우상
    static int[] dc = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int preSand = 0;
        map = new int[N+4][N+4];
        for(int i=2; i<N+2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=2; j<N+2; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                preSand += map[i][j];
            }
        }
        
        nowR = (N+4)/2;
        nowC = (N+4)/2;
        int count = 2;
        int moveCount = 1;
        int moveIdx = 0;

        while(true) {
            while(count-->0) {
                for(int i=0; i<moveCount; i++) {
                    // idx 방향으로 이동
                    move(moveIdx);
                    if(nowR == 2 && nowC == 2) {
                        break;
                    }
                }
                if(nowR == 2 && nowC == 2) {
                    break;
                }
                moveIdx++;
                if(moveIdx == 4) moveIdx = 0;
            }
            if(nowR == 2 && nowC == 2) {
                break;
            }
            count = 2;
            moveCount++;
        }
        int nowSand = 0;
        
        for(int i=2; i<N+2; i++) {
            for(int j=2; j<N+2; j++) {
                nowSand += map[i][j];
            }
        }
        
        System.out.println(preSand - nowSand);
        br.close();
    }
    
    static void move(int idx) {
        int nextR = nowR + dr[idx];
        int nextC = nowC + dc[idx];

        
        if(map[nextR][nextC] != 0) {
            if(idx == 0) { // 왼쪽
                map[nextR-1][nextC+1] += (map[nextR][nextC]/100);
                map[nextR+1][nextC+1] += (map[nextR][nextC]/100);
                map[nextR-1][nextC] += ((map[nextR][nextC]*7) / 100);
                map[nextR+1][nextC] += ((map[nextR][nextC]*7) / 100);
                map[nextR-2][nextC] += ((map[nextR][nextC]*2) / 100);
                map[nextR+2][nextC] += ((map[nextR][nextC]*2) / 100);
                map[nextR-1][nextC-1] += ((map[nextR][nextC]*10) / 100);
                map[nextR+1][nextC-1] += ((map[nextR][nextC]*10) / 100);
                map[nextR][nextC-2] += ((map[nextR][nextC]*5) /100);

                int sand = map[nextR][nextC];
                sand -= (((map[nextR][nextC]/100) * 2) + (((map[nextR][nextC]*7) / 100) * 2) + (((map[nextR][nextC]*10) / 100) * 2) + (((map[nextR][nextC]*2) / 100) * 2) + ((map[nextR][nextC]*5) /100));

                map[nextR][nextC-1] += sand;
            } else if(idx == 1) { // 아래
                map[nextR-1][nextC-1] += (map[nextR][nextC]/100);
                map[nextR-1][nextC+1] += (map[nextR][nextC]/100);
                map[nextR][nextC-1] += ((map[nextR][nextC]*7) / 100);
                map[nextR][nextC+1] += ((map[nextR][nextC]*7) / 100);
                map[nextR][nextC-2] += ((map[nextR][nextC]*2) / 100);
                map[nextR][nextC+2] += ((map[nextR][nextC]*2) / 100);
                map[nextR+1][nextC-1] += ((map[nextR][nextC]*10) / 100);
                map[nextR+1][nextC+1] += ((map[nextR][nextC]*10) / 100);
                map[nextR+2][nextC] += ((map[nextR][nextC]*5) /100);

                int sand = map[nextR][nextC];
                sand -= (((map[nextR][nextC]/100) * 2) + (((map[nextR][nextC]*7) / 100) * 2) + (((map[nextR][nextC]*10) / 100) * 2) + (((map[nextR][nextC]*2) / 100) * 2) + ((map[nextR][nextC]*5) /100));

                
                map[nextR+1][nextC] += sand;      
            } else if(idx == 2) { // 오른쪽
                map[nextR+1][nextC-1] += (map[nextR][nextC]/100);
                map[nextR-1][nextC-1] += (map[nextR][nextC]/100);
                map[nextR-1][nextC] += ((map[nextR][nextC]*7) / 100);
                map[nextR+1][nextC] += ((map[nextR][nextC]*7) / 100);
                map[nextR-2][nextC] += ((map[nextR][nextC]*2) / 100);
                map[nextR+2][nextC] += ((map[nextR][nextC]*2) / 100);
                map[nextR-1][nextC+1] += ((map[nextR][nextC]*10) / 100);
                map[nextR+1][nextC+1] += ((map[nextR][nextC]*10) / 100);
                map[nextR][nextC+2] += ((map[nextR][nextC]*5) /100);
                int sand = map[nextR][nextC];
                sand -= (((map[nextR][nextC]/100) * 2) + (((map[nextR][nextC]*7) / 100) * 2) + (((map[nextR][nextC]*10) / 100) * 2) + (((map[nextR][nextC]*2) / 100) * 2) + ((map[nextR][nextC]*5) /100));

                map[nextR][nextC+1] += sand;
            } else { // 위
                map[nextR+1][nextC-1] += (map[nextR][nextC]/100);
                map[nextR+1][nextC+1] += (map[nextR][nextC]/100);
                map[nextR][nextC+1] += ((map[nextR][nextC]*7) / 100);
                map[nextR][nextC-1] += ((map[nextR][nextC]*7) / 100);
                map[nextR][nextC+2] += ((map[nextR][nextC]*2) / 100);
                map[nextR][nextC-2] += ((map[nextR][nextC]*2) / 100);
                map[nextR-1][nextC+1] += ((map[nextR][nextC]*10) / 100);
                map[nextR-1][nextC-1] += ((map[nextR][nextC]*10) / 100);
                map[nextR-2][nextC] += ((map[nextR][nextC]*5) /100);
                int sand = map[nextR][nextC];
                sand -= (((map[nextR][nextC]/100) * 2) + (((map[nextR][nextC]*7) / 100) * 2) + (((map[nextR][nextC]*10) / 100) * 2) + (((map[nextR][nextC]*2) / 100) * 2) + ((map[nextR][nextC]*5) /100));

                map[nextR-1][nextC] +=sand;
            }
        }       
        map[nextR][nextC] = 0;
        nowR = nextR;
        nowC = nextC;
    }
}