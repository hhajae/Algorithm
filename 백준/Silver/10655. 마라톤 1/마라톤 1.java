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
		int[][] checkPoints = new int[N][2];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			checkPoints[i][0] = Integer.parseInt(st.nextToken());
			checkPoints[i][1] = Integer.parseInt(st.nextToken());
		}
		int totalLength = 0;
		for (int i = 0; i < N-1; i++) {
			int x = checkPoints[i][0];
			int y = checkPoints[i][1];
			int nx = checkPoints[i+1][0];
			int ny = checkPoints[i+1][1];
			int length = Math.abs(x - nx) + Math.abs(y - ny);
			totalLength += length;
		}
		int minLength = Integer.MAX_VALUE;
		for (int i = 1; i < N-1; i++) {
			int tmpTotal = totalLength;
			int prev_x = checkPoints[i-1][0];
			int prev_y = checkPoints[i-1][1];
			int cur_x = checkPoints[i][0];
			int cur_y = checkPoints[i][1];
			int next_x = checkPoints[i+1][0];
			int next_y = checkPoints[i+1][1];
			int lengthA = Math.abs(prev_x - cur_x) + Math.abs(prev_y - cur_y);
			int lengthB = Math.abs(next_x - cur_x) + Math.abs(next_y - cur_y);
			tmpTotal -= lengthA + lengthB;
			int lengthC = Math.abs(next_x - prev_x) + Math.abs(next_y - prev_y);
			tmpTotal += lengthC;
			minLength = Math.min(tmpTotal, minLength);
		}
		bw.write(minLength + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}