import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers;
	private static boolean isPalindrome(int start, int end) {
		for (int i = 0; i < (end-start+1) / 2; i++) {
			if(numbers[start + i] != numbers[end - i]) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    numbers = new int[N+1];
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    for (int i = 1; i < N+1; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
	    
	    int[][] D = new int[N+1][N+1];
	    for (int i = 1; i < N; i++) {
			for (int j = i+1; j < N+1; j++) {
				if(isPalindrome(i, j)) D[i][j] = 1;
				else D[i][j] = 0;
			}
		}
	    
	    int M = Integer.parseInt(br.readLine());
	    for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			if(S == E) {
				sb.append("1\n");
				continue;
			}
			sb.append(D[S][E]).append("\n");
		}
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
