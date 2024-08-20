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
        
        int N = Integer.parseInt(br.readLine());
        Node[] tree = new Node[N+1];
        for (int i = 0; i < N-1; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from] = new Node(to, tree[from]);
			tree[to] = new Node(from, tree[to]);
		}
        int[] parents = new int[N+1];

        boolean[] isvisited = new boolean[N+1];
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);
        isvisited[1] = true;
        
        while(!que.isEmpty()) {
        	int cur = que.poll();
        	for (Node tmp = tree[cur]; tmp != null; tmp = tmp.next) {
				if(isvisited[tmp.to]) continue;
				isvisited[tmp.to] = true;
				que.offer(tmp.to);
				parents[tmp.to] = cur;
			}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
			sb.append(parents[i]).append("\n");
		}
        bw.write(sb.toString());
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}