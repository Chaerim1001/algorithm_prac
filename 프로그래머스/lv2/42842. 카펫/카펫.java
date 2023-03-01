class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w = 0;
        int h = 0;
        
        int sum = brown + yellow;
        
        for(int i=1; i<sum; i++) {
            if(sum % i == 0) {
                w = Math.max(i, sum/i);
                h = Math.min(i, sum/i);
            }
            if((2*w) + (2*h) - 4 == brown) break;
        }
        
        answer[0] = w;
        answer[1] = h;
        
        return answer;
    }
}