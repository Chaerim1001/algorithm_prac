import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max_w = 0;
        int max_h = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]); 
        }
        
        for (int i = 0; i < sizes.length; i++) {
            if (max_h < sizes[i][0]) max_h = sizes[i][0]; 
            if (max_w < sizes[i][1]) max_w = sizes[i][1]; 
        }
        
        return max_w * max_h;
    }
}