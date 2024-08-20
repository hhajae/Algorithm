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
	    
	    int N = Integer.parseInt(br.readLine());
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int[] miro = new int[N];
	    for (int i = 0; i < N; i++) {
			miro[i] = Integer.parseInt(st.nextToken());
		}
	    if(N == 1) { bw.write("0"); bw.flush(); bw.close(); br.close(); return; }
	    if(miro[0] == 0) {
	    	bw.write("-1");	bw.flush(); bw.close();	br.close();	return;
	    }
	    Queue<Integer> que = new ArrayDeque<>();
	    que.offer(0);
	    int[] dist = new int[N];
	    dist[0] = 1;
	    dist[N-1] = Integer.MAX_VALUE;
	    outer: while(!que.isEmpty()) {
	    	int cur = que.poll();
	    	int power = miro[cur];
	    	if(power == 0) continue;
	    	for (int i = 1; i <= power; i++) {
				int target = cur + i;
				if(target == N-1) {
					dist[N-1] = Math.min(dist[N-1], dist[cur] + 1);
					break;
				}
				if(target >= N) break;
//				if(dist[target] > 0 && dist[target] < dist[cur] + 1) continue;
				if(dist[target] > 0) continue;
				dist[target] = dist[cur] + 1;
				que.offer(target);
			}
	    }
	    if(dist[N-1] == Integer.MAX_VALUE) sb.append("-1");
	    else sb.append(dist[N-1] - 1);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
