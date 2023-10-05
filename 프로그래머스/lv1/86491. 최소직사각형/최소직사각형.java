import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        
        for(int[] size: sizes) {
            int tempMax = Math.max(size[0], size[1]);
            int tempMin = Math.min(size[0], size[1]);
            if(tempMax > max) max = tempMax;
            if(tempMin > min) min = tempMin;
        }

        return max * min;
    }
}