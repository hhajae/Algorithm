import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int N = Integer.parseInt(br.readLine());
	    int[][] space = new int[N][N];
	    int min_h = 101;
	    int max_h = -1;
	    for (int i = 0; i < N; i++) {
	    	String s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] < min_h) min_h = space[i][j];
				if (space[i][j] > max_h) max_h = space[i][j];
			}
		}
	    
	    int dx[] = {-1, 1, 0, 0};
	    int dy[] = {0, 0, -1, 1};
	    Queue<Integer> que_x = new LinkedList<>();
	    Queue<Integer> que_y = new LinkedList<>();
	    int max_safety = 1;
	    for (int i = min_h; i < max_h; i++) {
		    int safety = 0;
		    boolean[][] visited = new boolean[N][N];
		    for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(space[j][k] <= i || visited[j][k]) continue;
					que_x.add(j); que_y.add(k);
					visited[j][k] = true;
					while(!que_x.isEmpty()) {
						int cur_x = que_x.poll();
						int cur_y = que_y.poll();
						for (int m = 0; m < 4; m++) {
							int nx = cur_x + dx[m];
							int ny = cur_y + dy[m];
							if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							if (visited[nx][ny] || space[nx][ny] <= i) continue;
							visited[nx][ny] = true;
							que_x.add(nx); que_y.add(ny);
						}
					}
					safety++;
				}
			}
		    if (safety > max_safety) max_safety = safety;
		}
	    bw.write(max_safety + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}