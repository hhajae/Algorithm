import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static List<List<Integer>> trees;
	static int[] nodes;
	private static void findMidOrder(int depth, int ind) {
		trees.get(depth-1).add(nodes[ind]);
		if(depth == 1) return;
		int ord = (int)Math.pow(2, depth-2);
		findMidOrder(depth-1, ind - ord);
		findMidOrder(depth-1, ind + ord);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		trees = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			trees.add(new ArrayList<>());
		}
		nodes = new int[(int)Math.pow(2, K)];
		for (int i = 1; i < Math.pow(2, K); i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}
		findMidOrder(K, (int)Math.pow(2, K-1));
		
		StringBuilder sb = new StringBuilder();
		for (int i = trees.size()-1; i >= 0; i--) {
			for (int j = 0; j < trees.get(i).size(); j++) {
				sb.append(trees.get(i).get(j)).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}