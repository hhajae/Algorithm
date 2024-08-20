import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
class Edge implements Comparable<Edge>{
	int to;
	long weight;

	public Edge(int to, long weight) {
		super();
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Long.compare(this.weight, o.weight);
	}
}
public class Main {
	static final long INF = 100_000_00_000L + 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isPass = new boolean[N];
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 0; i < N; i++) {
			if(Integer.parseInt(st.nextToken()) == 1) isPass[i] = true;
		}
        isPass[N-1] = false;
        Node[] junctions = new Node[N];
        for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			junctions[from] = new Node(to, weight, junctions[from]);
			junctions[to] = new Node(from, weight, junctions[to]);
		}
        boolean[] isselected = new boolean[N];
        long[] distances = new long[N];
        Arrays.fill(distances, INF);
        distances[0] = 0;
        int cnt = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        while(!pq.isEmpty()) {
        	Edge edge = pq.poll();
        	if(isselected[edge.to]) continue;
        	isselected[edge.to] = true;
        	if(++cnt == N) break;
        	
        	for (Node tmp = junctions[edge.to]; tmp != null; tmp = tmp.next) {
				if(isselected[tmp.to]) continue;
				if(isPass[tmp.to]) continue;
				if(distances[edge.to] + tmp.weight < distances[tmp.to]) {
					pq.offer(new Edge(tmp.to, distances[edge.to] + tmp.weight));
					distances[tmp.to] = distances[edge.to] + tmp.weight;
				}
			}
        }
        if(distances[N-1] == INF) sb.append("-1");
        else sb.append(distances[N-1]);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
