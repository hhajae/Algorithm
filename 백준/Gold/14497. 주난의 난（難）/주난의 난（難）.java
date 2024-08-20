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
	    s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int startX = Integer.parseInt(st.nextToken()) - 1;
	    int startY = Integer.parseInt(st.nextToken()) - 1;
	    int endX = Integer.parseInt(st.nextToken()) - 1;
	    int endY = Integer.parseInt(st.nextToken()) - 1;
	    int[][] board = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
			for (int j = 0; j < M; j++) {
				if(s.charAt(j) == '#' || s.charAt(j) == '*') continue;
				board[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};

	    int cnt = 0;
	    outer: while(true) {
	    	cnt++;
	    	Queue<Integer> que_x = new ArrayDeque<>();
	    	Queue<Integer> que_y = new ArrayDeque<>();
	    	Queue<Integer> del_x = new ArrayDeque<>();
	    	Queue<Integer> del_y = new ArrayDeque<>();
	    	boolean[][] isvisited = new boolean[N][M];
	    	que_x.offer(startX); que_y.offer(startY);
	    	isvisited[startX][startY] = true;
	    	while(!que_x.isEmpty()) {
	    		int cur_x = que_x.poll();
	    		int cur_y = que_y.poll();
	    		for (int i = 0; i < 4; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(isvisited[nx][ny]) continue;
					isvisited[nx][ny] = true;
					if(board[nx][ny] == 1) {
						del_x.offer(nx); del_y.offer(ny);
						continue;
					}
					if(nx == endX && ny == endY) {
						break outer;
					}
					que_x.offer(nx); que_y.offer(ny);
				}
	    	}
	    	while(!del_x.isEmpty()) {
	    		int nx = del_x.poll();
	    		int ny = del_y.poll();
	    		board[nx][ny] = 0;
	    	}
	    	
	    }
	    sb.append(cnt);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
