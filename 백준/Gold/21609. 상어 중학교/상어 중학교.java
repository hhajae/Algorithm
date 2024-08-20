import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	static final int EmptySpace = 100;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static void rotate() { // 완료
		int[][] tmpBoard = new int[N][N];
		int row = 0;
		int col = 0;
		for (int i = N-1; i >= 0; i--) {
			col = 0;
			for (int j = 0; j < N; j++) {
				tmpBoard[row][col++] = board[j][i];
			}
			row++;
		}
		board = tmpBoard;
	}
	private static void gravity() {
		int dx = 1;
		for (int i = N-2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == -1) continue;
				if(board[i][j] == EmptySpace) continue;
				int cur = board[i][j];
				int movePos = 0;
				for (int k = 0; k < N-i-1; k++) {
					int nx = i + (k + dx);
					if(board[nx][j] != EmptySpace) break;
					movePos = k + dx;
				}
				if(movePos == 0) continue;
				board[i+movePos][j] = cur;
				board[i][j] = EmptySpace;
			}
		}
	}
	private static Queue<int[]> findBlockGroup() {
		Queue<int[]> resQue = new ArrayDeque<>(); // 결과 리턴할 큐
		// 방문 체크(무지개색은 끝나고 다시 돌려줘야함)
		boolean[][] isvisited = new boolean[N][N];
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		int maxGroupSize = 0;
		int maxGroupRainbowCnt = 0;
		int maxStandardRow = Integer.MAX_VALUE, maxStandardCol = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == -1 || board[i][j] == 0 || board[i][j] == EmptySpace) continue;
				if(isvisited[i][j]) continue;
				isvisited[i][j] = true;
				int curBlock = board[i][j];
				boolean[][] isBlockGroup = new boolean[N][N];
				int groupSize = 1;
				int rainbowCnt = 0;
				int standardRow = i, standardCol = j;
				que_x.offer(i); que_y.offer(j);
				isBlockGroup[i][j] = true;
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					for (int k = 0; k < 4; k++) {
						int nx = cur_x + dx[k];
						int ny = cur_y + dy[k];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(isvisited[nx][ny]) continue;
						if(board[nx][ny] == -1) continue;
						if((board[nx][ny] != curBlock) && (board[nx][ny] != 0)) continue;
						isvisited[nx][ny] = true;
						isBlockGroup[nx][ny] = true;
						que_x.offer(nx); que_y.offer(ny);
						groupSize++;
						if(board[nx][ny] == 0) rainbowCnt++;
					}
				}
				if(groupSize < 2) continue;
				if(groupSize < maxGroupSize) {
					for (int k = 0; k < N; k++) {
						for (int k2 = 0; k2 < N; k2++) {
							if(board[k][k2] == 0 && isvisited[k][k2]) isvisited[k][k2] = false;
						}
					}
					continue;	
				}
				if(groupSize > maxGroupSize) {
					resQue.clear();
					maxGroupSize = groupSize;
					maxGroupRainbowCnt = rainbowCnt;
					maxStandardRow = i;
					maxStandardCol = j;
					for (int k = 0; k < N; k++) {
						for (int k2 = 0; k2 < N; k2++) {
							if(board[k][k2] == 0 && isvisited[k][k2]) isvisited[k][k2] = false;
							if(isBlockGroup[k][k2]) resQue.offer(new int[]{k, k2});
						}
					}
				}
				else if (groupSize == maxGroupSize) {
					if(rainbowCnt < maxGroupRainbowCnt) {
						for (int k = 0; k < N; k++) {
							for (int k2 = 0; k2 < N; k2++) {
								if(board[k][k2] == 0 && isvisited[k][k2]) isvisited[k][k2] = false;
							}
						}
						continue;
					}
					if(rainbowCnt > maxGroupRainbowCnt) {
						resQue.clear();
						maxGroupSize = groupSize;
						maxGroupRainbowCnt = rainbowCnt;
						maxStandardRow = i;
						maxStandardCol = j;
						for (int k = 0; k < N; k++) {
							for (int k2 = 0; k2 < N; k2++) {
								if(board[k][k2] == 0 && isvisited[k][k2]) isvisited[k][k2] = false;
								if(isBlockGroup[k][k2]) resQue.offer(new int[]{k, k2});
							}
						}
					}
					else if(rainbowCnt == maxGroupRainbowCnt) {
						resQue.clear();
						maxGroupSize = groupSize;
						maxGroupRainbowCnt = rainbowCnt;
						maxStandardRow = i;
						maxStandardCol = j;
						for (int k = 0; k < N; k++) {
							for (int k2 = 0; k2 < N; k2++) {
								if(board[k][k2] == 0 && isvisited[k][k2]) isvisited[k][k2] = false;
								if(isBlockGroup[k][k2]) resQue.offer(new int[]{k, k2});
							}
						}
					}
				}
			}
		}
		if(maxGroupSize == 0) return null;
		return resQue;
	} 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/// input end ///
		Queue<int[]> que = new ArrayDeque<>();
		boolean queSwc = true;
		int resScore = 0;
		while(queSwc) {
			que = findBlockGroup();
			if(que == null) break;
			int queSize = que.size();
			resScore += queSize * queSize;
			while(!que.isEmpty()) {
				int[] tmp = que.poll();
				int nx = tmp[0], ny = tmp[1];
				board[nx][ny] = EmptySpace;
			}
			gravity();
			rotate();
			gravity();
		}
		bw.write(resScore + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}