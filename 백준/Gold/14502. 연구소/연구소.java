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
	private static boolean np(int[] p) {
		int N = p.length;
		
		int x = N-1;
		while(x > 0 && p[x-1] >= p[x]) x--;
		if(x == 0) return false;
		
		int y = N-1;
		while(p[x-1] >= p[y]) y--;
		
		int tmp = p[x-1];
		p[x-1] = p[y];
		p[y] = tmp;
		
		int z = N-1;
		while(x < z) {
			tmp = p[x];
			p[x++] = p[z];
			p[z--] = tmp;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		Queue<Integer> virusQue_x = new ArrayDeque<>();
		Queue<Integer> virusQue_y = new ArrayDeque<>();
		boolean[][] isvisitedMain = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virusQue_x.offer(i); virusQue_y.offer(j);
					isvisitedMain[i][j] = true;
				}
			}
		}
		/// input end ///
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[] npArr = new int[N*M];
		npArr[N*M-1] = npArr[N*M-2] = npArr[N*M-3] = 1;
		int maxSize = 0;
		outer : do {
			int[][] tmpMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tmpMap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < N*M; i++) {
				if(npArr[i] == 0) continue;
				int pos_x = i / M;
				int pos_y = i % M;
				if(map[pos_x][pos_y] == 2 || map[pos_x][pos_y] == 1) continue outer;
				tmpMap[pos_x][pos_y] = 1;
			}
			Queue<Integer> virus_x = new ArrayDeque<>();
			Queue<Integer> virus_y = new ArrayDeque<>();
			int queSize = virusQue_x.size();
			boolean[][] isvisited = new boolean[N][M];
			while(queSize-- > 0) {
				int tmp_x = virusQue_x.poll();
				int tmp_y = virusQue_y.poll();
				virus_x.offer(tmp_x);
				virus_y.offer(tmp_y);
				virusQue_x.offer(tmp_x);
				virusQue_y.offer(tmp_y);
				isvisited[tmp_x][tmp_y] = true;
			}

			while(!virus_x.isEmpty()) {
				int cur_x = virus_x.poll();
				int cur_y = virus_y.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(isvisited[nx][ny]) continue;
					if(tmpMap[nx][ny] == 1 || tmpMap[nx][ny] == 2) continue;
					isvisited[nx][ny] = true;
					virus_x.offer(nx); virus_y.offer(ny);
					tmpMap[nx][ny] = 2;
				}
			}
			int safetySpaceSize = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tmpMap[i][j] == 0) safetySpaceSize++;
				}
			}
			maxSize = Math.max(maxSize, safetySpaceSize);
		} while(np(npArr));
		bw.write(maxSize + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}