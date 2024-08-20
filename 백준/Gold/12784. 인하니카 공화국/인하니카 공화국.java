import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	static int N;
	static Node[] islands;
	private static int dfs(int w, int vertex, boolean[] isvisited) {
//		System.out.println("w, vertex = " + w + ", " + vertex);
		int vertexNum = 0;
		for (Node tmp = islands[vertex]; tmp != null; tmp = tmp.next) {
			if(isvisited[tmp.to]) continue;
			vertexNum++;
		}
		if(vertexNum == 0) {
			return w;
		}
		int dfsSum = 0;
		for (Node tmp = islands[vertex]; tmp != null; tmp = tmp.next) {
			if(isvisited[tmp.to]) continue;
			isvisited[tmp.to] = true;
			dfsSum += dfs(tmp.weight, tmp.to, isvisited);
		}
		
		return Math.min(dfsSum, w);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 0; test_case < T; test_case++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			islands = new Node[N+1];
			for (int i = 0; i < M; i++) {
				s = br.readLine();
				st = new StringTokenizer(s, " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				islands[from] = new Node(to, weight, islands[from]);
				islands[to] = new Node(from, weight, islands[to]);
			}
			/// input end ///
//			for (Node tmp : islands) {
//				bw.write(tmp + "\n");
//			}
			int resSum1 = 0;
			for (Node tmp = islands[1]; tmp != null; tmp = tmp.next) {
				boolean[] isvisited = new boolean[N+1];
				isvisited[1] = true;
				isvisited[tmp.to] = true;
				resSum1 += dfs(tmp.weight, tmp.to, isvisited);
//				bw.write("i, sum = " + tmp.to + ", " + resSum1 + "\n");
			}
//			bw.write(resSum1 + "\n");
			sb.append(resSum1).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}
}