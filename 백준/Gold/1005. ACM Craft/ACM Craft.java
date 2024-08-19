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
	@Override
	public String toString() {
		return "Node [to=" + to + ", next=" + next + "]";
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] D = new int[N+1];
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int i = 1; i < N+1; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			Node[] nodes = new Node[N+1];
			for (int i = 0; i < K; i++) {
				s = br.readLine();
				st = new StringTokenizer(s, " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodes[from] = new Node(to, nodes[from]);
			}
			int W = Integer.parseInt(br.readLine());
			/// input end ///
			int[] inDegree = new int[N+1];
			// indegree 계산
			for (int i = 1; i < N+1; i++) {
				for (Node tmp = nodes[i]; tmp != null; tmp = tmp.next) {
					inDegree[tmp.to]++;
				}
			}
			// 건물짓는데 드는 비용 계산
			Queue<Integer> que = new ArrayDeque<>();
			int[] costs = new int[N+1];
			for (int i = 1; i < N+1; i++) {
				if(inDegree[i] == 0) {
					que.offer(i);
					costs[i] = D[i];
				}
			}
			while(!que.isEmpty()) {
				int cur = que.poll();
				for (Node tmp = nodes[cur]; tmp != null; tmp = tmp.next) {
					costs[tmp.to] = Math.max(costs[cur] + D[tmp.to], costs[tmp.to]);
					inDegree[tmp.to]--;
					if(inDegree[tmp.to] == 0) {
						que.offer(tmp.to);
					}
				}
			}
			sb.append(costs[W]).append("\n");
        }
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
