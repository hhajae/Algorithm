import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int maxDist = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            st = new StringTokenizer(s, " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] board = new int[N][N];
            for (int i = 0; i < M; i++) {
                s = br.readLine();
                st = new StringTokenizer(s, " ");
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());
                board[x][y] = w;
                board[y][x] = w;
            }
            int K = Integer.parseInt(br.readLine());
            int[] friends = new int[N];
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            for (int i = 0; i < K; i++) {
                friends[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board[i][j] == 0) {
                        board[i][j] = maxDist;
                    }
                }
            }
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    if(i == k) continue;
                    for (int j = 0; j < N; j++) {
                        if(i == j) continue;
                        board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
                    }
                }
            }
            int minDist = Integer.MAX_VALUE;
            int minInd = N+1;

            for (int i = 0; i < N; i++) {
                int dist = 0;
                for (int j = 0; j < K; j++) {
                    int friend = friends[j];
                    int d = board[friend][i] == maxDist ? 0 : board[friend][i];
                    dist += d;
                }
                if(dist < minDist) {
                    minDist = dist;
                    minInd = i;
                }
            }
            sb.append(minInd+1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
