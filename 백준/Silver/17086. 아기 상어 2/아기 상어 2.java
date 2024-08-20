import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		boolean[][] isvisited = new boolean[N][M];
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					que_x.offer(i); que_y.offer(j);
					dist[i][j] = 1;
				}
			}
		}
		/// input end ///
		int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
		while(!que_x.isEmpty()) {
			int cur_x = que_x.poll();
			int cur_y = que_y.poll();
			for (int i = 0; i < 8; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(dist[nx][ny] > 0) continue;
				que_x.offer(nx); que_y.offer(ny);
				dist[nx][ny] = dist[cur_x][cur_y] + 1;
			}
		}
		int maxSafeDist = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maxSafeDist = Math.max(maxSafeDist, dist[i][j]);
			}
		}
		bw.write((maxSafeDist-1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
