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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] tDup = new char[R][C];
		int start_x = 0, start_y = 0;
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				tDup[i][j] = s.charAt(j);
				if(tDup[i][j] == 'S') {
					start_x = i; start_y = j;
				}
				else if(tDup[i][j] == '*') {
					que_x.offer(i); que_y.offer(j);
				}
			}
 		}
		/// input end ///
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] water = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(water[i], -1);
		}
		int queSize = que_x.size();
		while(queSize-- > 0) {
			int water_x = que_x.poll();
			int water_y = que_y.poll();
			water[water_x][water_y] = 0;
			que_x.offer(water_x); que_y.offer(water_y);
		}
		while(!que_x.isEmpty()) {
			int cur_x = que_x.poll();
			int cur_y = que_y.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(tDup[nx][ny] == 'X' || tDup[nx][ny] == 'D') continue;
				if(water[nx][ny] >= 0) continue;
				water[nx][ny] = water[cur_x][cur_y] + 1;
				que_x.offer(nx); que_y.offer(ny);
			}
		}
		
		int[][] dist = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(dist[i], -1);
		}
		que_x.clear(); que_y.clear();
		que_x.offer(start_x); que_y.offer(start_y);
		dist[start_x][start_y] = 0;
		int minTime = Integer.MAX_VALUE;
		while(!que_x.isEmpty()) {
			int cur_x = que_x.poll();
			int cur_y = que_y.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(dist[nx][ny] >= 0) continue;
				if(tDup[nx][ny] == 'X') continue;
				if(tDup[nx][ny] == 'D') {
					que_x.clear();
					minTime = dist[cur_x][cur_y] + 1;
					break;
				}
				if(dist[cur_x][cur_y] + 1 >= water[nx][ny] && water[nx][ny] != -1) continue;
				dist[nx][ny] = dist[cur_x][cur_y] + 1;
				que_x.offer(nx); que_y.offer(ny);
			}
		}
		
		if(minTime == Integer.MAX_VALUE) bw.write("KAKTUS");
		else bw.write(minTime + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}