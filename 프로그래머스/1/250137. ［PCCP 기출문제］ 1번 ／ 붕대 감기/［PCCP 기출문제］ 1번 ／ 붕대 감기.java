import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackCnt = attacks.length;
        int startHealth = health;
        Map<Integer, Integer> attackMap = new HashMap<>();
        int lastTime = 0;
        for(int[] attack : attacks) {
            attackMap.put(attack[0], attack[1]);
            lastTime = attack[0];
        }
        
        int continuousHealTime = 0;
        int curTime = 0;
        while(true) {
            curTime++;
            if(attackMap.containsKey(curTime)) {
                health -= attackMap.get(curTime);
                if(health <= 0) {
                    return -1;
                }
                if(--attackCnt <= 0) {
                    break;
                }
                continuousHealTime = 0;
                continue;
            }
            
            health += bandage[1];
            if(++continuousHealTime == bandage[0]) {
                health += bandage[2];
                continuousHealTime = 0;
            }
            if(health > startHealth) {
                health = startHealth;
            }
            
            if(curTime == lastTime) {
                break;
            }
            
        }
        
        return health;
    }
}