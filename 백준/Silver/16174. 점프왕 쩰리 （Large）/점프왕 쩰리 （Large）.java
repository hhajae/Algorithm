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
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/// input end ///
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		que_x.offer(0); que_y.offer(0);
		boolean[][] isvisited = new boolean[N][N];
		isvisited[0][0] = true;
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		while(!que_x.isEmpty()) {
			int cur_x = que_x.poll();
			int cur_y = que_y.poll();
			int curV = board[cur_x][cur_y];
			for (int i = 0; i < 2; i++) {
				int nx = cur_x + curV * dx[i];
				int ny = cur_y + curV * dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(isvisited[nx][ny]) continue;
				if(board[nx][ny] == -1) {
					bw.write("HaruHaru");
					bw.flush();
					bw.close();
					br.close();
					return;
				}
				isvisited[nx][ny] = true;
				que_x.offer(nx); que_y.offer(ny);
			}
		}
		bw.write("Hing");
		
		bw.flush();
		bw.close();
		br.close();
	}
}