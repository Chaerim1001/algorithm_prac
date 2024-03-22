import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N];
            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] dp = new int[2][N];
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            if(N>1) {
                dp[0][1] = stickers[0][1] + dp[1][0];
                dp[1][1] = stickers[1][1] + dp[0][0];

                for(int i=2; i<N; i++) {
                    dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
                    dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
                }
            }            
            bw.append(Math.max(dp[0][N-1], dp[1][N-1]) + "\n"); 
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
