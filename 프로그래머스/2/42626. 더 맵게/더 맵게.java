import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s: scoville) {
            q.offer(s);
        }
        
        while(q.size() > 1) {
            int now = q.poll();
            if(now>=K) break;
            
            int next = q.poll();
            
            now += (next*2);
            q.offer(now);
            count++;
        }
        
        int n = q.poll();
        
        if(n<K) {
            return -1;
        }
        
        return count;
    }
}