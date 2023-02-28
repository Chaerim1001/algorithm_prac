import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supoja1 = {1,2,3,4,5}; // 5
        int[] supoja2 = {2,1,2,3,2,4,2,5}; // 8
        int[] supoja3 = {3,3,1,1,2,2,4,4,5,5}; // 10

        List<Integer> count = new ArrayList<>(Arrays.asList(0,0,0,0));
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i< answers.length; i++) {
            if(answers[i] == supoja1[i% supoja1.length]) count.set(1, count.get(1) + 1);
            if(answers[i] == supoja2[i% supoja2.length]) count.set(2, count.get(2) + 1);
            if(answers[i] == supoja3[i% supoja3.length]) count.set(3, count.get(3) + 1);
        }
        
        int max = Collections.max(count);
        for(int i=1; i< count.size(); i++) {
            if(count.get(i) == max) {
                answer.add(i);
            }
        }
        
        Collections.sort(answer);
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}