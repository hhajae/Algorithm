import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int to, weight;
	Node next;
	public Node(int to, int weight, Node next) {
		super();
		this.to = to;
		this.weight = weight;
		this.next = next;
	}
	public Node(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Node [to=" + to + ", weight=" + weight + ", next=" + next + "]";
	}
}
public class Main {
	static int N, robotA, robotB;
	static Node[] cave;
	static boolean meetSwc = false;
	static int meetWeight = 0;
	static boolean[] isvisited;
	private static void dfs(int start, int w, int maxW) {
		if(meetSwc) return;
		if(start == robotB) {
			meetSwc = true;
			meetWeight = w - maxW;
			return;
		}
		
		for (Node tmp = cave[start]; tmp != null; tmp = tmp.next) {
			if(isvisited[tmp.to]) continue;
			isvisited[tmp.to] = true;
			int tmpMaxW = Math.max(maxW, tmp.weight);
			dfs(tmp.to, w + tmp.weight, tmpMaxW);
			if(meetSwc) return;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		robotA = Integer.parseInt(st.nextToken());
		robotB = Integer.parseInt(st.nextToken());
		cave = new Node[N+1];
		for (int i = 0; i < N-1; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			cave[from] = new Node(to, weight, cave[from]);
			cave[to] = new Node(from, weight, cave[to]);
		}
		/// input end ///
		isvisited = new boolean[N+1];
		isvisited[robotA] = true;
		dfs(robotA, 0, 0);
		
		int minRes = meetWeight;
		bw.write(minRes + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}