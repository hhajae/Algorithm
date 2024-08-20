import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Crazy {
	static int[] dx = {0,  1, 1, 1,  0, 0, 0, -1, -1, -1};
	static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1,  0,  1};
	int x, y;
	
	public Crazy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void move(int cur_x, int cur_y, int R, int C) {
		int minDist = Integer.MAX_VALUE;
		int minDirect = 0;
		for (int i = 1; i <= 9; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			int dist = Math.abs(cur_x - nx) + Math.abs(cur_y - ny);
			if(minDist > dist) {
				minDist = dist;
				minDirect = i;
			}
		}
		this.x = x + dx[minDirect];
		this.y = y + dy[minDirect];
	}
	@Override
	public String toString() {
		return "Crazy [x=" + x + ", y=" + y + "]";
	}
}
public class Main {
	static int[] dx = {0,  1, 1, 1,  0, 0, 0, -1, -1, -1};
	static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1,  0,  1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		int curX = 0, curY = 0;
		List<Crazy> crazys = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j] == 'R') {
					crazys.add(new Crazy(i,j));
				}
				else if(board[i][j] == 'I') {
					curX = i; curY = j;
				}
				
			}
		}
		String moveStr = br.readLine();
		int endInd = 0;
		boolean lose = false;
		for (int i = 0; i < moveStr.length(); i++) {
			int d = moveStr.charAt(i) - '0';
			// 종수 움직여라
			board[curX][curY] = '.';
			curX = curX + dx[d];
			curY = curY + dy[d];
			endInd++;
			/// 종수 위치찍는건 미친놈 있는지 확인하고 나서
			// 미친놈있나없나
			if(board[curX][curY] == 'R') {
				lose = true;
				break;
			}
			board[curX][curY] = 'I'; // 종수 위치 찍고

			
			// 미친놈 옮기고
			int crazySize = crazys.size();
			int[][] checkCrazyBoard = new int[R][C];
			for (int j = 0; j < crazySize; j++) {
				if(lose) break;
				Crazy CurCrazy = crazys.get(j);
				if(CurCrazy.x == -1) continue;
				int nx = CurCrazy.x;
				int ny = CurCrazy.y;
				board[nx][ny] = '.';
				CurCrazy.move(curX, curY, R, C);
				nx = CurCrazy.x;
				ny = CurCrazy.y;
				if(nx == curX && ny == curY) {
					lose = true;
					break;
				}
				checkCrazyBoard[nx][ny]++;
			}
			if(lose) break;
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					if(checkCrazyBoard[j][k] == 0) continue;
					if(checkCrazyBoard[j][k] == 1) {
						board[j][k] = 'R';
						continue;
					}
					board[j][k] = '.';
					for (int m = 0; m < crazySize; m++) {
						Crazy CurCrazy = crazys.get(m);
						if(CurCrazy.x == -1) continue;
						int nx = CurCrazy.x;
						int ny = CurCrazy.y;
						if(nx == j && ny == k) CurCrazy.x = -1;
					}
				}
			}
			
		}
		
		if(lose) bw.write("kraj " + endInd);
		else {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					bw.write(board[i][j]);
				}
				bw.newLine();
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}