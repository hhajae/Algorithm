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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] alphas = new Node[N+1];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			alphas[from] = new Node(to, alphas[from]);
			alphas[to] = new Node(from, alphas[to]);
		}
		Queue<Integer> que = new ArrayDeque<>();
		int minRes = Integer.MAX_VALUE;
		boolean[] isvisited = new boolean[N+1];
		que.offer(a);
		isvisited[a] = true;
		int dist = 0;
		outer: while(!que.isEmpty()) {
			int queSize = que.size();
			dist++;
			while(queSize-- > 0) {
				int cur = que.poll();
				if(cur == b) {
					minRes = Math.min(dist, minRes);
					break outer;
				}
				for (Node tmp = alphas[cur]; tmp != null; tmp = tmp.next) {
					if(isvisited[tmp.to]) continue;
					isvisited[tmp.to] = true;
					que.offer(tmp.to);
				}
			}
		}
		if(minRes == Integer.MAX_VALUE) bw.write("-1");
		else bw.write((minRes-1) + "\n");
 		
		bw.flush();
		bw.close();
		br.close();
	}
}