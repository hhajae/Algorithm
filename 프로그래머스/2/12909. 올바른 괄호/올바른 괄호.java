import java.util.*;
import java.lang.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stk.add('(');
                continue;
            }
            if(c == ')') {
                if(stk.isEmpty()) return false;
                if(stk.peek() == '(') stk.pop();
            }
        }
        if(stk.isEmpty()) return true;
        else return false;

    }
}