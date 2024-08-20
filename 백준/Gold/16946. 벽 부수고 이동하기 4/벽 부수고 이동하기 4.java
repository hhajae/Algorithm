import java.io.*;
import java.util.*;

public class Main {
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
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        /// input end ///
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Integer> que_x = new ArrayDeque<>();
        Queue<Integer> que_y = new ArrayDeque<>();
        boolean[][] isvisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != 0) continue;
                if(isvisited[i][j]) continue;
                isvisited[i][j] = true;
                int cnt = 0;
//                Set<int[]> isWall = new HashSet<>();
                Set<String> isWall = new HashSet<>();
                que_x.offer(i);
                que_y.offer(j);
                while(!que_x.isEmpty()) {
                    int cur_x = que_x.poll();
                    int cur_y = que_y.poll();
                    cnt++;
                    for(int k = 0; k < 4; k++) {
                        int nx = cur_x + dx[k];
                        int ny = cur_y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(board[nx][ny] != 0) {
//                            isWall.add(new int[]{nx, ny});
                            isWall.add(nx + "," + ny);
                            continue;

                        }
                        if(isvisited[nx][ny]) continue;
                        isvisited[nx][ny] = true;
                        que_x.offer(nx);
                        que_y.offer(ny);
                    }
                }
                for(String tmp : isWall) {
                    st = new StringTokenizer(tmp, ",");
                    board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] += cnt;

                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j] % 10);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
