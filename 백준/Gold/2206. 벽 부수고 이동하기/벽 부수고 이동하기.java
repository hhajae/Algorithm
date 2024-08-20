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
	    StringBuilder sb = new StringBuilder();
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int[][] board = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
	    Queue<int[]> que = new ArrayDeque<>();
	    que.offer(new int[] {0,0,0});
	    int[][][] dist = new int[N][M][2];
	    for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j][0] = -1;
				dist[i][j][1] = -1;
			}
		}
	    dist[0][0][0] = 1; dist[0][0][1] = 1;
	    
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    while(!que.isEmpty()) {
	    	int[] cur = que.poll();
	    	int cur_x = cur[0];
	    	int cur_y = cur[1];
	    	int cur_w = cur[2];
	    	for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(board[nx][ny] == 1) {
					if(dist[nx][ny][1] > 0) continue;
					if(cur_w == 0) {
						dist[nx][ny][1] = dist[cur_x][cur_y][0] + 1;
						que.offer(new int[] {nx, ny, 1});
						continue;
					}
					continue;
				}
				if(cur_w == 0) {
					if(dist[nx][ny][0] > 0) continue;
					dist[nx][ny][0] = dist[cur_x][cur_y][0] + 1;
					que.offer(new int[] {nx, ny, 0});
				} else if (cur_w == 1) {
					if(dist[nx][ny][1] > 0) continue;
					dist[nx][ny][1] = dist[cur_x][cur_y][1] + 1;
					que.offer(new int[] {nx, ny, 1});
				}
			}
	    } 
	    if(dist[N-1][M-1][0] == -1 && dist[N-1][M-1][1] == -1) {
	    	sb.append("-1");
	    } else if (dist[N-1][M-1][0] == -1) {
	    	sb.append(dist[N-1][M-1][1]);
	    } else if (dist[N-1][M-1][1] == -1) {
	    	sb.append(dist[N-1][M-1][0]);
	    } else {
	    	sb.append(Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]));
	    }
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
