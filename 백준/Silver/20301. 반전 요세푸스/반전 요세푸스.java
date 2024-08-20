import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> deq = new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			deq.offer(i);
		}
		int cnt = 0;
		int elicnt = 0;
		boolean swc = false;
		StringBuilder sb = new StringBuilder();
		while(!deq.isEmpty()) {
			cnt++;
			int cur = -1;
			if(!swc) {
				cur = deq.pollFirst();
			}
			else {
				cur = deq.pollLast();
			}
			if(cnt % K == 0) {
				sb.append(cur).append("\n");
				elicnt++;
				if(elicnt % M == 0) {
					swc = !swc;
				}
				continue;
			}
			if(!swc) {
				deq.addLast(cur);
			}
			else {
				deq.addFirst(cur);
			}
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}
