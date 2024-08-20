import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int recur(int n, int[][] board) {
		if(n == 2) {
			int[] numbers = new int[4];
			numbers[0] = board[0][0]; numbers[1] = board[0][1];
			numbers[2] = board[1][0]; numbers[3] = board[1][1];
			Arrays.sort(numbers);
			return numbers[2];
		}
		int half = n / 2;
		int[] numbers = new int[4];
		for (int i = 0; i < 2; i++) {
			for (int i2 = 0; i2 < 2; i2++) {
				int[][] tmpBoard = new int[half][half];
				for (int j = 0; j < half; j++) {
					for (int k = 0; k < half; k++) {
						tmpBoard[j][k] = board[i * n/2 + j][i2 * n/2 + k];
					}
				}
				numbers[i*2 + i2] = recur(half, tmpBoard);
			}
		}
		Arrays.sort(numbers);
		return numbers[2];
		
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    int[][] board = new int[N][N];
	    for (int i = 0; i < N; i++) {
	    	String s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    /// input end ///
	    int res = recur(N, board);
	    sb.append(res);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
