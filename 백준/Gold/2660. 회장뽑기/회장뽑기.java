import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Node[] group = new Node[N+1];
		while(true) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(from == -1 && to == -1) break;
			group[from] = new Node(to, group[from]);
			group[to] = new Node(from, group[to]);
		}
		/// input end ///
		List<Integer> hubo = new ArrayList<>();
		int minFriends = Integer.MAX_VALUE;
		for (int i = 1; i < N+1; i++) {
			int maxDepth = 0;
			int depth = 0;
			Queue<Integer> que = new ArrayDeque<>();
			boolean[] isvisited = new boolean[N+1];
			que.offer(i);
			isvisited[i] = true;
			while(!que.isEmpty()) {
				int queSize = que.size();
				depth++;
				while(queSize-- > 0) {
					int cur = que.poll();
					int cnt = 0;
					for (Node tmp = group[cur]; tmp != null; tmp = tmp.next) {
						if(isvisited[tmp.to]) continue;
						cnt++;
						isvisited[tmp.to] = true;
						que.offer(tmp.to);
					}
					if(cnt == 0) {
						maxDepth = Math.max(maxDepth, depth);
					}
				}
			}
			if(maxDepth < minFriends) {
				hubo.clear();
				minFriends = maxDepth;
				hubo.add(i);
			}
			else if(maxDepth == minFriends) {
				hubo.add(i);
			}
		}
		sb.append(minFriends-1).append(" ").append(hubo.size()).append("\n");
		for (int i = 0; i < hubo.size(); i++) {
			sb.append(hubo.get(i)).append(" ");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}