import java.util.*;

class Solution {
    static Map<String, Integer> profit;
    static Map<String, String> recommended_person;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        profit = new HashMap<>();
        recommended_person = new HashMap<>();
        
        for(int i=0; i<enroll.length; i++) {
            profit.put(enroll[i], 0);
            recommended_person.put(enroll[i], referral[i]);
        }
        
        for(int i=0; i<seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
    
    static void dfs(String person, int money) {
        if(person.equals("-")) return;
        if(money == 0) return;
        
        int temp = profit.get(person);
        int my_money = money - (money/10);
        profit.put(person, temp+my_money);
        dfs(recommended_person.get(person), money/10);
    }
}