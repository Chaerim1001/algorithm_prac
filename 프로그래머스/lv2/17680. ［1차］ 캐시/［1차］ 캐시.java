import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        
        Queue<String> queue = new LinkedList<>();  
        int answer = 0;
             
        for(String city: cities) {
            String str = city.toUpperCase();
            if(queue.contains(str)) {
                answer += 1;
                queue.remove(str);
                queue.add(str);
            } else {
                answer += 5;
                if(queue.size() >= cacheSize) queue.poll();
                
                queue.add(str);
            }
        }
        return answer;
    }
}