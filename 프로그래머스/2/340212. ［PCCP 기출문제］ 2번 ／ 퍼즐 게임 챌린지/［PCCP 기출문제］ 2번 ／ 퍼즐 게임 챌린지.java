class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        while(start < end) {
            int mid = (start + end) / 2; // 숙련도
            long tmpLimit = 0L;
            
            for(int i = 0; i < diffs.length; i++) {
                if(diffs[i] <= mid) {
                    tmpLimit += times[i];
                } else {
                    if(i == 0 && mid == 0) return 1; 
                    tmpLimit += ((diffs[i] - mid) * (times[i-1] + times[i])) + times[i];
                }
            }
            
            if(tmpLimit > limit) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}