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
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    int[][] board = new int[N][3];
	    for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
			board[i][2] = Integer.parseInt(st.nextToken());
		}
	    int[][] maxScore = new int[N][3];
	    int[][] minScore = new int[N][3];
	    maxScore[0][0] = board[0][0]; maxScore[0][1] = board[0][1]; maxScore[0][2] = board[0][2];
	    minScore[0][0] = board[0][0]; minScore[0][1] = board[0][1]; minScore[0][2] = board[0][2];
	    for (int i = 1; i < N; i++) {
			maxScore[i][0] = Math.max(maxScore[i-1][0], maxScore[i-1][1]) + board[i][0];
			maxScore[i][1] = Math.max(maxScore[i-1][0], Math.max(maxScore[i-1][1], maxScore[i-1][2])) + board[i][1];
			maxScore[i][2] = Math.max(maxScore[i-1][1], maxScore[i-1][2]) + board[i][2];
			
			minScore[i][0] = Math.min(minScore[i-1][0], minScore[i-1][1]) + board[i][0];
			minScore[i][1] = Math.min(minScore[i-1][0], Math.min(minScore[i-1][1], minScore[i-1][2])) + board[i][1];
			minScore[i][2] = Math.min(minScore[i-1][1], minScore[i-1][2]) + board[i][2];
		}
	    int resMax = Math.max(maxScore[N-1][0], Math.max(maxScore[N-1][1], maxScore[N-1][2]));
	    int resMin = Math.min(minScore[N-1][0], Math.min(minScore[N-1][1], minScore[N-1][2]));
	    sb.append(resMax).append(" ").append(resMin);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
