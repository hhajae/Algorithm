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
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    Node[] subjects = new Node[N+1];
	    Node[] subjects_in = new Node[N+1];
	    for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			subjects[from] = new Node(to, subjects[from]);
			subjects_in[to] = new Node(from, subjects_in[to]);
		}
	    /// input end ///
	    Queue<Integer> que = new ArrayDeque<>();
	    int[] indegree = new int[N+1];
	    int[] minGrade = new int[N+1];
	    
	    /// 진입차수 계산 ///
	    for (int i = 1; i < N+1; i++) {
			for (Node tmp = subjects_in[i]; tmp != null; tmp = tmp.next) {
				indegree[i]++;
			}
			if(indegree[i] == 0) que.offer(i);
		}
	    int cnt = 0;
	    while(!que.isEmpty()) {
	    	int queSize = que.size();
	    	cnt++;
	    	while(queSize-- > 0) {
	    		int cur = que.poll();
	    		minGrade[cur] = cnt;
	    		for (Node tmp = subjects[cur]; tmp != null; tmp = tmp.next) {
	    			if(indegree[tmp.to] == 0) continue;
					indegree[tmp.to]--;
					if(indegree[tmp.to] == 0) que.offer(tmp.to);
				}
	    		subjects[cur] = null;
	    	}
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 1; i < N+1; i++) {
			sb.append(minGrade[i]).append(" ");
		}
	    bw.write(sb.toString());
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}