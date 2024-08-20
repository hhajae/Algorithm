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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		char[][] boardB = new char[N][M];
		char[][] boardW = new char[N][M];
		boardB[0][0] = 'B'; boardW[0][0] = 'W';
		for (int i = 1; i < N; i++) {
			if(boardB[i-1][0] == 'B') boardB[i][0] = 'W';
			else if(boardB[i-1][0] == 'W') boardB[i][0] = 'B';
			if(boardW[i-1][0] == 'B') boardW[i][0] = 'W';
			else if(boardW[i-1][0] == 'W') boardW[i][0] = 'B';
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < M; j++) {
				if(boardB[i][j-1] == 'B') boardB[i][j] = 'W';
				else if(boardB[i][j-1] == 'W') boardB[i][j] = 'B';
				if(boardW[i][j-1] == 'B') boardW[i][j] = 'W';
				else if(boardW[i][j-1] == 'W') boardW[i][j] = 'B';
			}
		}
		int[][][] boardBW = new int[N+1][M+1][2];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				if(board[i-1][j-1] != boardB[i-1][j-1]) {
					boardBW[i][j][0] = boardBW[i-1][j][0] + boardBW[i][j-1][0] - boardBW[i-1][j-1][0] + 1;
				}
				else {
					boardBW[i][j][0] = boardBW[i-1][j][0] + boardBW[i][j-1][0] - boardBW[i-1][j-1][0];
				}
				if(board[i-1][j-1] != boardW[i-1][j-1]) {
					boardBW[i][j][1] = boardBW[i-1][j][1] + boardBW[i][j-1][1] - boardBW[i-1][j-1][1] + 1;
				}
				else {
					boardBW[i][j][1] = boardBW[i-1][j][1] + boardBW[i][j-1][1] - boardBW[i-1][j-1][1];
				}
			}
		}
		int minSquare = Integer.MAX_VALUE;
		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				int B = boardBW[i][j][0] - 
						boardBW[i-K][j][0] - boardBW[i][j-K][0] + boardBW[i-K][j-K][0];
				int W = boardBW[i][j][1] - 
						boardBW[i-K][j][1] - boardBW[i][j-K][1] + boardBW[i-K][j-K][1];
				minSquare = Math.min(minSquare, Math.min(W, B));
			}
		}
		sb.append(minSquare);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
