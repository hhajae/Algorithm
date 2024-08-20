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
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    int[] dist = new int[100005];
	    for (int i = 0; i < dist.length; i++) {
			dist[i] = -1;
		}
	    if (N == K) {
	    	bw.write("0\n");
	    	bw.flush();
	    	bw.close();
	    	br.close();
	    	return;
	    }
	    
	    int dx[] = {2, -1, 1};
	    Queue<Integer> que_x = new LinkedList<>();
	    que_x.add(N);
	    int fast_time = 0;
	    dist[N] = 0;
	    boolean visited[] = new boolean[100005];
	    while(!que_x.isEmpty()) {
	    	int cur_x = que_x.poll();
	    	for (int i = 0; i < 3; i++) {
				int nx = cur_x + dx[i];
				if (i == 0) nx = cur_x * 2;
				if (nx < 0 || nx >= 100005) continue;
				if (i == 0 && nx == K) {
					fast_time = dist[cur_x];
					que_x.clear();
					break;
				}
				else if (nx == K) {
					fast_time = dist[cur_x] + 1;
					que_x.clear();
					break;
				}
				
				if (dist[nx] >= 0 || visited[nx]) continue;
				
				que_x.add(nx);
				if (i == 0) {
					dist[nx] = dist[cur_x];
					visited[nx] = true;
				}
				else {
					dist[nx] = dist[cur_x] + 1;
					visited[nx] = true;
				}
			}
	    }
	    bw.write(fast_time + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}