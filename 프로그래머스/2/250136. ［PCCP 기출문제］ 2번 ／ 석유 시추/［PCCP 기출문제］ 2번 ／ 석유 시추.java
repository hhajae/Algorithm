import java.util.*;

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int solution(int[][] land) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int N = land.length;
        int M = land[0].length;
        
        int maxResult = 0;
        int[][] newLand = new int[N][M]; // 그룹 번호를 가짐
        
        int groupCnt = 0;
        List<Integer> groupLst = new ArrayList<>();
        groupLst.add(Integer.MIN_VALUE);
        
        boolean[][] isvisited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(land[i][j] == 0 || isvisited[i][j]) continue;
                int cnt = 0;
                groupCnt++;
                isvisited[i][j] = true;
                newLand[i][j] = groupCnt;
                Queue<Pos> que = new ArrayDeque<>();
                que.offer(new Pos(i, j));
                
                while(!que.isEmpty()) {
                    Pos cur = que.poll();
                    cnt++;
                    for(int d = 0; d < 4; d++) {
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if(land[nx][ny] == 0 || isvisited[nx][ny]) continue;
                        isvisited[nx][ny] = true;
                        newLand[nx][ny] = groupCnt;
                        que.offer(new Pos(nx, ny));
                    }
                }
                
                groupLst.add(cnt);
            }
        }
        
        for(int i = 0; i < M; i++) {
            int result = 0;
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < N; j++) {
                if(land[j][i] == 0) continue;
                int groupNum = newLand[j][i];
                if(set.contains(groupNum)) continue;
                result += groupLst.get(groupNum);
                set.add(groupNum);
            }
            maxResult = Math.max(maxResult, result);
        }
        
        
        return maxResult;
        
    }
}