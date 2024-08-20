import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	     
	    // input //
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int m = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    int h = Integer.parseInt(st.nextToken());
	    
	    int[][][] board = new int[h][n][m];
	    int[][][] dist = new int[h][n][m];
	    int[] dx = {-1, 1, 0, 0, 0, 0};
	    int[] dy = {0, 0, -1, 1, 0, 0};
	    int[] dh = {0, 0, 0, 0, -1, 1};
	    
	    Queue<Integer> Q_x = new LinkedList<>();
	    Queue<Integer> Q_y = new LinkedList<>();
	    Queue<Integer> Q_h = new LinkedList<>();
	    
	    for (int i = 0; i < h; i++) {
	    	for (int j = 0; j < n; j++) {
	    		s = br.readLine();
		    	st = new StringTokenizer(s, " ");
				for (int k= 0; k < m; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == 0) dist[i][j][k] = -1;
					if (board[i][j][k] == 1) {
						Q_x.add(j); Q_y.add(k); Q_h.add(i);
					}
				}
			}
	    }
	    
	    while(!Q_x.isEmpty()) {
	    	int cur_x = Q_x.poll(); int cur_y = Q_y.poll(); int cur_h = Q_h.poll();
	    	for (int i = 0; i < 6; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				int nh = cur_h + dh[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || nh < 0 || nh >= h) continue;
				if (dist[nh][nx][ny] >= 0) continue;
				dist[nh][nx][ny] = dist[cur_h][cur_x][cur_y] + 1;
				Q_x.add(nx); Q_y.add(ny); Q_h.add(nh);
			}
	    }
	    int toma_max = 0;
	    boolean swc = false;
	    for (int i = 0; i < h; i++) {
	    	for (int j = 0; j < n; j++) {
	    		for (int k = 0; k < m; k++) {
					if (dist[i][j][k] == -1) swc = true;
					else {
						toma_max = Math.max(toma_max, dist[i][j][k]);
					}
				}
	    	}
	    }
	    
	    if(swc) bw.write((-1) + "\n");
	    else bw.write(toma_max + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}