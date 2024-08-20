import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'X') {
					que_x.offer(i); que_y.offer(j);
				}
			}
		}
		char[][] afterMap = new char[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(afterMap[i], '.');
		}
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(!que_x.isEmpty()) {
			int cur_x = que_x.poll();
			int cur_y = que_y.poll();
			int cnt4 = 0;
			for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
					cnt4++;
					continue;
				}
				if(map[nx][ny] == '.') {
					cnt4++;
					continue;
				}
			}
			if(cnt4 < 3) afterMap[cur_x][cur_y] = 'X';
		}
		// 직사각형 만들기 시작
		HashSet<Integer> notUseRow = new HashSet<>();
		HashSet<Integer> notUseCol = new HashSet<>();
		/// row ///
		outer: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(afterMap[i][j] == 'X') break outer;
			}
			notUseRow.add(i);
		}
		outer: for (int i = R-1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if(afterMap[i][j] == 'X') break outer;
			}
			notUseRow.add(i);
		}
		/// col ///
		outer: for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if(afterMap[j][i] == 'X') break outer;
			}
			notUseCol.add(i);
		}
		outer: for (int i = C-1; i >= 0; i--) {
			for (int j = 0; j < R; j++) {
				if(afterMap[j][i] == 'X') break outer;
			}
			notUseCol.add(i);
		}
		// 직사각형 만들기 끝
		for (int i = 0; i < R; i++) {
			if(notUseRow.contains(i)) continue;
			for (int j = 0; j < C; j++) {
				if(notUseCol.contains(j)) continue;
				bw.write(afterMap[i][j] + "");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}