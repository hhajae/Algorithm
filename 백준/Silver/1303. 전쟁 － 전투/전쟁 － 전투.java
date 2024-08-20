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
		int[][] board = new int[M][N];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				if(s.charAt(j) == 'B') board[i][j] = 1; // W == 0 B == 1
			}
		}
		/// input end ///
		// 흰 옷 //
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		boolean[][] isvisited = new boolean[M][N];
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		int Wpower = 0, Bpower = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(isvisited[i][j]) continue;
				int curTeam = board[i][j];
				que_x.offer(i); que_y.offer(j);
				int oneTeamCnt = 1;
				isvisited[i][j] = true;
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					for (int k = 0; k < 4; k++) {
						int nx = cur_x + dx[k];
						int ny = cur_y + dy[k];
						if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
						if(isvisited[nx][ny]) continue;
						if(board[nx][ny] != curTeam) continue;
						que_x.offer(nx); que_y.offer(ny);
						isvisited[nx][ny] = true;
						oneTeamCnt++;
					}
				}
				if(curTeam == 0) Wpower += oneTeamCnt * oneTeamCnt;
				else Bpower += oneTeamCnt * oneTeamCnt;
			}
		}
		bw.write(Wpower + " " + Bpower);
		
		bw.flush();
		bw.close();
		br.close();
	}
}