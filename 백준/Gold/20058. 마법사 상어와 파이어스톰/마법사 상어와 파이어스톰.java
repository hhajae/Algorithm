import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        N = (int)Math.pow(2, N);
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] L = new int[Q];
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        /// input end ///
        for (int tc = 0; tc < Q; tc++) {
            board = rotate(L[tc], board);
            iceAge(board);
        }
        int totalIce = getTotalIce(N, board);;
        int maxDummySize = getMaxDummySize(N, board);
        getMaxDummySize(N, board);

        sb.append(totalIce).append("\n").append(maxDummySize);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMaxDummySize(int N, int[][] board) {
        int maxDummySize = 0;
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] isvisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 0) continue;
                if(isvisited[i][j]) continue;
                int dummySize = 1;
                isvisited[i][j] = true;
                que.offer(new int[]{i, j});
                while(!que.isEmpty()) {
                    int[] cur = que.poll();
                    int cur_x = cur[0];
                    int cur_y = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int nx = cur_x + dx[k];
                        int ny = cur_y + dy[k];
                        if(outOfRange(nx, ny, N)) continue;
                        if(isvisited[nx][ny]) continue;
                        if(board[nx][ny] == 0) continue;
                        dummySize++;
                        que.offer(new int[]{nx, ny});
                        isvisited[nx][ny] = true;
                    }
                }
                maxDummySize = Math.max(maxDummySize, dummySize);
            }
        }
        return maxDummySize;
    }

    private static int getTotalIce(int n, int[][] board) {
        int totalIce = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalIce += board[i][j];
            }
        }
        return totalIce;
    }

    private static int[][] rotate(int L, int[][] board) {
        int N = board.length;
        int[][] tmpboard = new int[N][N];
        L = (int)Math.pow(2, L);
        if(L == 1) return board;
        for (int i = 0; i < N; i+=L) {
            for (int j = 0; j < N; j+=L) {
                rotateDeep(i, j, L, board, tmpboard);
            }
        }
        return tmpboard;
    }

    private static void rotateDeep(int r, int c, int L, int[][] board, int[][] tmpboard) {
        int col = c + L - 1;
        for (int i = r; i < r + L; i++) {
            int row = r;
            for (int j = c; j < c + L; j++) {
                tmpboard[row++][col] = board[i][j];
            }
            col--;
        }
    }
    private static void iceAge(int[][] board) {
        int N = board.length;
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                findUnderIce(board, i, j, N, que);
            }
        }
        while (!que.isEmpty()) {
            int[] arr = que.poll();
            if(board[arr[0]][arr[1]] == 0) continue;
            board[arr[0]][arr[1]]--;
        }
    }

    private static void findUnderIce(int[][] board, int i, int j, int n, Queue<int[]> que) {
        int ice = 0;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(outOfRange(nx, ny, n)) continue;
            if(board[nx][ny] > 0) ice++;
        }
        if(ice < 3) que.offer(new int[]{i, j});
    }

    private static boolean outOfRange(int nx, int ny, int N) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }
}
