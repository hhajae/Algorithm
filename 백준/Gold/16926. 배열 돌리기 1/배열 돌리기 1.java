import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static Deque<Integer> rotate(Deque<Integer> deq, int r) {
		int rot_num = r % deq.size();
		for (int i = 0; i < rot_num; i++) {
			deq.addLast(deq.pollFirst());
		}
		return deq;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// input end //
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			///// 돌면서 큐로 뺴내기 /////
			Deque<Integer> deqs = new LinkedList<>();
			int nx = i;
			int ny = i;
			int d = 0;
			deqs.addLast(arr[nx][ny]);
			do {
				int tmp_x = nx + dx[d];
				int tmp_y = ny + dy[d];
				if (tmp_x < i || (tmp_x >= N - i) || tmp_y < i || (tmp_y >= M - i))	{
					d++;
					nx = nx + dx[d];
					ny = ny + dy[d];
				}
				else {
					nx = tmp_x;
					ny = tmp_y;
				}
				deqs.addLast(arr[nx][ny]);
			} while (nx > i || ny > i);
			deqs.pollLast();
			///// 돌면서 큐로 빼내기 끝 /////

			///// 돌린 큐 받아서 배열 채우기 /////
			deqs = rotate(deqs, R);
			int nx1 = i;
			int ny1 = i;
			int d1 = 0;
			arr[nx1][ny1] = deqs.pollFirst();
			while (!deqs.isEmpty()) {
				int tmp_x = nx1 + dx[d1];
				int tmp_y = ny1 + dy[d1];
				if (tmp_x < i || (tmp_x >= N - i) || tmp_y < i || (tmp_y >= M - i))	{
					d1++;
					nx1 = nx1 + dx[d1];
					ny1 = ny1 + dy[d1];
				}
				else {
					nx1 = tmp_x;
					ny1 = tmp_y;
				}
				arr[nx1][ny1] = deqs.pollFirst();
			}
			///// 돌린 큐 받아서 배열 채우기 끝 /////
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}