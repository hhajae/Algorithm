import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	final static int N = 9;
	static int[][] sdoku;
	static int zeroCnt = 0;
	static int[][] resBoard;
	private static boolean isOk(int[][] board, int x, int y, int n) {
		boolean[] isvisitedRow = new boolean[N+1];
		boolean[] isvisitedCol = new boolean[N+1];
		boolean[] isvisitedRC = new boolean[N+1];
		
		board[x][y] = n;

		/// row 
		for (int i = 0; i < N; i++) {
			if(board[x][i] == 0) continue;
			if(isvisitedRow[board[x][i]]) return false;
			isvisitedRow[board[x][i]] = true;
		}
		
		// col
		for (int i = 0; i < N; i++) {
			if(board[i][y] == 0) continue;
			if(isvisitedCol[board[i][y]]) return false;
			isvisitedCol[board[i][y]] = true;
		}
		// 3x3
		if(x % 3 == 0) {
			if(y % 3 == 0) {
				for (int i = x; i <= x+2; i++) {
					for (int j = y; j <= y+2; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
			else if (y % 3 == 1) {
				for (int i = x; i <= x+2; i++) {
					for (int j = y-1; j <= y+1; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
			else if (y % 3 == 2){
				for (int i = x; i <= x+2; i++) {
					for (int j = y-2; j <= y; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
		}
		else if(x % 3 == 1) {
			if(y % 3 == 0) {
				for (int i = x-1; i <= x+1; i++) {
					for (int j = y; j <= y+2; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
			else if (y % 3 == 1) {
				for (int i = x-1; i <= x+1; i++) {
					for (int j = y-1; j <= y+1; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
			else if (y % 3 == 2){
				for (int i = x-1; i <= x+1; i++) {
					for (int j = y-2; j <= y; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
		}
		else if(x % 3 == 2) {
			if(y % 3 == 0) {
				for (int i = x-2; i <= x; i++) {
					for (int j = y; j <= y+2; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
			else if (y % 3 == 1) {
				for (int i = x-2; i <= x; i++) {
					for (int j = y-1; j <= y+1; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
			else if (y % 3 == 2){
				for (int i = x-2; i <= x; i++) {
					for (int j = y-2; j <= y; j++) {
						if(board[i][j] == 0) continue;
						if(isvisitedRC[board[i][j]]) return false;
						isvisitedRC[board[i][j]] = true;
					}
				}
			}
		}
		return true;
	}
	static boolean globalSwc = false;
	private static void dfs(int cnt, int[][] board) {
		if(cnt == zeroCnt) {
			globalSwc = true;
			resBoard = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					resBoard[i][j] = board[i][j];
				}
			}
		}
		int[][] tmpBoard = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmpBoard[i][j] = board[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(tmpBoard[i][j] != 0) continue;
				for (int k = 1; k <= N; k++) {
					if(isOk(tmpBoard, i, j, k)) {
//						System.out.println("i, j, k = " + i + ", " + j + ", " + k);
						tmpBoard[i][j] = k;
						dfs(cnt+1, tmpBoard);
						if(globalSwc) return;
					}
					else tmpBoard[i][j] = 0;
				}
				return;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		sdoku = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				sdoku[i][j] = s.charAt(j) - '0';
				if(sdoku[i][j] == 0) zeroCnt++;
			}
		}
//		bw.write(zeroCnt + "\n");
		dfs(0, sdoku);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(resBoard[i][j]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}