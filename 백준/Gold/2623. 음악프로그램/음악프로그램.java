import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] singers = new Node[N+1];
		Node[] singers_in = new Node[N+1];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int n = Integer.parseInt(st.nextToken());
			int[] tmpArr = new int[n];
			for (int j = 0; j < n; j++) {
				tmpArr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 1; j < n; j++) {
				int from = tmpArr[j-1];
				int to = tmpArr[j];
				singers[from] = new Node(to, singers[from]);
				singers_in[to] = new Node(from, singers_in[to]);
			}
		}
		/// input end ///
//		bw.write("---진출---\n");
//		for (Node node : singers) bw.write(node + "\n");
//		bw.write("---진입---\n");
//		for (Node node : singers_in) bw.write(node + "\n");
//		bw.newLine();
		
		/// 진입차수 계산 ///
		int[] indegree = new int[N+1];
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i < N+1; i++) {
			for (Node tmp = singers_in[i]; tmp != null; tmp = tmp.next) {
				indegree[i]++;
			}
			if(indegree[i] == 0) que.add(i);
		}
//		bw.write("indegree = " + Arrays.toString(indegree));
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(!que.isEmpty()) {
			int cur = que.poll();
			sb.append(cur).append("\n");
			cnt++;
			if(cnt == N) break;
			for (Node tmp = singers[cur]; tmp != null; tmp = tmp.next) {
				if(indegree[tmp.to] == 0) continue;
				indegree[tmp.to]--;
				if(indegree[tmp.to] == 0) que.add(tmp.to);
			}
			singers[cur] = null;
		}
		if(cnt == N) bw.write(sb.toString());
		else bw.write("0\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}