import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer,Integer> lostMap = new HashMap<>();
        Map<Integer,Integer> reserveMap = new HashMap<>();
        
        for(int num: lost) {
            lostMap.put(num, 1);
        }

        for(int num: reserve) {
            if(lostMap.getOrDefault(num, 0) == 0) reserveMap.put(num, 1);
            else lostMap.remove(num);
        }

        int answer = n - lostMap.size();

        for(int num: lostMap.keySet()) {
            if(reserveMap.getOrDefault(num-1, 0) == 1) {
                answer++;
                reserveMap.remove(num-1);
            } else if(reserveMap.getOrDefault(num+1, 0) == 1) {
                answer++;
                reserveMap.remove(num+1);
            }
        }
        
        return answer;           
    }
}