import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class friend {
	int num, cost;

	public friend(int num, int cost) {
		super();
		this.num = num;
		this.cost = cost;
	}
}
public class Main {
	static int[] parents;
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		parents[b] = a;
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
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
	    int[] cost = new int[N+1];
	    s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    for (int i = 1; i < N+1; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
	    parents = new int[N+1];
	    for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
	    for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v, w);
		}
	    for (int i = 1; i < N+1; i++) {
			find(i);
		}
	    int friendsCost = 0;
	    boolean[] isvisited = new boolean[N+1];
		PriorityQueue<friend> pq = new PriorityQueue<>(new Comparator<friend>() {
			@Override
			public int compare(friend o1, friend o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		for (int i = 1; i < N+1; i++) {
			pq.offer(new friend(parents[i], cost[i]));
		}
		while(!pq.isEmpty()) {
			friend tmpF = pq.poll();
			if(isvisited[tmpF.num]) continue;
			isvisited[tmpF.num] = true;
			friendsCost += tmpF.cost;
		}
		if(friendsCost > K) sb.append("Oh no");
		else sb.append(friendsCost);
		
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
