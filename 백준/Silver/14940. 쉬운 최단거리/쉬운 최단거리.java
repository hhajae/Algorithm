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
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int start_x = 0, start_y = 0;
	    int[][] map = new int[n][m];
	    for (int i = 0; i < n; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start_x = i; start_y = j;
				}
			}
		}
	    /// input end ///
	    Queue<Integer> que_x = new ArrayDeque<>();
	    Queue<Integer> que_y = new ArrayDeque<>();
	    int[][] dist = new int[n][m];
	    que_x.offer(start_x); que_y.offer(start_y);
	    dist[start_x][start_y] = 1;
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    while(!que_x.isEmpty()) {
	    	int cur_x = que_x.poll();
	    	int cur_y = que_y.poll();
	    	for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(map[nx][ny] == 0) continue;
				if(dist[nx][ny] > 0) continue;
				dist[nx][ny] = dist[cur_x][cur_y] + 1;
				que_x.offer(nx); que_y.offer(ny);
			}
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(dist[i][j] == 0) {
					if(map[i][j] == 0)
						sb.append(dist[i][j]).append(" ");
					else
						sb.append(dist[i][j]-1).append(" ");
				}
				else sb.append(dist[i][j]-1).append(" ");
			}
			sb.append("\n");
		}
	    bw.write(sb.toString());
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}