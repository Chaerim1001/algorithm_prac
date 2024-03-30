import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] newHouse;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        newHouse = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                newHouse[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(new Pipe(0, 1, -1));
        System.out.println(answer);

        br.close();        
    }
    
    static void dfs(Pipe p) {
        if(p.x==N-1 && p.y==N-1) { // 끝 점에 도착한 경우
            answer++;
            return;   
        }
        
        if(p.value == -1) { // 현재 상태가 가로인 경우
            if(p.y+1<N) {
                if(newHouse[p.x][p.y+1] == 0) dfs(new Pipe(p.x, p.y+1, -1));
            } 
            if(p.x+1<N && p.y+1<N) {
                if(newHouse[p.x+1][p.y+1] == 0 && newHouse[p.x][p.y+1] == 0 && newHouse[p.x+1][p.y] == 0) dfs(new Pipe(p.x+1, p.y+1, 0));
            }
        } else if(p.value == 1) { // 현재 상태가 세로인 경우
            if(p.x+1<N) {
                if(newHouse[p.x+1][p.y] == 0) dfs(new Pipe(p.x+1, p.y, 1));
            } 
            if(p.x+1<N && p.y+1<N) {
                if(newHouse[p.x+1][p.y+1] == 0 && newHouse[p.x][p.y+1] == 0 && newHouse[p.x+1][p.y] == 0) dfs(new Pipe(p.x+1, p.y+1, 0));
            }
        } else { // 현재 상태가 대각선인 경우
            if(p.y+1<N) {
                if(newHouse[p.x][p.y+1] == 0) dfs(new Pipe(p.x, p.y+1, -1));
            } 
            if(p.x+1<N) {
                if(newHouse[p.x+1][p.y] == 0) dfs(new Pipe(p.x+1, p.y, 1));
            }
            if(p.x+1<N && p.y+1<N) {
                if(newHouse[p.x+1][p.y+1] == 0 && newHouse[p.x][p.y+1] == 0 && newHouse[p.x+1][p.y] == 0) dfs(new Pipe(p.x+1, p.y+1, 0));
            }
        }
    }
        
    static class Pipe {
        int x; // 파이프 끝의 행
        int y; // 파이프 끝의 열
        int value; // -1은 가로, 0은 대각선, 1은 세로
        
        public Pipe(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}