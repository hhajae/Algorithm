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

		boolean swc = true;
		while(swc) {
			String s = br.readLine();
			if (s.equals("0 0")) break;
			st = new StringTokenizer(s, " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int[][] map = new int[h][w];
			boolean[][] isvisited = new boolean[h][w];
			Queue<Integer> que_x = new ArrayDeque<>();
			Queue<Integer> que_y = new ArrayDeque<>();
			for (int i = 0; i < h; i++) {
				s = br.readLine();
				st = new StringTokenizer(s, " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			/// input end ///
			int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
			int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
			int islandCnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 0) continue;
					if (isvisited[i][j]) continue;
					isvisited[i][j] = true;
					que_x.add(i); que_y.add(j);
					islandCnt++;
					while(!que_x.isEmpty()) {
						int cur_x = que_x.poll();
						int cur_y = que_y.poll();
						for (int k = 0; k < 8; k++) {
							int nx = cur_x + dx[k];
							int ny = cur_y + dy[k];
							if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
							if (isvisited[nx][ny]) continue;
							if (map[nx][ny] == 0) continue;
							isvisited[nx][ny] = true;
							que_x.add(nx); que_y.add(ny); 
						}
					}
				}
			}
			bw.write(islandCnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}