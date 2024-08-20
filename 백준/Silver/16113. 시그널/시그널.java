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
		String s = br.readLine();
		if(N <= 10) {
			bw.write("1");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		int[][] board = new int[5][N / 5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < N/5; j++) {
				if(s.charAt((i*(N/5))+j) == '#') board[i][j] = 1;
				else board[i][j] = 0;
			}
		}
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < N/5; j++) {
//				bw.write(board[i][j] + " ");
//			}
//			bw.newLine();
//		}
//		bw.newLine();
		
		int[][][] mask = {{{1, 1, 1}, {1, 0, 1}, {1, 0, 1}, {1, 0, 1}, {1, 1, 1}}, // 0
				{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}}, // 1
				{{1, 1, 1}, {0, 0, 1}, {1, 1, 1}, {1, 0, 0}, {1, 1, 1}}, // 2
				{{1, 1, 1}, {0, 0, 1}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}}, // 3
				{{1, 0, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {0, 0, 1}}, // 4
				{{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}}, // 5
				{{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, // 6
				{{1, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}}, // 7
				{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, // 8
				{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}} // 9
				};
		StringBuilder sb = new StringBuilder();
		int oneCnt = 0, _oneCnt = 0;
		for (int i = 0; i < 5; i++) {
			if(board[i][0] == 1) oneCnt++;
			if(board[i][1] == 1) _oneCnt++;
		}
		if(oneCnt == 5 && _oneCnt == 0) sb.append(1);
		oneCnt = 0; _oneCnt = 0;
		for (int i = 0; i < N/5 - 2; i++) {
			int[][] tmpMask = new int[5][3];
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 3; k++) {
					tmpMask[j][k] = board[j][k+i];
				}
			}
			for (int j = 0; j < 10; j++) {
				int cnt = 0;
				for (int k = 0; k < 5; k++) {
					for (int m = 0; m < 3; m++) {
						if(tmpMask[k][m] == mask[j][k][m]) cnt++;
					}
				}
				if(cnt == 15) {
					sb.append(j);
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			if(board[i][N/5-1] == 1) oneCnt++;
			if(board[i][N/5-2] == 1) _oneCnt++;
		}
		if(oneCnt == 5 && _oneCnt == 0) sb.append(1);
		
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}
}