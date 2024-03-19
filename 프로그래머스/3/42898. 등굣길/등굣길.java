import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1; i<m+1; i++) {
            dp[1][i] = 1;
        }
        
        for(int i=1; i<n+1; i++) {
            dp[i][1] = 1;
        }
        
        for(int[] p: puddles) {
            dp[p[1]][p[0]] = -1;
            
            if(p[1] == 1) {
                for(int i=p[0]+1; i<m+1; i++) {
                    dp[1][i] = -1;
                }
            } else if(p[0] == 1) {
                for(int i=p[1]+1; i<n+1; i++) {
                    dp[i][1] = -1;
                }
            }
        }
        
        for(int i=2; i<n+1; i++) {
            for(int j=2; j<m+1; j++) {
                if(dp[i][j] != -1) {
                    if(dp[i-1][j] == -1 && dp[i][j-1] != -1) {
                        dp[i][j] = dp[i][j-1] % MOD;
                    } else if(dp[i-1][j] != -1 && dp[i][j-1] == -1) {
                        dp[i][j] = dp[i-1][j] % MOD;
                    } else if(dp[i-1][j] != -1 && dp[i][j-1] != -1) {
                        dp[i][j] = (dp[i-1][j] +dp[i][j-1]) % MOD;
                    }
                }
            }
        }
        
        return dp[n][m];
    }
}