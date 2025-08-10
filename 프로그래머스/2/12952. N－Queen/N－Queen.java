import java.util.*;
import java.lang.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0, -1, -1,  1, 1};
    static int[] dy = {0, 0, -1, 1, -1,  1, -1, 1};
    static int result;
    private static void dfs(int n, boolean[][] board, int r) {
        // for(int rr = 0; rr < n; rr++) {
        //     for(int cc = 0; cc < n; cc++) {
        //         if(board[rr][cc]) {
        //             System.out.print("1 ");                        
        //         } else {
        //             System.out.print("0 ");
        //         }
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        if(r >= n) {
            result++;
            return;
        }
        for(int c = 0; c < n; c++) {
            if(board[r][c]) continue;
            boolean[][] board2 = new boolean[n][n]; // 새로운 배열 or 갔다와서 true 해제?
            for(int i = 0; i < n; i++) {
                board2[i] = Arrays.copyOf(board[i], n);
            }
            board2[r][c] = true;
            visit(n, r, c, board2);
            dfs(n, board2, r+1);
        }
        
    }
    public int solution(int n) {
        result = 0;        
        
        for(int i = 0; i < n; i++) {
            boolean[][] board = new boolean[n][n];
            board[0][i] = true;
            visit(n, 0, i, board);
            dfs(n, board, 0+1);
        }
        
        return result;
    }
    private static void visit(int n, int r, int c, boolean[][] board) {
        for(int i = 0; i < 8; i++) {
            for(int j = 1; j <= n; j++) {
                int nx = r + (j * dx[i]);
                int ny = c + (j * dy[i]);
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                board[nx][ny] = true;
            }
        }
    }
}
     