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
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Node[] game = new Node[N];
		for (int i = 0; i < N; i++) {
			int to = Integer.parseInt(br.readLine());
			game[i] = new Node(to, game[i]);
		}
		boolean swc = false;
		int M = 1;
		int start = game[0].to;
		if (start == K) {
			bw.write(M + "\n");
			bw.flush();
			br.close();
			bw.close();
			return;
		}
		else {
			Queue<Integer> que = new ArrayDeque<>();
			boolean[] isvisited = new boolean[N];
			que.offer(start);
			isvisited[start] = true;
			while(!que.isEmpty()) {
				start = que.poll();
				for (Node tmp = game[start]; tmp != null; tmp = tmp.next) {
					if(isvisited[tmp.to]) break;
					isvisited[tmp.to] = true;
					M++;
					if(tmp.to == K) {
						bw.write(M + "\n");
						swc = true;
						break;
					}
					que.offer(tmp.to);
				}
			}
		}
		if(!swc) bw.write("-1");
		
		bw.flush();
		br.close();
		bw.close();
	}
}