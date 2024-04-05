import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++) {
            int count = 0;
            for(String n: photo[i]) {
                count += map.getOrDefault(n, 0);
            }
            answer[i] = count;
        }
        
        return answer;
    }
}