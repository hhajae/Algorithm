import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int[][] board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		String s = br.readLine();
		st = new StringTokenizer(s);
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		/// input end ///

		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[]{startX, startY});
		int[][] dist = new int[5][5];
		for (int i = 0; i < 5; i++) {
			Arrays.fill(dist[i], -1);
		}
		dist[startX][startY] = 0;
		int res = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(board[cur[0]][cur[1]] == 1) {
				res = dist[cur[0]][cur[1]];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
				if(dist[nx][ny] != -1) continue;
				if(board[nx][ny] == -1) continue;
				dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
				que.add(new int[]{nx, ny});
			}
		}
		if(res == Integer.MAX_VALUE) {
			sb.append("-1");
		} else {
			sb.append(res);
		}

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
