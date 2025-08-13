import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        int size = s.length();
        answer = new int[size];
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
                answer[i] = -1;
            } else {
                answer[i] = map.get(c);
                map.replace(c, 0);
            }
            Set<Character> keys = map.keySet();
            for(Character key : keys) {
                map.replace(key, map.get(key) + 1);
            }
        }
    
        return answer;
    }
}