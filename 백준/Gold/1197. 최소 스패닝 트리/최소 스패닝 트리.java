import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
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
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int V = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    parents = new int[V+1];
	    /// make-set ///
	    for (int i = 1; i < V+1; i++) {
			parents[i] = i;
		}
	    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
	    for (int i = 0; i < E; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int weight = Integer.parseInt(st.nextToken());
	    	if(from <= to) pq.offer(new Edge(from, to, weight));
	    	else pq.offer(new Edge(to, from, weight));
	    }
	    long mstWeight = 0;
	    int v = 0;
	    while(!pq.isEmpty()) {
 	    	Edge ege = pq.poll();
 	    	if(find(ege.from) == find(ege.to)) continue;
 	    	union(ege.from, ege.to);
 	    	mstWeight += ege.weight;
 	    	v++;
 	    	if(v == V-1) break;
	    }
	    sb.append(mstWeight);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
