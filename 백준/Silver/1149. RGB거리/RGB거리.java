import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int D = 0;
		int[] R = new int[N+1];
		int[] G = new int[N+1];
		int[] B = new int[N+1];
		int[][] house = new int[N+1][4]; // 1 RED, 2 GREEN, 3 BLUE
		
		for (int i = 1; i < N+1; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
			house[i][3] = Integer.parseInt(st.nextToken());
		}
		R[1] = house[1][1]; G[1] = house[1][2]; B[1] = house[1][3];
		
		for (int i = 2; i < N+1; i++) {
			R[i] = Math.min(G[i-1], B[i-1]) + house[i][1];
			G[i] = Math.min(R[i-1], B[i-1]) + house[i][2];
			B[i] = Math.min(R[i-1], G[i-1]) + house[i][3];
		}
		int tmp_D = Math.min(R[N], G[N]);
		D = Math.min(tmp_D, B[N]);
		
		bw.write(D + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}