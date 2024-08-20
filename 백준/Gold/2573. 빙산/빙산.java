import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	static int[][] mountain;
	private static void melt() {
		Queue<int[]> que = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(mountain[i][j] == 0) continue;
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(mountain[nx][ny] == 0) cnt++;
				}
				if(cnt > 0) {
					que.offer(new int[] {i, j, cnt});
				}
			}
		}
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			mountain[cur[0]][cur[1]] -= cur[2];
			if(mountain[cur[0]][cur[1]] < 0) mountain[cur[0]][cur[1]] = 0; 
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mountain = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				mountain[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/// input end ///
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		boolean[][] isvisited = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(mountain[i][j] == 0) continue;
				if(isvisited[i][j]) continue;
				cnt++;
				if(cnt > 1) {
					bw.write("0"); bw.flush(); bw.close(); br.close(); return;
				}
				que_x.offer(i); que_y.offer(j);
				isvisited[i][j] = true;
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					for (int d = 0; d < 4; d++) {
						int nx = cur_x + dx[d];
						int ny = cur_y + dy[d];
						if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
						if(isvisited[nx][ny]) continue;
						if(mountain[nx][ny] == 0) continue;
						que_x.offer(nx); que_y.offer(ny);
						isvisited[nx][ny] = true;
					}
				}
			}
		}
		if(cnt == 0) {
			bw.write("0"); bw.flush(); bw.close(); br.close(); return;
		}
		int time = 0;
		outer : while(true) {
			isvisited = new boolean[N][M];
			melt();
			time++;
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(mountain[i][j] == 0) continue;
					if(isvisited[i][j]) continue;
					cnt++;
					if(cnt > 1) {
						break outer;
					}
					que_x.offer(i); que_y.offer(j);
					isvisited[i][j] = true;
					while(!que_x.isEmpty()) {
						int cur_x = que_x.poll();
						int cur_y = que_y.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur_x + dx[d];
							int ny = cur_y + dy[d];
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
							if(isvisited[nx][ny]) continue;
							if(mountain[nx][ny] == 0) continue;
							que_x.offer(nx); que_y.offer(ny);
							isvisited[nx][ny] = true;
						}
					}
				}
			}
			if(cnt == 0) {
				bw.write("0"); bw.flush(); bw.close(); br.close(); return;
			}
		}
		sb.append(time);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
