import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> s = new HashSet<String>();
        
        int len = dirs.length();
        
        int nowX = 0;
        int nowY = 0;
        
        for(int i=0; i<len; i++){
            int nextX = nowX;
            int nextY = nowY;
            String road = "";      
            
            if(dirs.charAt(i) == 'U'){
                nextY++;
                road += nowX;
                road += nowY;
                road += nextX;
                road += nextY;
            }else if(dirs.charAt(i) == 'D'){
                nextY--;
                road += nextX;
                road += nextY;
                road += nowX;
                road += nowY;
            }else if(dirs.charAt(i) == 'R'){
                nextX++;
                road += nowX;
                road += nowY;
                road += nextX;
                road += nextY;
            }else if(dirs.charAt(i) == 'L'){
                nextX--;
                road += nextX;
                road += nextY;
                road += nowX;
                road += nowY;
            }
            
            if(nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
                continue;
            
            s.add(road);
            nowX = nextX;
            nowY = nextY;
        }
        answer = s.size();
        return answer;
    }
}