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

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] numbers = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int rowsum = 0;
			for (int j = 1; j < N+1; j++) {
				int n = Integer.parseInt(st.nextToken());
				numbers[i][j] = numbers[i-1][j] + rowsum + n;
				rowsum += n;
			}
		}
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int res = numbers[x2][y2] - numbers[x1-1][y2] -
					numbers[x2][y1-1] + numbers[x1-1][y1-1];
			bw.write(res + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}