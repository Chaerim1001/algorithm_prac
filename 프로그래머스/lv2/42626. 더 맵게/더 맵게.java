import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int s: scoville) {
            pq.add(s);
        }

        int answer = 0;
        int min = pq.peek();
        while (K > min && pq.size() > 1) {
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + (b * 2));
            min = pq.peek();
        }

        if (K > min) return -1;

        return answer;
    }
}