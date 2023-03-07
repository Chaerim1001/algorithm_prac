import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> win_nums_map = new HashMap<>();
        int zero_count = 0;
        int lotto_count = 0;
        int min = 0;
        int max = 0;
        
        for(int num: win_nums) {
            win_nums_map.put(num, 0);
        }
        
        for(int lotto: lottos) {
            if(lotto == 0) zero_count++;
            else {
                if(win_nums_map.getOrDefault(lotto, -1) != -1) {
                    lotto_count++;
                    win_nums_map.remove(lotto);
                }
            }
        }
        
        if(zero_count != 0) max = lotto_count + zero_count;
        
        switch(lotto_count) {
            case 6: max = 1; min = 1;
                break;
            case 5: min = 2;
                break;
            case 4: min = 3;
                break;
            case 3: min = 4;
                break;
            case 2: min = 5;
                break;
            default: min = 6;
        }
        
        if(zero_count == 0) max = min;
        else {
            switch(max) {
                case 6: max = 1;
                    break;
                case 5: max = 2;
                    break;
                case 4: max = 3;
                    break;
                case 3: max = 4;
                    break;
                case 2: max = 5;
                    break;
                default: max = 6;
            }
        }
        
        int[] answer = {max, min}; 
        return answer;      
    }
}