import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
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

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			Node[] cycle = new Node[N+1];
			for (int i = 1; i < N+1; i++) {
				int to = Integer.parseInt(st.nextToken());
				cycle[i] = new Node(to, cycle[i]);
			}
			/// input end ///
			int cycleNum = 0;
			Queue<Integer> que = new ArrayDeque<>();
			boolean[] isvisited = new boolean[N+1];
			for (int i = 1; i < N+1; i++) {
				if(isvisited[i]) continue;
				que.offer(i);
				isvisited[i] = true;
				cycleNum++;
				while(!que.isEmpty()) {
					int cur = que.poll();
					for (Node tmp = cycle[cur]; tmp != null; tmp = tmp.next) {
						if(isvisited[tmp.to]) continue;
						que.offer(tmp.to);
						isvisited[tmp.to] = true;
					}
				}
			}
			sb.append(cycleNum).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}
}