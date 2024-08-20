import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int to, weight;
	Node next;
	public Node(int to, int weight, Node next) {
		super();
		this.to = to;
		this.weight = weight;
		this.next = next;
	}
	public Node(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}
}
class Edge {
	int to, weight;

	public Edge(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}
	
}
public class Main {
	static final int INF = 1000 * 100000 + 5;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    int M = Integer.parseInt(br.readLine());
	    Node[] nodes = new Node[N+1];
	    for (int i = 0; i < M; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodes[from] = new Node(to, weight, nodes[from]);
		}
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int start = Integer.parseInt(st.nextToken());
	    int dest = Integer.parseInt(st.nextToken());
	    /// input end ///
	    
	    int[] dist = new int[N+1];
	    boolean[] isvisited = new boolean[N+1];
	    Arrays.fill(dist, INF);
	    dist[start] = 0;
	    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
	    int cnt = 0;
	    pq.offer(new Edge(start, 0));
	    while(!pq.isEmpty()) {
	    	Edge e = pq.poll();
	    	if(isvisited[e.to]) continue;
	    	isvisited[e.to] = true;
	    	if(++cnt == N) break;
	    	for(Node tmp = nodes[e.to]; tmp != null; tmp = tmp.next) {
	    		if(isvisited[tmp.to]) continue;
	    		if(dist[e.to] + tmp.weight < dist[tmp.to]) {
	    			pq.offer(new Edge(tmp.to, dist[e.to] + tmp.weight));
	    			dist[tmp.to] = dist[e.to] + tmp.weight;
	    		}
	    	} 
	    }
	    sb.append(dist[dest]);
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
