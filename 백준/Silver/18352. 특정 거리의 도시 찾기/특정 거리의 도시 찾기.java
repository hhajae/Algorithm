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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		Node[] graph = new Node[N+1];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from] = new Node(to, graph[from]);
		}
		Queue<Integer> que = new ArrayDeque<>();
		boolean[] isvisited = new boolean[N+1];
		que.offer(X);
		isvisited[X] = true;
 		int distCnt = 0;
 		List<Integer> lst = new ArrayList<>();
 		while(!que.isEmpty()) {
 			distCnt++;
 			int queSize = que.size();
 			while(queSize-- > 0) {
 				int cur = que.poll();
 				for (Node tmp = graph[cur]; tmp != null; tmp = tmp.next) {
					if(isvisited[tmp.to]) continue;
					if(distCnt == K) lst.add(tmp.to);
					que.offer(tmp.to);
					isvisited[tmp.to] = true;
				}
 			}
 		}
 		if(lst.size() == 0) bw.write("-1");
 		else {
 			StringBuilder sb = new StringBuilder();
 			Collections.sort(lst);
 			for (int i = 0; i < lst.size(); i++) {
				sb.append(lst.get(i)).append("\n");
			}
 			bw.write(sb.toString());
 		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}