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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[][] pictures = new int[R+1][C+1];
		for (int i = 1; i < R + 1; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 1; j < C + 1; j++) {
				pictures[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> startQue = new ArrayDeque<>();
		Queue<int[]> endQue = new ArrayDeque<>();
		for (int i = 0; i < Q; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			startQue.offer(new int[] {start_x, start_y});
			endQue.offer(new int[] {end_x, end_y});
		}
		/// input end ///
		int[][] AccSum = new int[R+1][C+1];
		for (int i = 1; i < R+1; i++) {
			for (int j = 1; j < C+1; j++) {
				AccSum[i][j] = pictures[i][j] + AccSum[i-1][j] + AccSum[i][j-1] - AccSum[i-1][j-1];
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!startQue.isEmpty()) {
			int[] start = startQue.poll();
			int start_x = start[0];
			int start_y = start[1];
			int[] end = endQue.poll();
			int end_x = end[0];
			int end_y = end[1];
			int sum = AccSum[end_x][end_y]
					- AccSum[start_x-1][end_y] - AccSum[end_x][start_y-1]
							+ AccSum[start_x-1][start_y-1];
			int num = (end_y - start_y + 1) * (end_x - start_x + 1);
			sb.append(sum/num).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}