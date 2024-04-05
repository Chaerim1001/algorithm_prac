import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastAttackTime = attacks[attacks.length-1][0];
        Map<Integer, Integer> a = new HashMap<>();
        
        for(int[] attack: attacks) {
            a.put(attack[0], attack[1]);
        }
        
        int accumulatedTime = 0;
        int currentTime = 0;
        int currentHealth = health;
        
        boolean healthZero = false;
        while(currentTime<lastAttackTime) {
            currentTime++;
            
            if(a.containsKey(currentTime)) {
                accumulatedTime = 0;
                currentHealth -= a.get(currentTime);
                if(currentHealth <= 0) {
                    healthZero = true;
                    break;
                }
                continue;
            } 
            
            accumulatedTime++;
            
            if(accumulatedTime == bandage[0]) {
                currentHealth += (bandage[2] + bandage[1]);
                if(currentHealth > health) currentHealth = health;
                accumulatedTime = 0;
                continue;
            }
            
            currentHealth += bandage[1];
            if(currentHealth > health) currentHealth = health;
        }
        
        if(currentHealth<=0 || healthZero) {
            currentHealth = -1;
        }
        
        return currentHealth;
    }
}