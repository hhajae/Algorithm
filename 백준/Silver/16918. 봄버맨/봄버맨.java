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
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		char[][] board = new char[R][C];
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j] == 'O') {
					que_x.offer(i); que_y.offer(j);
				}
			}
		}
		/// input end ///
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int time = 1;
		while(time++ < N) {
			if(time % 2 == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						board[i][j] = 'O';
					}
				}
			}
			else if(time % 2 == 1) {
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					board[cur_x][cur_y] = '.';
					for (int i = 0; i < 4; i++) {
						int nx = cur_x + dx[i];
						int ny = cur_y + dy[i];
						if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
						board[nx][ny] = '.';
					}
				}
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(board[i][j] == 'O') {
							que_x.offer(i); que_y.offer(j);
						}
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
