import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> giftCount = new HashMap<>(); // 선물 지수 계산
        Map<String, Integer> nextGift = new HashMap<>();

        for(String name: friends) {
            giftCount.put(name, 0);
            nextGift.put(name, 0);
        }
        
        Map<String, Integer> friendCount = new HashMap<>(); // 두 사람의 선물
        for(String gift: gifts) {
            if(friendCount.containsKey(gift)) {
                friendCount.put(gift, friendCount.get(gift)+1);
            } else {
                friendCount.put(gift, 1);
            }
            
            String[] person = gift.split(" ");
            String sender = person[0];
            String receiver = person[1];
            
            giftCount.put(sender, giftCount.get(sender)+1);
            giftCount.put(receiver, giftCount.get(receiver)-1);
        }
               
        for(int i=0; i<friends.length-1; i++) {
            String a = friends[i];
            for(int j=i+1; j<friends.length; j++) {
                String b = friends[j];
                int aToB = friendCount.getOrDefault(a+" "+b, 0);
                int bToA = friendCount.getOrDefault(b+" "+a, 0);
                
                if(aToB > bToA) {
                    nextGift.put(a, nextGift.get(a)+1);
                } else if(aToB < bToA) {
                    nextGift.put(b, nextGift.get(b)+1);
                } else {
                    int aCount = giftCount.get(a);
                    int bCount = giftCount.get(b);
                    if(aCount > bCount) nextGift.put(a, nextGift.get(a)+1);
                    else if(aCount < bCount) nextGift.put(b, nextGift.get(b)+1);
                }
            }
        }
        
        int maxGift = Integer.MIN_VALUE;
        for(String n: nextGift.keySet()) {
            maxGift = Math.max(maxGift, nextGift.get(n));
        }        
        
        return maxGift;
    }
}