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
	    StringBuilder sb = new StringBuilder();
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int[][] farm = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    /// input end ///
	    int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
	    int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
	    Queue<Integer> que_x = new ArrayDeque<>();
	    Queue<Integer> que_y = new ArrayDeque<>();
	    boolean[][] isvisited = new boolean[N][M];
	    int resCnt = 0;
	    for (int i = 0; i < N; i++) {
			outer : for (int j = 0; j < M; j++) {
				if(farm[i][j] == 0) continue;
				if(isvisited[i][j]) continue;
				int curHeight = farm[i][j];
				Queue<int[]> checkQue = new ArrayDeque<>();
				checkQue.offer(new int[] {i, j});
				que_x.offer(i); que_y.offer(j);
				isvisited[i][j] = true;
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					for (int k = 0; k < 8; k++) {
						int nx = cur_x + dx[k];
						int ny = cur_y + dy[k];
						if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
						if(curHeight < farm[nx][ny]) {
							while(!checkQue.isEmpty()) {
								int[] tmp = checkQue.poll();
								isvisited[tmp[0]][tmp[1]] = false;
							}
							que_x.clear(); que_y.clear();
							continue outer;
						}
						if(curHeight != farm[nx][ny]) continue;
						if(isvisited[nx][ny]) continue;
						isvisited[nx][ny] = true;
						que_x.offer(nx); que_y.offer(ny);
						checkQue.offer(new int[] {nx, ny});
					}
				}
				resCnt++;
			}
		}
	    sb.append(resCnt);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
