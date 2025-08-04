import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char pre = s.charAt(0);
        if(pre == ' ') {
            sb.append(" ");
        } else if ('a' <= pre && pre <= 'z') {
            sb.append((char)(pre - 32));
        } else {
            sb.append(pre);
        }
        for(int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(pre == ' ') {
                if(cur == ' ') {
                    sb.append(" ");
                    continue;
                }
                sb.append(s.substring(i, i+1).toUpperCase());
                pre = cur;
            } else if(cur == ' ') {
                pre = ' ';
                sb.append(" ");
            } else {
                pre = cur;
                sb.append(s.substring(i, i+1).toLowerCase());
            }
        }
        
        return sb.toString();
    }
}