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
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        List<int[]> lst =new ArrayList<int[]>();
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) {
                    lst.add(new int[]{i, j});
                }
            }
        }
        /// input end ///
        int[] npArr = new int[lst.size()];
        for (int i = 0; i < 2; i++) {
            npArr[lst.size() - i - 1] = 1;
        }
        int maxRes = 0;
        do {
            List<int[]> saveLst = new ArrayList<>();
            for (int i = 0; i < lst.size(); i++) {
                if(npArr[i] == 0) continue;
                int[] arr = lst.get(i);
                saveLst.add(arr);
                board[arr[0]][arr[1]] = 1;
            }
            boolean[][] isvisited = new boolean[N][M];
            Queue<int[]> que = new ArrayDeque<>();
            int sumCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(board[i][j] == 0 || board[i][j] == 1) continue;
                    if(isvisited[i][j]) continue;
                    isvisited[i][j] = true;
                    que.offer(new int[]{i, j});
                    int cnt = 1;
                    boolean swc = false;
                    bfs: while(!que.isEmpty()) {
                        int[] arr = que.poll();
                        int cur_x = arr[0];
                        int cur_y = arr[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = cur_x + dx[k];
                            int ny = cur_y + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if(isvisited[nx][ny]) continue;
                            if(board[nx][ny] == 1) continue;
                            if(board[nx][ny] == 0) {
                                swc = true;
                            }
                            cnt++;
                            isvisited[nx][ny] = true;
                            que.offer(new int[]{nx, ny});
                        }
                    }
                    if(!swc) {
                        sumCnt += cnt;
                    }
                }
            }
            maxRes = Math.max(maxRes, sumCnt);
            for (int i = 0; i < 2; i++) {
                int[] arr = saveLst.get(i);
                board[arr[0]][arr[1]] = 0;
            }
        } while(np(npArr));
        sb.append(maxRes);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
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
