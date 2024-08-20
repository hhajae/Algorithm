import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAXCOST = 100 * 100000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] city = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(city[i], MAXCOST);
		}
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			if(city[from][to] < cost) continue;
			city[from][to] = cost;
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if(i == k) continue;
				for (int j = 0; j < n; j++) {
					if(i == j) continue;
					city[i][j] = Math.min(city[i][k] + city[k][j], city[i][j]);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(city[i][j] == MAXCOST) sb.append("0 ");
				else sb.append(city[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
