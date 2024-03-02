import java.io.*;
import java.util.*;

public class Main {
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<N; i++) {
            cost[i][RED] += Math.min(cost[i-1][GREEN], cost[i-1][BLUE]);
            cost[i][GREEN] += Math.min(cost[i-1][RED], cost[i-1][BLUE]);
            cost[i][BLUE] += Math.min(cost[i-1][RED], cost[i-1][GREEN]);
        }

        System.out.println(Math.min(cost[N-1][BLUE], Math.min(cost[N-1][RED], cost[N-1][GREEN])));
        br.close();
    }
}
