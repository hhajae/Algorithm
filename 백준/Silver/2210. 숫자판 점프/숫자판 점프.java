import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();
    private static void dfs(int r, int c, String s, int cnt) {
        if (cnt == 6) {
            set.add(s);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            dfs(nx, ny, s + board[nx][ny], cnt + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s, " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String s = board[i][j] + "";
                dfs(i, j, s, 1);
            }
        }

        sb.append(set.size());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}