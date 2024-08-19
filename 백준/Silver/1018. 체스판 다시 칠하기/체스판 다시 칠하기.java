import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int minRes = Integer.MAX_VALUE;
	private static void ischessboard(char[][] board) {
		char[] White = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
		char[] Black = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
		int cnt = 0;		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(i % 2 == 0) {
					if(board[i][j] == White[j]) continue;
					cnt++;
				}
				else {
					if(board[i][j] == Black[j]) continue;
					cnt++;
				}
			}
		}
		minRes = Math.min(minRes, cnt);
		cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(i % 2 == 0) {
					if(board[i][j] == Black[j]) continue;
					cnt++;
				}
				else {
					if(board[i][j] == White[j]) continue;
					cnt++;
				}
			}
		}
		minRes = Math.min(minRes, cnt);
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    char[][] board = new char[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}

	    }
	    
	    /// input end ///
	    for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				char[][] tmpboard = new char[8][8];
				int rcnt = 0;
				for (int k = i; k < i+8; k++) {
					int ccnt = 0;
					for (int m = j; m < j+8; m++) {
						tmpboard[rcnt][ccnt++] = board[k][m];
					}
					rcnt++;
				}
				ischessboard(tmpboard);
			}
		}
	    bw.write(minRes + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}