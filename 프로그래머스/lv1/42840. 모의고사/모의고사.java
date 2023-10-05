import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int oneCnt = countAnswer(one, answers);
        int twoCnt = countAnswer(two, answers);
        int threeCnt = countAnswer(three, answers);
        
        List<Integer> temp = new ArrayList<>();
        int max = Math.max(oneCnt, Math.max(twoCnt, threeCnt));
        
        if(max == oneCnt) temp.add(1);
        if(max == twoCnt) temp.add(2);
        if(max == threeCnt) temp.add(3);
        
        int[] answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
    
    private int countAnswer(int[] personAnswer, int[] answers) {
        int count = 0;
        
        if(personAnswer[0] == answers[0]) count++;
        for(int i=1; i<answers.length; i++) {    
            if(personAnswer[i%personAnswer.length] == answers[i]) count++;
        }
        
        return count;
    }
}