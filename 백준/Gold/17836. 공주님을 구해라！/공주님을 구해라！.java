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
	    int T = Integer.parseInt(st.nextToken());
	    int[][] castle = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    /// input end ///
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    int minTime = Integer.MAX_VALUE;
	    int[][][] dist = new int[N][M][2];
	    dist[0][0][0] = 1;
 	    Queue<Integer> que_x = new ArrayDeque<>();
 	    Queue<Integer> que_y = new ArrayDeque<>();
 	    Queue<Integer> que_Gram = new ArrayDeque<>();
    	que_x.offer(0); que_y.offer(0); que_Gram.offer(0);
	    outer : while(!que_x.isEmpty()) {
	    	int cur_x = que_x.poll();
	    	int cur_y = que_y.poll();
	    	int curGram = que_Gram.poll();
	    	if(dist[cur_x][cur_y][0] > T || dist[cur_x][cur_y][1] > T) continue;
	    	for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(castle[nx][ny] == 1 && curGram == 0) continue;
				if(curGram == 0 && dist[nx][ny][0] > 0) continue;
				if(curGram == 1 && dist[nx][ny][1] > 0) continue; 
				if(nx == N-1 && ny == M-1) {
					if(dist[cur_x][cur_y][0] != 0 && dist[cur_x][cur_y][1] != 0) {
						minTime = Math.min(dist[cur_x][cur_y][0], dist[cur_x][cur_y][1]);
					}
					else if (dist[cur_x][cur_y][0] == 0) minTime = dist[cur_x][cur_y][1];
					else if (dist[cur_x][cur_y][1] == 0) minTime = dist[cur_x][cur_y][0];
					break outer;
				}
				if(castle[nx][ny] == 2) {
					dist[nx][ny][1] = dist[cur_x][cur_y][0] + 1;
					dist[nx][ny][0] = dist[cur_x][cur_y][0] + 1;
					que_x.offer(nx); que_y.offer(ny); que_Gram.offer(1);
					continue;
				}
				if(castle[nx][ny] == 1 && curGram == 1) {
					dist[nx][ny][1] = dist[cur_x][cur_y][1] + 1;
					que_x.offer(nx); que_y.offer(ny); que_Gram.offer(1);
					continue;
				}
				if(curGram == 1) {
					dist[nx][ny][1] = dist[cur_x][cur_y][1] + 1;
					que_x.offer(nx); que_y.offer(ny); que_Gram.offer(1);
					continue;
				}
				else {
					dist[nx][ny][0] = dist[cur_x][cur_y][0] + 1;
					que_x.offer(nx); que_y.offer(ny); que_Gram.offer(0);
					continue;
				}
			}
	    }
	    if(minTime == Integer.MAX_VALUE) bw.write("Fail");
	    else bw.write(minTime + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}
