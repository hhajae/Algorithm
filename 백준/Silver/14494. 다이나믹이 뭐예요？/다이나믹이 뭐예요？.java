import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int[][] board = new int[n+1][m+1];
	    for (int i = 0; i < n+1; i++) {
			Arrays.fill(board[i], 1);
		}
	    final int MOD = 1000_000_007;
	    for (int i = 2; i < n+1; i++) {
			for (int j = 2; j < m+1; j++) {
				board[i][j] = ((board[i-1][j] + board[i-1][j-1]) % MOD + board[i][j-1]) % MOD;
			}
		}
	    sb.append(board[n][m]);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
