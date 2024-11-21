import java.util.*;

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Pos=[" + x + "," + y + "]";
    }
}
class Robot {
    int[] routeOfPoint;
    List<Pos> routeOfPos = new ArrayList<>();
    
    public Robot(int[] routeOfPoint, Pos start) {
        this.routeOfPoint = routeOfPoint;
        routeOfPos.add(start);
    }
    
    public void addPos(Pos pos) {
        routeOfPos.add(pos);
    }
}

class Solution {
    public int solution(int[][] points, int[][] routes) {

        List<List<Pos>> posList = new ArrayList<>();
        
        List<Robot> robots = new ArrayList<>();
        for(int[] route : routes) {
            int[] point = points[route[0] - 1];
            robots.add(new Robot(route, new Pos(point[0] - 1, point[1] - 1)));
        }
        
        for(Robot robot : robots) {
            int[] routeOfPoint = robot.routeOfPoint;
            for(int i = 0; i < routeOfPoint.length - 1; i++) {
                int startPointInd = routeOfPoint[i] - 1;
                int endPointInd = routeOfPoint[i+1] - 1;
                int[] startPoint = points[startPointInd];
                int[] endPoint = points[endPointInd];
                int startX = startPoint[0] - 1;
                int startY = startPoint[1] - 1;
                int endX = endPoint[0] - 1;
                int endY = endPoint[1] - 1;
                
                // row
                boolean isFirst = true;
                while(true) {
                    int row = startX - endX;
                    if(row < 0) {
                        startX++;
                        robot.addPos(new Pos(startX, startY));
                        isFirst = false;
                    } else if (row > 0) {
                        startX--;
                        robot.addPos(new Pos(startX, startY));
                        isFirst = false;
                    } else if (row == 0) {
                        if(isFirst) break;
                        // robot.addPos(new Pos(startX, startY));
                        break;
                    }
                }
                
                // col
                isFirst = true;
                while(true) {
                    int col = startY - endY;
                    if(col < 0) {
                        startY++;
                        robot.addPos(new Pos(startX, startY));
                        isFirst = false;
                    } else if (col > 0) {
                        startY--;
                        robot.addPos(new Pos(startX, startY));
                        isFirst = false;
                    } else if (col == 0) {
                        if(isFirst) break;
                        // robot.addPos(new Pos(startX, startY));
                        break;
                    }
                }
            }
            posList.add(robot.routeOfPos);
        } // end robot
        
        int maxTime = 0;
        for(List<Pos> lst : posList) {
            maxTime = Math.max(lst.size(), maxTime);
        }
            
        int result = 0;
        for(int t = 0; t < maxTime; t++) {
            Map<String, Integer> map = new HashMap<>();
            for(List<Pos> pst : posList) {
                if(pst.size() <= t) continue;
                String posStr = pst.get(t).toString();
                map.put(posStr, map.getOrDefault(posStr, 0) + 1);
            }
            for(String key : map.keySet()) {
                if(map.get(key) > 1) result++;
            }
        }
        
        return result;
        
    }
}