import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] map = new char[park.length][park[0].length()];
        
        int nowX = -1;
        int nowY = -1;
        
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length(); j++) {
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S') {
                    nowX = i;
                    nowY = j;
                }
            }    
        }

        for(String route: routes) {
            String[] r = route.split(" ");
            String op = r[0];
            int n = Integer.parseInt(r[1]);
            
            if(op.equals("N")) {
                int nx = nowX + (n*(-1));
                if(nx<0) continue;
                
                boolean result = true;
                int x = nowX;
                for(int i=0; i<n; i++) {
                    x--;
                    if(map[x][nowY] == 'X') {
                        result = false;
                        break;
                    }
                }   
                if(result) nowX = nx;
                
            } else if(op.equals("S")) {
                int nx = nowX + n;
                if(nx>=park.length) continue;
                
                boolean result = true;
                int x = nowX;
                for(int i=0; i<n; i++) {
                    x++;
                    if(map[x][nowY] == 'X') {
                        result = false;
                        break;
                    }
                } 
                if(result) nowX = nx;
            } else if(op.equals("W")) {
                int ny = nowY + n*(-1);
                if(ny<0) continue;
                
                boolean result = true;
                int y = nowY;
                for(int i=0; i<n; i++) {
                    y--;
                    if(map[nowX][y] == 'X') {
                        result = false;
                        break;
                    }
                } 
                if(result) nowY = ny;
            } else {
                int ny = nowY + n;
                if(ny>=park[0].length()) continue;
                
                boolean result = true;
                int y = nowY;
                for(int i=0; i<n; i++) {
                    y++;
                    if(map[nowX][y] == 'X') {
                        result = false;
                        break;
                    }
                } 
                if(result) nowY = ny;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = nowX;
        answer[1] = nowY;
        
        return answer;
    }

}