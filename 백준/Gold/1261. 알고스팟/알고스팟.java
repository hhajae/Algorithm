import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
        	s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {0, 0, 0});
        dist[0][0] = 0;
        while(!que.isEmpty()) {
        	int[] cur = que.poll();
        	int cur_x = cur[0];
        	int cur_y = cur[1];
        	int cur_break = cur[2];
        	for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(dist[nx][ny] != -1) { // 이미 방문했다
					if(board[nx][ny] == 1) {
						if(cur_break + 1 >= dist[nx][ny]) continue;
						else {
							dist[nx][ny] = cur_break + 1;
							que.offer(new int[] {nx, ny, cur_break + 1});
							continue;
						}
					}
					else {
						if(cur_break >= dist[nx][ny]) continue;
						else {
							dist[nx][ny] = cur_break;
							que.offer(new int[] {nx, ny, cur_break});
							continue;
						}
					}
				}
				if(board[nx][ny] == 1) {
					dist[nx][ny] = cur_break + 1;
					que.offer(new int[] {nx, ny, cur_break + 1});
				}
				else {
					dist[nx][ny] = cur_break;
					que.offer(new int[] {nx, ny, cur_break});
				}
			}
        }
        sb.append(dist[N-1][M-1]);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
