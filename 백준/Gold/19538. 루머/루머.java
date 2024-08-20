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
}
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int N = Integer.parseInt(br.readLine());
	    Node[] people = new Node[N+1];
	    int[] neighborhood = new int[N+1];
	    for (int i = 1; i < N+1; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = i;
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if(to == 0) break;
				people[from] = new Node(to, people[from]);
				neighborhood[from]++;
			}
		}
	    int[] rumorBelieveTime = new int[N+1];
	    Arrays.fill(rumorBelieveTime, -1);
	    int M = Integer.parseInt(br.readLine());
	    Queue<Integer> que = new ArrayDeque<>();
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    for (int i = 0; i < M; i++) {
	    	int tmp = Integer.parseInt(st.nextToken());
	    	rumorBelieveTime[tmp] = 0;
			que.offer(tmp);
		}
	    /// input end ///
	    int[] neighborRumorCnt = new int[N+1];
	    int time = 0;
	    Queue<Integer> checkQue = new ArrayDeque<>();
	    while(!que.isEmpty()) {
	    	time++;
	    	int queSize = que.size();
	    	while(queSize-- > 0) {
	    		int cur = que.poll();
		    	for (Node tmp = people[cur]; tmp != null; tmp = tmp.next) {
					if(rumorBelieveTime[tmp.to] > -1) continue;
					checkQue.offer(tmp.to);
					neighborRumorCnt[tmp.to]++;
				}
		    	while(!checkQue.isEmpty()) {
		    		int check = checkQue.poll();
		    		if(neighborRumorCnt[check] >= ((double)neighborhood[check] / 2.0)) {
		    			rumorBelieveTime[check] = time;
		    			que.offer(check);
		    		}
		    	}
	    	}
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i = 1; i < N+1; i++) {
	    	sb.append(rumorBelieveTime[i]).append(" ");
		}
	    bw.write(sb.toString());
	    
	    bw.flush();
	    bw.close();
	    br.close();
	}
}
