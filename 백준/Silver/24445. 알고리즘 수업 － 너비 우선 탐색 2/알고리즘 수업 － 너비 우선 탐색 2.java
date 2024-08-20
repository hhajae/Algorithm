import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node2 {
	int to;
	Node2 next;
	public Node2(int to, Node2 next) {
		super();
		this.to = to;
		this.next = next;
	}
	public Node2(int to) {
		super();
		this.to = to;
	}
	@Override
	public String toString() {
		return "Node2 [to=" + to + ", next=" + next + "]";
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
		int R = Integer.parseInt(st.nextToken());
		Node2[] graphs = new Node2[N+1];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graphs[from] = new Node2(to, graphs[from]);
			graphs[to] = new Node2(from, graphs[to]);
		}
		/// input end ///
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new ArrayDeque<>();
		boolean[] isvisited = new boolean[N+1];
		que.offer(R);
		isvisited[R] = true;
		int[] resSeq = new int[N+1];
		int seqCnt = 1;
		resSeq[R] = seqCnt;
		while(!que.isEmpty()) {
			int cur = que.poll();
			List<Integer> adj = new ArrayList<>();
			for (Node2 tmp = graphs[cur]; tmp != null; tmp = tmp.next) {
				if(isvisited[tmp.to]) continue;
				isvisited[tmp.to] = true;
				adj.add(tmp.to);
			}
			Collections.sort(adj);
			Collections.reverse(adj);
			for (int i = 0; i < adj.size(); i++) {
				que.offer(adj.get(i));
				resSeq[adj.get(i)] = ++seqCnt;
			}
		}
		for (int i = 1; i < N+1; i++) {
			sb.append(resSeq[i]).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}