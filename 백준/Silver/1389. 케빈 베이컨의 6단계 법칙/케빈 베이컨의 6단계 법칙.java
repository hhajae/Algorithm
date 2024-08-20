import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
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
        HashSet<String> relations = new HashSet<>(); 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
			s = br.readLine();
			relations.add(s);
		}
        Node[] users = new Node[N+1];
        for (String string : relations) {
			st = new StringTokenizer(string, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			users[from] = new Node(to, users[from]);
			users[to] = new Node(from, users[to]);
		}
        /// input end ///
        int minKevin = Integer.MAX_VALUE;
        int minKevinInd = -1;
        for (int i = 1; i < N+1; i++) {
			int[] isvisited = new int[N+1];
			int Kevin = 0;
			Queue<Integer> que = new ArrayDeque<>();
			que.add(i);
			isvisited[i] = 1;
			while(!que.isEmpty()) {
				int cur = que.poll();
				for (Node tmp = users[cur]; tmp != null; tmp = tmp.next) {
					if(isvisited[tmp.to] > 0) continue;
					isvisited[tmp.to] = isvisited[cur] + 1;
					que.add(tmp.to);
				}
			}
			for (int j = 1; j < N+1; j++) {
				Kevin += isvisited[j] - 1;
			}
			if(Kevin < minKevin) {
				minKevin = Kevin;
				minKevinInd = i;
			}
		}
        bw.write(minKevinInd + "\n");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}