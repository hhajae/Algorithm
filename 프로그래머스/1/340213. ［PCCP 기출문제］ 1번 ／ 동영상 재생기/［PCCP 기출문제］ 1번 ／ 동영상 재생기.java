import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringTokenizer st = null;
        
        st = new StringTokenizer(video_len, ":");
        int maxMinute = timeToInt(st.nextToken());
        int maxSecond = timeToInt(st.nextToken());
        
        st = new StringTokenizer(op_start, ":");
        int opStartMinute = timeToInt(st.nextToken());
        int opStartSecond = timeToInt(st.nextToken());
        
        st = new StringTokenizer(op_end, ":");
        int opEndMinute = timeToInt(st.nextToken());
        int opEndSecond = timeToInt(st.nextToken());
        
        st = new StringTokenizer(pos, ":");
        int startMinute = timeToInt(st.nextToken());
        int startSecond = timeToInt(st.nextToken());
        // 오프닝 안에 들어갔는지
        if(opStartMinute <= startMinute && startMinute <= opEndMinute) {
            if(opStartMinute == startMinute && opEndMinute == startMinute) {
                if(opStartSecond <= startSecond && startSecond <= opEndSecond) {
                    pos = op_end;
                }
            } else if(opStartMinute == startMinute) {
                if(opStartSecond <= startSecond) {
                    pos = op_end;
                }
            } else if(opEndMinute == startMinute) {
                if(opEndSecond >= startSecond) {
                    pos = op_end;
                }
            } else {
                pos = op_end;
            }
        }
        for(String command : commands) {
            st = new StringTokenizer(pos, ":");
            int minute = timeToInt(st.nextToken());
            int second = timeToInt(st.nextToken());
            if("next".equals(command)) {
                second += 10;
                if(second >= 60) {
                    minute++;
                    second -= 60;
                }
                // 최대 시간 넘었는지
                if(minute >= maxMinute) {
                    if(second >= maxSecond) {
                        pos = video_len;
                        continue;
                    }
                }
                
                // 오프닝 안에 들어갔는지
                if(opStartMinute <= minute && minute <= opEndMinute) {
                    if(opStartMinute == minute && opEndMinute == minute) {
                        if(opStartSecond <= second && second <= opEndSecond) {
                            pos = op_end;
                            continue;
                        }
                    } else if(opStartMinute == minute) {
                        if(opStartSecond <= second) {
                            pos = op_end;
                            continue;
                        }
                    } else if(opEndMinute == minute) {
                        if(opEndSecond >= second) {
                            pos = op_end;
                            continue;
                        }
                    } else {
                        pos = op_end;
                        continue;
                    }
                }
                
                pos = intToTime(minute, second);
                
            } else if ("prev".equals(command)) {
                second -= 10;
                if(second < 0) {
                    minute--;
                    second += 60;
                }
                
                // 최소 시간 
                if(minute < 0) {
                    minute = 0;
                    second = 0;
                }
                
                // 오프닝 안에 들어갔는지
                if(opStartMinute <= minute && minute <= opEndMinute) {
                    if(opStartMinute == minute && opEndMinute == minute) {
                        if(opStartSecond <= second && second <= opEndSecond) {
                            pos = op_end;
                            continue;
                        }
                    } else if(opStartMinute == minute) {
                        if(opStartSecond <= second) {
                            pos = op_end;
                            continue;
                        }
                    } else if(opEndMinute == minute) {
                        if(opEndSecond >= second) {
                            pos = op_end;
                            continue;
                        }
                    } else {
                        pos = op_end;
                        continue;
                    }
                }
                
                pos = intToTime(minute, second);
            }
        }
        return pos;
    }
    
    private static int timeToInt(String time) {
        if(time.charAt(0) == '0') {
            time = time.substring(1);
        }
        return Integer.parseInt(time);
    }
    
    private static String intToTime(int minute, int second) {
        if(minute < 10) {
            if(second < 10) {
                return "0" + minute + ":" + "0" + second;
            }
            return "0" + minute + ":" + second;
        }
        
        if(second < 10) {
            return minute + ":0" + second;
        }
        
        return minute + ":" + second;
    }
}