import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = 1;
        int min = 100_000;
        
        while(max<=min) {
            int mid = (max+min)/2;
            long total_time = calculateTotalTime(diffs, times, mid);
            if(total_time > limit) {
                max = mid+1;
            } else {
                min = mid-1;
            }
        }
        
        return max;
    }
    
    static long calculateTotalTime(int[] diffs, int[] times, int level) {
        long total_time = 0;
        int time_prev = 0;
        int time_cur = 0;
        
        for(int i=0; i<diffs.length; i++) {
            time_cur = times[i];
            if(diffs[i]>level) {
                int n = diffs[i]-level;
                total_time += ((long)(n+1)*time_cur + (long)(n*time_prev));
            } else {
                total_time += time_cur;
            }

            time_prev = time_cur;
        }
        return total_time;
    }
    
}