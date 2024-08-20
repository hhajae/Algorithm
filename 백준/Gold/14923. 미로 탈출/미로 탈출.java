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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		int Hx = Integer.parseInt(st.nextToken()) - 1;
		int Hy = Integer.parseInt(st.nextToken()) - 1;
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		int Ex = Integer.parseInt(st.nextToken()) - 1;
		int Ey = Integer.parseInt(st.nextToken()) - 1;
		int[][] miro = new int[N][M];
		for (int i = 0; i < N; i++) {
			s  = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/// input end ///
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] dist = new int[N][M];
		int[][] dist_break = new int[N][M];
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {Hx, Hy, 1});
		dist[Hx][Hy] = 1;
		int minRes = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			int curMagic = cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(nx == Ex && ny == Ey) {
					int dst = dist[cur_x][cur_y];
					int dst_break = dist_break[cur_x][cur_y];
					if(dst != 0 && dst_break != 0) minRes = Math.min(dist[cur_x][cur_y], dist_break[cur_x][cur_y]);
					else if (dst == 0) minRes = dst_break;
					else if (dst_break == 0) minRes = dst;
					que.clear();
					break;
				}
				if(dist[nx][ny] > 0) continue;
				if(dist_break[nx][ny] > 0 && curMagic == 0) continue;
				if(miro[nx][ny] == 1) {
					if(curMagic == 0) continue;
					que.offer(new int[] {nx, ny, 0});
					dist[nx][ny] = dist[cur_x][cur_y] + 1;
					dist_break[nx][ny] = dist[cur_x][cur_y] + 1;
					continue;
				}
				if(curMagic == 0) {
					que.offer(new int[] {nx, ny, 0});
					dist_break[nx][ny] = dist_break[cur_x][cur_y] + 1;
				}
				else {
					que.offer(new int[] {nx, ny, 1});
					dist[nx][ny] = dist[cur_x][cur_y] + 1;
				} 
			}
		}
		if(minRes == Integer.MAX_VALUE) bw.write("-1");
		else bw.write(minRes + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}