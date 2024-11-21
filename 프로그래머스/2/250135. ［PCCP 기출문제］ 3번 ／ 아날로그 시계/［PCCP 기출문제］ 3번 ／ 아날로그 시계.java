class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 남은 초 계산
        int startTimeSecond = h1 * 3600 + m1 * 60 + s1;
        int endTimeSecond = h2 * 3600 + m2 * 60 + s2;
        
        int remainSecond = endTimeSecond - startTimeSecond;
        
        int curSecondPos = s1 * 60 * 12;
        int curMinutePos = m1 * 60 * 12 + (s1 * 12);
        int curHourPos = (h1 > 12 ? (h1-12) * 300 * 12 : h1 == 12 ? 0 : h1 * 300 * 12) + (m1 * 5 * 12) + s1;
        
        int result = 0;

        if(curSecondPos == curMinutePos || curSecondPos == curHourPos) {
            result++;
        }
        
        for(int i = 0; i < remainSecond; i++) {
            int nextSecondPos = curSecondPos + (60 * 12);
            
            if(curSecondPos < curMinutePos && curMinutePos < nextSecondPos) {
                result++;
            }
            
            if(curSecondPos < curHourPos && curHourPos < nextSecondPos) {
                result++;
            }
            
            curMinutePos += 12;
            if(curMinutePos == 3600 * 12) curMinutePos = 0;
            
            curHourPos++;
            if(curHourPos == 3600 * 12) curHourPos = 0;
            
            if(curHourPos == curMinutePos) result--;
            
            curSecondPos = nextSecondPos;
            if(curSecondPos == 3600 * 12) curSecondPos = 0;
        }
        
        return result;
    }
}