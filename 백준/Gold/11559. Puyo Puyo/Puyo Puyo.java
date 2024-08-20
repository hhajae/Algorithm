import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.annotation.Native;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] field;
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static void gravity() {
		for (int col = 0; col < M; col++) {
			Queue<Character> que = new ArrayDeque<>();
			for (int row = N-1; row >= 0; row--) {
				que.offer(field[row][col]);
				field[row][col] = '.';
			}
			int pushInd = N-1;
			while(!que.isEmpty()) {
				char c = que.poll();
				if(c == '.') continue;
				field[pushInd--][col] = c;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = 12; M = 6;
		field = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				field[i][j] = s.charAt(j);
			}
		}
		/// input end ///
		int nasties = 0;
		
		Queue<Integer> que_x;
		Queue<Integer> que_y;
		boolean[][] isvisited;
		outer: while(true) {
			boolean swc = false;
			nasties++;
			isvisited = new boolean[N][M];
			que_x = new ArrayDeque<>();
			que_y = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(field[i][j] == '.') continue;
					if(isvisited[i][j]) continue;
					int curColor = field[i][j];
					que_x.offer(i); que_y.offer(j);
					isvisited[i][j] = true;
					Queue<int[]> tmpBoomQue = new ArrayDeque<>();
					while(!que_x.isEmpty()) {
						int cur_x = que_x.poll();
						int cur_y = que_y.poll();
						tmpBoomQue.offer(new int[] {cur_x, cur_y});
						for (int k = 0; k < 4; k++) {
							int nx = cur_x + dx[k];
							int ny = cur_y + dy[k];
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
							if(isvisited[nx][ny]) continue;
							if(field[nx][ny] != curColor) continue;
							que_x.offer(nx); que_y.offer(ny);
							isvisited[nx][ny] = true;
						}
					}
					if(tmpBoomQue.size() >= 4) {
						swc = true;
						while(!tmpBoomQue.isEmpty()) {
							int[] boom = tmpBoomQue.poll();
							int boom_x = boom[0];
							int boom_y = boom[1];
							field[boom_x][boom_y] = '.';
						}
					}
				}
			}
			if(!swc) break outer;
			gravity();
		}
		
		sb.append(nasties - 1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
