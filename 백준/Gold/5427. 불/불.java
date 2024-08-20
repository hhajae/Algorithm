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
	    
	    int T = Integer.parseInt(br.readLine());
	    outer : for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			char[][] board = new char[h][w];
			int[][] fireDist = new int[h][w];
			for (int i = 0; i < h; i++) {
				Arrays.fill(fireDist[i], -1);
			}
			int start_x = 0, start_y = 0;
			int[][] dist = new int[h][w];
			for (int i = 0; i < h; i++) {
				Arrays.fill(dist[i], -1);
			}

			Queue<Integer> fireQue_x = new ArrayDeque<>();
			Queue<Integer> fireQue_y = new ArrayDeque<>();
			for (int i = 0; i < h; i++) {
				s = br.readLine();
				for (int j = 0; j < w; j++) {
					board[i][j] = s.charAt(j);
					if(board[i][j] == '@') {
						start_x = i; start_y = j;
						board[i][j] = '.';
						dist[i][j] = 0;
					}
					if(board[i][j] == '*') {
						fireQue_x.offer(i); fireQue_y.offer(j);
						fireDist[i][j] = 0;
					}
				}
			}
			/// input end ///
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};

			while(!fireQue_x.isEmpty()) {
				int cur_x = fireQue_x.poll();
				int cur_y = fireQue_y.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					if(board[nx][ny] == '#') continue;
					if(fireDist[nx][ny] >= 0) continue;
					fireQue_x.offer(nx); fireQue_y.offer(ny);
					fireDist[nx][ny] = fireDist[cur_x][cur_y] + 1;
				}
			}
			Queue<Integer> que_x = new ArrayDeque<>();
			Queue<Integer> que_y = new ArrayDeque<>();
			que_x.offer(start_x); que_y.offer(start_y);
			
			while(!que_x.isEmpty()) {
				int cur_x = que_x.poll();
				int cur_y = que_y.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
						sb.append(dist[cur_x][cur_y] + 1).append("\n");
						continue outer;
					}
					if(board[nx][ny] == '#') continue;
					if(dist[nx][ny] >= 0) continue;
					if(fireDist[nx][ny] >= 0 && dist[cur_x][cur_y] + 1 >= fireDist[nx][ny]) continue;
					que_x.offer(nx); que_y.offer(ny);
					dist[nx][ny] = dist[cur_x][cur_y] + 1;
				}
			}
			
			sb.append("IMPOSSIBLE\n");
	    }
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
