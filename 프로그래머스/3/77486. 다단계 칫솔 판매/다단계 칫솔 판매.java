import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> recommender = new HashMap<>();
        for(int i=0; i<enroll.length; i++) {
            if(referral[i].equals("-")) {
                recommender.put(enroll[i], "center");
            } else {
                recommender.put(enroll[i], referral[i]);
            }
        }

        Map<String, Integer> money = new HashMap<>();  
        money.put("center", 0);
        for(int i=0; i<enroll.length; i++) {
            money.put(enroll[i], 0);
        }
        
        for(int i=0; i<seller.length; i++) {
            String now_name = seller[i];
            int now_money = amount[i] * 100;
            String next_name;
            int next_money;
            
            while(true) {
                if(now_name.equals("center")) break;
                
                next_name = recommender.get(now_name);
                next_money = now_money / 10;
                
                if(next_money<1) {
                    money.put(now_name, Integer.valueOf(money.get(now_name) + now_money));
                    break;
                }
                
                money.put(now_name, Integer.valueOf(money.get(now_name) + now_money - next_money));
                now_name = next_name;
                now_money = next_money;
            }
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
            String name = enroll[i];
            answer[i] = money.get(name);
        }
        
        return answer;
    }
}