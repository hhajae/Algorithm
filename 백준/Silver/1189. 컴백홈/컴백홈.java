import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int R, C, K;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int resCnt = 0;
	private static void dfs(int x, int y, int k, boolean[][] isvisited) {
		if(x == 0 && y == C-1 && k == K) {
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					if(isvisited[i][j]) System.out.print("1 ");
//					else System.out.print("0 ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			resCnt++;
			return;
		}
		if(x == 0 && y == C-1 && k != K) return;
		if(isvisited[x][y]) return;
		isvisited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if(map[nx][ny] == 'T') continue;
			dfs(nx, ny, k+1, isvisited);
		}
		isvisited[x][y] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		/// input end ///
		dfs(R-1, 0, 1, new boolean[R][C]);
		sb.append(resCnt);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
