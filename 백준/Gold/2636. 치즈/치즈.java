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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] cheese = new int[N][M];
		int cheeseCnt = 0;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j] == 1) cheeseCnt++;
			}
		}
		/// input end ///
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		int timeCnt = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		boolean swc = true;
		while(swc) {
			Queue<Integer> cheesePosX = new ArrayDeque<>();
			Queue<Integer> cheesePosY = new ArrayDeque<>();
			que_x.add(0); que_y.add(0);
			boolean[][] isvisited = new boolean[N][M];
			isvisited[0][0] = true;
			while(!que_x.isEmpty()) {
				int cur_x = que_x.poll();
				int cur_y = que_y.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(isvisited[nx][ny]) continue;
					if (cheese[nx][ny] == 1) {
						cheesePosX.add(nx); cheesePosY.add(ny);
						isvisited[nx][ny] = true;
						continue;
					}
					isvisited[nx][ny] = true;
					que_x.add(nx); que_y.add(ny);
				}
			}
			timeCnt++;
			if (cheeseCnt <= cheesePosX.size()) {
				swc = false;
				break;
			}
			while(!cheesePosX.isEmpty()) {
				int cur_x = cheesePosX.poll();
				int cur_y = cheesePosY.poll();
				cheese[cur_x][cur_y] = 0;
				cheeseCnt--;
			}
		}
		bw.write(timeCnt + "\n" + cheeseCnt);
		
		bw.flush();
		bw.close();
		br.close();
	}
}