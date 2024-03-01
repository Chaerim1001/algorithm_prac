import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for(int i=3; i<1001; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10_007;
        }

        System.out.println(dp[N] % 10_007);
        
        br.close();
    }
}
