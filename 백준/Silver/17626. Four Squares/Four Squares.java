import java.io.*;

public class Main{
    static final int MAX_SIZE = 50_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX_SIZE];
        dp[1] = 1;
        
        int min = 0;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }
 
            dp[i] = min + 1; 
        }
        
        System.out.println(dp[N]);
        br.close();
    }
    
}