class Solution {
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
            
        return cnt;
    }
    
    private void dfs(int sum, int idx, int[] numbers, int target) {
        if(idx == numbers.length && sum == target) {
            cnt++;
            return;
        }
        
        if(idx >= numbers.length) return;
        
        dfs(sum + numbers[idx], idx+1, numbers, target);
        dfs(sum - numbers[idx], idx+1, numbers, target);
    }
}