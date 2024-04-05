import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            map1.put(players[i], i+1);
            map2.put(i+1, players[i]);
        }
        
        for(String name: callings) {
            int current = map1.get(name);
            String name2 = map2.get(current-1);
            
            map1.put(name, current-1);
            map1.put(name2, current);
            map2.put(current, name2);
            map2.put(current-1, name);
        }
        
        String[] answer = new String[players.length];
        for(int i=1; i<=players.length; i++) {
            answer[i-1] = map2.get(i);
        }
        return answer;
    }
}