import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case= 1; test_case < T+1; test_case++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int field[][] = new int[N][M];
			for (int i = 0; i < K; i++) {
				s = br.readLine();
				st = new StringTokenizer(s, " ");
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				field[n][m] = 1;
			}
			if (K == 1) {
				bw.write("1\n");
				continue;
			}
			// input end //
			int cnt = 0;
			int dx[] = {-1, 1, 0, 0};
			int dy[] = {0, 0, -1, 1};
			Queue<Integer> que_x = new LinkedList<>();
			Queue<Integer> que_y = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] || field[i][j] == 0) continue;
					que_x.add(i); que_y.add(j);
					visited[i][j] = true;
					while (!que_x.isEmpty()) {
						int cur_x = que_x.poll();
						int cur_y = que_y.poll();
						for (int k= 0; k < 4; k++) {
							int nx = cur_x + dx[k];
							int ny = cur_y + dy[k];
							if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
							if (field[nx][ny] == 0) continue;
							if (visited[nx][ny]) continue;
							que_x.add(nx); que_y.add(ny);
							visited[nx][ny] = true;
						}
					}
					cnt++;
				}
			}
			bw.write(cnt + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}