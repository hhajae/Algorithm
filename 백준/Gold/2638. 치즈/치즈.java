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
	    int[][] board = new int[N][M];
	    int cheezeCnt = 0;
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) cheezeCnt++;
			}
		}
	    /// input end ///
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    int time = 0;
	    while(cheezeCnt > 0) {
	    	Queue<Integer> que_x = new ArrayDeque<>();
	    	Queue<Integer> que_y = new ArrayDeque<>();
	    	boolean[][] isvisited = new boolean[N][M];
	    	que_x.offer(0); que_y.offer(0);
	    	isvisited[0][0] = true;
	    	Queue<Integer> cque_x = new ArrayDeque<>();
	    	Queue<Integer> cque_y = new ArrayDeque<>();
	    	while(!que_x.isEmpty()) {
	    		int cur_x = que_x.poll();
	    		int cur_y = que_y.poll();
	    		for (int i = 0; i < 4; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(board[nx][ny] == 1) {
						if(isvisited[nx][ny]) {
							cque_x.offer(nx);
							cque_y.offer(ny);
						} else {
							isvisited[nx][ny] = true;
						}
						continue;
					}
					if(isvisited[nx][ny]) continue;
					isvisited[nx][ny] = true;
					que_x.offer(nx); que_y.offer(ny);
				}
	    	}
	    	if(!cque_x.isEmpty()) {
	    		time++;
	    	}
	    	while(!cque_x.isEmpty()) {
	    		int cur_x = cque_x.poll();
	    		int cur_y = cque_y.poll();
	    		if(board[cur_x][cur_y] == 0) continue;
	    		board[cur_x][cur_y] = 0;
	    		cheezeCnt--;
	    	}
	    }
	    sb.append(time);
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
