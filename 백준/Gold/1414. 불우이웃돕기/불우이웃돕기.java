import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int from, to, weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
}
public class Main {
	static int[] parents;
	private static void union(int a, int b) {
		if(find(a) == find(b)) return;
		parents[find(a)] = find(b);
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	private static int getLanLen(char c) {
		if(c >= 'a' && c <= 'z') {
			return c - 'a' + 1;
		}
		return c - 'A' + 27;
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    int total = 0;
	    parents = new int[N];
	    /// make-set ///
	    for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
	    	
		});
 	    for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if(s.charAt(j) == '0') continue;
				int lanLen = getLanLen(s.charAt(j));
				total += lanLen;
				if(i <= j) pq.offer(new Edge(i, j, lanLen));
				else pq.offer(new Edge(j, i, lanLen));
			}
		}
 	    int mstWeight = 0;
 	    int V = 0;
 	    while(!pq.isEmpty()) {
 	    	Edge ege = pq.poll();
 	    	if(find(ege.from) == find(ege.to)) continue;
 	    	union(ege.from, ege.to);
 	    	mstWeight += ege.weight;
 	    	V++;
 	    	if(V == N-1) break;
 	    }
 	    if(V != N-1) sb.append("-1");
 	    else {
 	    	sb.append(total - mstWeight);
 	    }
 	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
