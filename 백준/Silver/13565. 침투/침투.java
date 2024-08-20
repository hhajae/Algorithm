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
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] grid = new int[M][N];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = s.charAt(j) - '0';
			}
		}
		/// input end ///
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		boolean[][] isvisited = new boolean[M][N];
		boolean swc = false;
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < N; j++) {
				if(swc) break;
				if(grid[i][j] == 1) continue;
				if(isvisited[i][j]) continue;
				que_x.offer(i); que_y.offer(j);
				isvisited[i][j] = true;
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					for (int k = 0; k < 4; k++) {
						int nx = cur_x + dx[k];
						int ny = cur_y + dy[k];
						if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
						if(isvisited[nx][ny]) continue;
						if(grid[nx][ny] == 1) continue;
						if(nx == M-1) {
							swc = true;
							que_x.clear();
							break;
						}
						isvisited[nx][ny] = true;
						que_x.offer(nx); que_y.offer(ny);
					}
				}
			}
		}
		if(swc) bw.write("YES");
		else bw.write("NO");
		
		bw.flush();
		br.close();
		bw.close();
	}
}