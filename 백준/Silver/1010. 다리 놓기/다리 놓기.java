import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[][] dp = new int[30][30];
        for(int i=0; i<30; i++) {
            dp[i][0] = 1;    
            dp[i][i] = 1;
        }

        for(int i=2; i<30; i++) {
            for(int j=1; j<30; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            bw.append(dp[M][N] + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}