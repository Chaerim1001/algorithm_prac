class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        // dp[i][j] = dp[i-1][j] + dp[i][j-1];
        
        final int MOD = 1_000_000_007;
        
        for(int i=1; i<=m; i++) {
            dp[1][i] = 1;
        }
        
        for(int i=1; i<=n; i++) {
            dp[i][1] = 1;
        }
        
        for(int[] p:puddles) {
            if(p[0] == 1) {
                for(int i=p[1]; i<=n; i++) {
                    dp[i][1] = 0;
                }
            } else if(p[1] == 1) {
                for(int i=p[0]; i<=m; i++) {
                    dp[1][i] = 0;
                }
            } else {
                dp[p[1]][p[0]] = -1;
            }
        }
        
        for(int i=2;i<=n;i++) {
            for(int j=2; j<=m; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                } 
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD;
            }
        }
        return dp[n][m]%MOD;
    }
}