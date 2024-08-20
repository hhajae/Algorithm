import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		int[][] lab = new int[N][N];
		List<int[]> possiblePos = new ArrayList<>();
		int zeroCnt = 0;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) {
					possiblePos.add(new int[] {i, j});
				}
				else if(lab[i][j] == 0) zeroCnt++;
			}
		}
		/// input end ///
		int possibleCnt = possiblePos.size();
		zeroCnt += (possibleCnt - M); 
		int[] npArr = new int[possibleCnt];
		for (int i = 0; i < M; i++) {
			npArr[possibleCnt-i-1] = 1;
		}
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int minTime = Integer.MAX_VALUE;
		do {
			Queue<Integer> que_x = new ArrayDeque<>();
			Queue<Integer> que_y = new ArrayDeque<>();
			boolean[][] isvisited = new boolean[N][N];
			for (int i = 0; i < possibleCnt; i++) {
				if(npArr[i] == 0) continue;
				int[] virus = possiblePos.get(i);
				que_x.offer(virus[0]); que_y.offer(virus[1]);
				isvisited[virus[0]][virus[1]] = true;
			}
			int time = 0;
			int spreadCnt = 0;
			while(!que_x.isEmpty()) {
				int queSize = que_x.size();
				time++;
				while(queSize-- > 0) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					for (int i = 0; i < 4; i++) {
						int nx = cur_x + dx[i];
						int ny = cur_y + dy[i];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(lab[nx][ny] == 1) continue;
						if(isvisited[nx][ny]) continue;
						que_x.offer(nx); que_y.offer(ny);
						isvisited[nx][ny] = true;
						spreadCnt++;
					}
				}
			}
			if(zeroCnt == spreadCnt) minTime = Math.min(time, minTime);
		} while (np(npArr));
		
		if(minTime == Integer.MAX_VALUE) bw.write("-1");
		else bw.write((minTime-1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
