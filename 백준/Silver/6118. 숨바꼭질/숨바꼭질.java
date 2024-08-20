import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int to;
	Node next;
	public Node(int to, Node next) {
		super();
		this.to = to;
		this.next = next;
	}
	public Node(int to) {
		super();
		this.to = to;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    Node[] farm = new Node[N+1];
	    for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			farm[from] = new Node(to, farm[from]);
			farm[to] = new Node(from, farm[to]);
		}
	    /// input end ///
	    boolean[] isvisited = new boolean[N+1];
	    Queue<Integer> que = new ArrayDeque<>();
	    que.offer(1);
	    isvisited[1] = true;
	    int time = 0;
	    Queue<int[]> leafQue = new ArrayDeque<>();
	    int Mtime = 0;
	    while(!que.isEmpty()) {
	    	int queSize = que.size();
	    	time++;
	    	while(queSize-- > 0) {
	    		int cur = que.poll();
	    		int cnt = 0;
	    		for (Node tmp = farm[cur]; tmp != null; tmp = tmp.next) {
					if(isvisited[tmp.to]) continue;
					cnt++;
					que.offer(tmp.to);
					isvisited[tmp.to] = true;
				}
	    		if(cnt == 0) {
	    			Mtime = Math.max(Mtime, time);
	    			if (time == Mtime) {
	    				leafQue.offer(new int[] {time, cur});
	    			}
	    		}
	    	}
	    }
	    int minFarm = Integer.MAX_VALUE;
	    int sameCnt = 0;
	    while(!leafQue.isEmpty()) {
	    	int[] tmp = leafQue.poll();
	    	int t = tmp[0];
	    	if(t != Mtime) continue;
	    	int cur = tmp[1];
	    	sameCnt++;
	    	minFarm = Math.min(minFarm, cur);
	    }
	    bw.write(minFarm + " " + (Mtime - 1) + " " + sameCnt);
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}
