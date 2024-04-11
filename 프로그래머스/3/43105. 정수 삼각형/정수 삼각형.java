class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][triangle[n-1].length];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<n; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];
        }
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        
        int answer = 0;
        for(int i=0; i<triangle[n-1].length; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}