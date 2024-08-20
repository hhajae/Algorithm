import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] grid = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 1; j < N+1; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<String> moves = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			moves.add(br.readLine());
		}
		/// input end ///
		Queue<Integer> que_x = new ArrayDeque<>();
		Queue<Integer> que_y = new ArrayDeque<>();
		que_x.add(N); que_y.add(1);
		que_x.add(N); que_y.add(2);
		que_x.add(N-1); que_y.add(1);
		que_x.add(N-1); que_y.add(2);
		int[] dirX = {0, 0, -1, -1, -1, 0, 1, 1, 1};
		int[] dirY = {0, -1, -1, 0, 1, 1, 1, 0, -1};
					  // 1   2   3  4  5  6  7   8
		while(!moves.isEmpty()) {
			s = moves.poll();
			st = new StringTokenizer(s, " ");
			int dir = Integer.parseInt(st.nextToken());
			int moveSize = Integer.parseInt(st.nextToken());
			/// setting end ///
			
			/// 1. move cloud by dir, moveSize ///
			int cloudSize = que_x.size();
			for (int i = 0; i < cloudSize; i++) {
				int cur_x = que_x.poll();
				int cur_y = que_y.poll();
				cur_x = cur_x + moveSize * dirX[dir];
				cur_y = cur_y + moveSize * dirY[dir];
				
				cur_x = (cur_x + N*100) % N;
				if (cur_x == 0) cur_x = N;
				cur_y = (cur_y + N*100) % N;
				if (cur_y == 0) cur_y = N;
				que_x.add(cur_x); que_y.add(cur_y);
			}
			
			/// 2. water + 1 in cloud ///
			for (int i = 0; i < cloudSize; i++) {
				int cur_x = que_x.poll(); /// 3. disappear cloud
				int cur_y = que_y.poll();
				grid[cur_x][cur_y] += 1;
				que_x.add(cur_x); que_y.add(cur_y);
			}
			
			/// 4. copy water magic ///
			boolean[][] checkCloud = new boolean[N+1][N+1];
			int[] copy_dx = {-1, -1, 1, 1};
			int[] copy_dy = {-1, 1, -1, 1};
			for (int i = 0; i < cloudSize; i++) {
				int cur_x = que_x.poll();
				int cur_y = que_y.poll();
				int copyCnt = 0;
				for (int j = 0; j < 4; j++) {
					int nx = cur_x + copy_dx[j];
					int ny = cur_y + copy_dy[j];
					if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
					if (grid[nx][ny] > 0) copyCnt++;
				}
				grid[cur_x][cur_y] += copyCnt;
				checkCloud[cur_x][cur_y] = true; // 5에 쓸거
			}
			
			/// 5. create cloud ///
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if (grid[i][j] >= 2 && !checkCloud[i][j]) {
						grid[i][j] -= 2;
						que_x.add(i); que_y.add(j);
					}
				}
			}
		}
		int resCnt = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				resCnt += grid[i][j];
//				bw.write(grid[i][j] + " ");
			}
//			bw.newLine();
		}
		bw.write(resCnt + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}