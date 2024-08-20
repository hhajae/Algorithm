import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int N, M;
	private static int tetromino(int x, int y) {
		int tmpMaxScore = 0;
		for (int i = 0; i < 19; i++) {
			int score = board[x][y];
			if(i == 0) {
				if(y+3 >= M) continue;
				score += board[x][y+1] + board[x][y+2] + board[x][y+3];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 1) {
				if(y + 1 >= M || x + 1 >= N) continue;
				score += board[x+1][y] + board[x][y+1] + board[x+1][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 2) {
				if(x+3 >= N) continue;
				score += board[x+1][y] + board[x+2][y] + board[x+3][y];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 3) {
				if(x+2 >= N || y+1 >= M) continue;
				score += board[x+1][y] + board[x+2][y] + board[x+2][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 4) {
				if(x+1 >= N || y+2 >= M) continue;
				score += board[x+1][y] + board[x][y+1] + board[x][y+2];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 5) {
				if(x+2 >= N || y+1 >= M) continue;
				score += board[x][y+1] + board[x+1][y+1] + board[x+2][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 6) {
				if(x-1 < 0 || y+2 >= M) continue;
				score += board[x][y+1] + board[x][y+2] + board[x-1][y+2];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 7) {
				if(x+2 >= N || y+1 >= M) continue;
				score += board[x][y+1] + board[x+1][y] + board[x+2][y];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 8) {
				if(x+1 >= N || y+2 >= M) continue;
				score += board[x][y+1] + board[x][y+2] + board[x+1][y+2];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 9) {
				if(x-2 < 0 || y+1 >= M) continue;
				score += board[x][y+1] + board[x-1][y+1] + board[x-2][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 10) {
				if(x+2 >= N || y+1 >= M) continue;
				score += board[x+1][y] + board[x+1][y+1] + board[x+2][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 11) {
				if(x-1 < 0 || y+2 >= M) continue;
				score += board[x][y+1] + board[x-1][y+1] + board[x-1][y+2];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 12) {
				if(x-1 < 0 || x+1 >= N || y+1 >= M) continue;
				score += board[x+1][y] + board[x][y+1] + board[x-1][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 13) {
				if(x+1 >= N || y+2 >= M) continue;
				score += board[x][y+1] + board[x+1][y+1] + board[x+1][y+2];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 14) {
				if(x+1 >= N || y+2 >= M) continue;
				score += board[x][y+1] + board[x][y+2] + board[x+1][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 15) {
				if(x-1 < 0 || x+1 >= N || y+1 >= M) continue;
				score += board[x][y+1] + board[x-1][y+1] + board[x+1][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 16) {
				if(x-1 < 0 || y+2 >= M) continue;
				score += board[x][y+1] + board[x-1][y+1] + board[x][y+2];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 17) {
				if(x-1 < 0 || x+1 >= N || y+1 >= M) continue;
				score += board[x-1][y] + board[x+1][y] + board[x][y+1];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
			if(i == 18) {
				if(x+1 >= N || y+2 >= M) continue;
				score += board[x+1][y] + board[x+1][y+1] + board[x+1][y+2];
				tmpMaxScore = Math.max(tmpMaxScore, score);
				continue;
			}
		}
		return tmpMaxScore;
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    board = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    int maxRes = 0;
	    for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maxRes = Math.max(maxRes, tetromino(i, j));
			}
		}
	    sb.append(maxRes);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
