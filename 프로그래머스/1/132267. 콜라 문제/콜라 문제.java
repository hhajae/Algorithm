import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int a, int b, int n) {
        int total = 0;
        while(true) { 
            int quatient = n / a;
            int remain = n % a;
            
            total += quatient * b;
            n = (quatient * b) + remain;
            
            if(n < a) break;
        }
        return total;
    }
}