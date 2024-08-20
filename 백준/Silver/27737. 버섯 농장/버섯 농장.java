import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
	    int K = Integer.parseInt(st.nextToken());
	    int[][] farm = new int[N][N];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    if(M == 0) {
	    	bw.write("IMPOSSIBLE"); bw.flush(); br.close(); bw.close(); return;
	    }
	    /// input end ///
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    Queue<Integer> que_x = new ArrayDeque<>();
	    Queue<Integer> que_y = new ArrayDeque<>();
	    boolean[][] isvisited = new boolean[N][N];
	    List<Integer> mushroom = new ArrayList<>();
	    for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(farm[i][j] == 1) continue;
				if(isvisited[i][j]) continue;
				int cnt = 0;
				que_x.offer(i); que_y.offer(j);
				isvisited[i][j] = true;
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					cnt++;
					for (int k = 0; k < 4; k++) {
						int nx = cur_x + dx[k];
						int ny = cur_y + dy[k];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(isvisited[nx][ny]) continue;
						if(farm[nx][ny] == 1) continue;
						que_x.offer(nx); que_y.offer(ny);
						isvisited[nx][ny] = true;
					}
				}
				mushroom.add(cnt);
			}
		}
	    int lstSize = mushroom.size();
	    if(lstSize == 0 || lstSize > M) {
	    	bw.write("IMPOSSIBLE"); bw.flush(); br.close(); bw.close(); return;
	    }
	    for (int i = 0; i < lstSize; i++) {
	    	int need = mushroom.get(i);
	    	if(need % K == 0) {
	    		M -= need / K;
	    	}
	    	else {
	    		M -= need / K + 1;
	    	}
	    	if(M < 0) {
	    		bw.write("IMPOSSIBLE"); bw.flush(); br.close(); bw.close(); return;
	    	}
		}
    	if(M < 0) {
    		bw.write("IMPOSSIBLE"); bw.flush(); br.close(); bw.close(); return;
    	}
    	else {
    		sb.append("POSSIBLE\n").append(M);
    	}
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
