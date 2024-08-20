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
	static final int WHITE = 1;
	static final int BLACK = 0;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    int[][] miro = new int[n][n];
	    for (int i = 0; i < n; i++) {
	    	String s = br.readLine();
			for (int j = 0; j < n; j++) {
				miro[i][j] = s.charAt(j) - '0';
			}
		}
	    /// input end ///
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    Queue<int[]> que = new ArrayDeque<>();
	    int[][] dist = new int[n][n];
	    for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], -1);
		}
	    que.offer(new int[] {0, 0, 0});
	    dist[0][0] = 0;
	    int minRes = Integer.MAX_VALUE;
	    outer : while(!que.isEmpty()) {
	    	int[] cur = que.poll();
	    	int cur_x = cur[0], cur_y = cur[1];
	    	int curChangeNum = cur[2];
	    	if(curChangeNum < dist[cur_x][cur_y]) dist[cur_x][cur_y] = curChangeNum;
	    	for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(nx == n-1 && ny == n-1) {
					minRes = Math.min(curChangeNum, minRes);
					dist[nx][ny] = minRes;
					continue outer;
				}

				if(dist[nx][ny] >= 0) {
					if(miro[nx][ny] == BLACK) {
						if(curChangeNum + 1 < dist[nx][ny]) {
							dist[nx][ny] = curChangeNum + 1;
							que.offer(new int[] {nx, ny, curChangeNum + 1});
						}
					}
					else {
						if(curChangeNum < dist[nx][ny]) {
							dist[nx][ny] = curChangeNum;
							que.offer(new int[] {nx, ny, curChangeNum});
						}
					}
					continue;
				}
				if(miro[nx][ny] == BLACK) {
					dist[nx][ny] = curChangeNum + 1;
					que.offer(new int[] {nx, ny, curChangeNum + 1});
				}
				else {
					dist[nx][ny] = curChangeNum;
					que.offer(new int[] {nx, ny, curChangeNum});
				}
				
			}
	    }
	    sb.append(minRes);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
