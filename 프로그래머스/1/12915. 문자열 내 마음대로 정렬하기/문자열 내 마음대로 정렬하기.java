import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, new Comparator<>(){
            @Override
            public int compare(String o1, String o2) {
                String a = String.valueOf(o1.charAt(n));
                String b = String.valueOf(o2.charAt(n));
                if(a.equals(b)) {
                    return o1.compareTo(o2);
                } else {
                    return a.compareTo(b);
                }
            }
        });
        
        return strings;
    }
}