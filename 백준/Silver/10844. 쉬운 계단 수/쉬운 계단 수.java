import java.io.*;

public class Main {
    static final long MOD = 1_000_000_000;

    static int N;
    static long[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];

        for(int i=1; i<10; i++) {
            // 한 자리 수는 무조건 계단 수가 1개니까
            dp[1][i] = 1;
        }

        for(int i=2; i<N+1; i++) {
            for(int j=0; j<10; j++) {
                if(j==0) dp[i][0] = dp[i-1][1] % MOD;
                else if (j==9) dp[i][9] = dp[i-1][8] % MOD;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
        }

        long result = 0;
        for(int i=0; i<10; i++) {
            result += dp[N][i];
        }
        System.out.println(result % MOD);

        br.close();
    }
}
