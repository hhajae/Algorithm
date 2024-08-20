import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		/// input end ///
		Arrays.sort(meetings, (o1, o2) -> {
			if (o1[1] == o2[1]) return o1[0] - o2[0];
			return o1[1] - o2[1];
		});
//		for (int i = 0; i < N; i++) {
//			bw.write(meetings[i][0] + " " + meetings[i][1]);
//			bw.newLine();
//		}
		int resCnt = 1;
		int endTime = meetings[0][1];
		for (int i = 1; i < N; i++) {
			if (meetings[i][0] < endTime) continue;
			endTime = meetings[i][1];
			resCnt++;
		}
		bw.write(resCnt + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}