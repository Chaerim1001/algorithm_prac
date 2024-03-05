import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Count[] dp = new Count[41];
        dp[0] = new Count(1,0);
        dp[1] = new Count(0, 1);
        for(int i=2; i<41; i++) {
            dp[i] = new Count(dp[i-1].zero+dp[i-2].zero, dp[i-1].one+dp[i-2].one);
        }

        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            bw.append(dp[N].zero + " " + dp[N].one);
            bw.append("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Count {
        int zero = 0;
        int one = 0;
        
        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
}
