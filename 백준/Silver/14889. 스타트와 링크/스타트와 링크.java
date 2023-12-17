import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        if(N%2 != 0) return; // N은 무조건 짝수
        
        S = new int[N][N];
        visited = new boolean[N];
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        combination(0, 0);
        System.out.println(min);
        
        br.close(); 
    }
    
    private static void combination(int index, int count) {
        if(count == N/2) {
            calculateDifference();
            return;
        }
        
        for(int i=index; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(i+1, count+1);
                visited[i] = false;
            }
        }
    }
    
    private static void calculateDifference() {
        int startAbility = 0;
        int linkAbility = 0;
        
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(visited[i] && visited[j]) {
                    startAbility += S[i][j];
                    startAbility += S[j][i];
                } else if(!visited[i] && !visited[j]) {
                    linkAbility += S[i][j];
                    linkAbility += S[j][i];
                }
            }
        }
        
        int val = Math.abs(startAbility-linkAbility);
        
        if(val==0) {
            System.out.println(val);
			System.exit(0);
        }
        min = Math.min(val, min);
    }
}