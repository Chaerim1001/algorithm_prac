import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> dict = new HashMap<>();
        
        for(int i=1; i<27; i++) {
            String alphabet = (char)(64 + i) + "";
            dict.put(alphabet, i);
        }
        
        int num = 27;
        int index = 0;
        while(index < msg.length()) {
            String w = "";
            while(index < msg.length()) {
                if(!dict.containsKey(w+msg.charAt(index))) break;
                else w += msg.charAt(index);
                index++;
            }
            
            answer.add(dict.get(w));
            if(index<msg.length()) dict.put(w+msg.charAt(index), num++);
        }
        
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) result[i] = answer.get(i);
        
        return result;
    }
}