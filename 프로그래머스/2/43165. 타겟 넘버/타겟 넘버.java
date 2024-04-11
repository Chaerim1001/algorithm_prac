class Solution {
    static int n;
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        dfs(0, 0, target, numbers);
        return count;
    }
    
    public void dfs(int idx, int number, int target, int[] numbers) {
        if(idx == n) {
            if(number == target) {
                count++;
            }
            return;
        }
        
        dfs(idx+1, number-numbers[idx], target, numbers);
        dfs(idx+1, number+numbers[idx], target, numbers);
    }
}