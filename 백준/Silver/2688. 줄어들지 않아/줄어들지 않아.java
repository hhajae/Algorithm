import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] memo;
	private static long nCr(int n, int r) {
		if(n == r) return 1;
		if(r == 1) return n;
		if(memo[n][r] == -1) {
			return memo[n][r] = nCr(n-1, r) + nCr(n-1, r-1);	
		}
		return memo[n][r];
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		long[] D = new long[65];
		memo = new long[100][100];
		for (int i = 0; i < 100; i++) {
			Arrays.fill(memo[i], -1);
		}
		for (int i = 1; i < 65; i++) {
			D[i] = nCr(10 + i - 1, i);
		}
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(D[n]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
