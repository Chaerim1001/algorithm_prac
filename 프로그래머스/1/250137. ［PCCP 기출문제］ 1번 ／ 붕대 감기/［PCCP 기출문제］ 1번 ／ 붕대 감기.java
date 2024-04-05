import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int count = bandage[0];
        int currentHealth = health;
        int lastAttackTime = 0;
        
        int v1, v2;
        for(int[] attack: attacks) {
            if(currentHealth <= 0) return -1;
            
            v1 = attack[0] - lastAttackTime - 1;
            v2 = v1/count;
            
            lastAttackTime = attack[0];
            currentHealth = Math.min(health, currentHealth + (v1 * bandage[1]));
            currentHealth = Math.min(health, currentHealth + (v2 * bandage[2]));
            currentHealth -= attack[1];
        }
        
        return currentHealth<=0 ? -1 : currentHealth;
    }
}