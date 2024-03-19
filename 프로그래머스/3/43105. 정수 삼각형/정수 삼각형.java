class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<size; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }
        
        for(int i=2; i<size; i++) {
            for(int j=1; j<i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int sum: dp[size-1]) {
            if(sum>max) {
                max = sum;
            }
        }
        
        return max;
    }
}