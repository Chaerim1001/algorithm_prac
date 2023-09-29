import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            days.add((int) Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }
        
        int cnt = 1;
        int day = days.poll();
        List<Integer> tempList = new ArrayList<>();
        while(!days.isEmpty()) {
            if(day < days.peek()) {
                tempList.add(cnt);
                day = days.poll();
                cnt = 1;
            } else {
                days.poll();
                cnt++;
            }
        } 
        tempList.add(cnt);
        
        int[] answer = new int[tempList.size()];
        for(int i=0; i<tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }
        
        return answer;
    }
}