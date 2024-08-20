import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        board = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (s.charAt(j) == 'S') board[i][j] = true;
            }
        }
        /// input end ///

        int[] npArr = new int[25];
        for (int i = 0; i < 7; i++) {
            npArr[25-i-1] = 1;
        }
        int resCnt = 0;
        do {
            int cnt = 0;
            int start_x = -1, start_y = -1;
            for (int i = 0; i < 25; i++) {
                if(npArr[i] == 0) continue;
                int x = i / 5;
                int y = i % 5;
                if(board[x][y]) {
                    cnt++;
                    start_x = x;
                    start_y = y;
                }
            }
            if(cnt < 4) continue;
            boolean[] isvisited = new boolean[25];
            dfs(npArr, start_x, start_y, 0, isvisited);
            int visitCnt = 0;
            for (int i = 0; i < 25; i++) {
                if(isvisited[i]) visitCnt++;
            }
            if(visitCnt == 7) {
                resCnt++;
            }

        } while(np(npArr));
        sb.append(resCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int[] npArr, int r, int c, int N, boolean[] isvisited) {
        int pos = (5*r) + c;
        if(isvisited[pos]) return;
        isvisited[pos] = true;
        for(int k = 0; k < 4; k++) {
            int nx = r + dx[k];
            int ny = c + dy[k];
            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if(npArr[nx*5 + ny] == 0) continue;
            dfs(npArr, nx, ny, N+1, isvisited);
        }
    }

    private static boolean np(int[] p) {
        int N = p.length;

        int x = N-1;
        while(x > 0 && p[x-1] >= p[x]) x--;
        if(x == 0) return false;

        int y = N-1;
        while(p[x-1] >= p[y]) y--;

        int tmp = p[x-1];
        p[x-1] = p[y];
        p[y] = tmp;

        int z = N-1;
        while(x < z) {
            tmp = p[x];
            p[x++] = p[z];
            p[z--] = tmp;
        }
        return true;
    }
}
