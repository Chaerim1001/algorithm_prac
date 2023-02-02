import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: tangerine) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());

        keySet.sort((s1, s2) -> map.get(s2).compareTo(map.get(s1)));

        int count = 0;
        
        for(int key: keySet) {
            if(k <= 0) break;
            k -= map.get(key);
            count++;
        }
        
        return count;
    }
}