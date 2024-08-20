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
		for (int test_case = 1; test_case < T+1; test_case++) {
			int L = Integer.parseInt(br.readLine());
			int cur_knight[] = new int[2];
			int nxt_knight[] = new int[2];
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			cur_knight[0] = Integer.parseInt(st.nextToken());
			cur_knight[1] = Integer.parseInt(st.nextToken());
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			nxt_knight[0] = Integer.parseInt(st.nextToken());
			nxt_knight[1] = Integer.parseInt(st.nextToken());
			// input end //
			
			int dx[] = {-2, -1, -2, -1, 2, 1, 2, 1};
			int dy[] = {-1, -2, 1, 2, -1, -2, 1, 2};
			Queue<Integer> que_x = new LinkedList<>();
			Queue<Integer> que_y = new LinkedList<>();
			que_x.add(cur_knight[0]); que_y.add(cur_knight[1]);
			int res_dist = 0;
			int[][]	dist = new int[L][L];
			while(!que_x.isEmpty()) {
				int cur_x = que_x.poll();
				int cur_y = que_y.poll();
				if (cur_x == nxt_knight[0] && cur_y == nxt_knight[1]) {
					res_dist = dist[cur_x][cur_y];
					break;
				}
				for (int i = 0; i < 8; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if (nx < 0 || nx >= L || ny < 0 || ny >= L) continue;
					if (dist[nx][ny] > 0) continue;
					dist[nx][ny] = dist[cur_x][cur_y] + 1;
					que_x.add(nx); que_y.add(ny);
				}
			}
			bw.write(res_dist + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}