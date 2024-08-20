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
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int[][] board = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    /// input end ///
	    boolean[][] isvisited = new boolean[N][M];
	    Queue<Integer> que_x = new ArrayDeque<>();
	    Queue<Integer> que_y = new ArrayDeque<>();
	    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	    int cnt = 0;
	    for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 0) continue;
				if(isvisited[i][j]) continue;
				isvisited[i][j] = true;
				cnt++;
				que_x.offer(i); que_y.offer(j);
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					for (int k = 0; k < 8; k++) {
						int nx = cur_x + dx[k];
						int ny = cur_y + dy[k];
						if(nx < 0 || nx >= N || ny < 0 | ny >= M) continue;
						if(isvisited[nx][ny]) continue;
						if(board[nx][ny] == 0) continue;
						isvisited[nx][ny] = true;
						que_x.offer(nx); que_y.offer(ny);
					}
				}
			}
		}
	    bw.write(cnt + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}
